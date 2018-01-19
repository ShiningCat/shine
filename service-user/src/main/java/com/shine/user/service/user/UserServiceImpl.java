package com.shine.user.service.user;

import com.github.pagehelper.PageHelper;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.cm.common.bean.db.TMemUserLogin;
import com.shine.cm.service.user.UserService;
import com.shine.common.entity.RedisBean;
import com.shine.common.util.MD5;
import com.shine.common.util.Regex;
import com.shine.common.util.SerializeUtil;
import com.shine.common.util.mailutil.Mail;
import com.shine.common.util.mailutil.MailUtil;
import com.shine.common.util.thread.ThreadFactory;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

import com.shine.user.fegin.RedisFeign;
import com.shine.user.mapper.business.BForumThemeInfoMapper;
import com.shine.user.mapper.business.BMemUserInfoMapper;
import com.shine.user.mapper.business.BMemUserLoginMapper;
import com.shine.user.mapper.db.TMemUserInfoMapper;
import com.shine.user.mapper.db.TMemUserLoginMapper;
import com.shine.user.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl extends BaseService implements UserService {


    @Autowired
    private RedisFeign redisFeign;

    @Autowired
    private BForumThemeInfoMapper bForumThemeInfoMapper;

    @Autowired
    private TMemUserLoginMapper tMemUserLoginMapper;

    @Autowired
    private TMemUserInfoMapper tMemUserInfoMapper;

    @Autowired
    private BMemUserLoginMapper bMemUserLoginMapper;

    @Autowired
    private BMemUserInfoMapper bMemUserInfoMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT, rollbackFor = { Exception.class })
    public ResultDO<TMemUserInfo> createUser(TMemUserLogin userLogin) {
        int registeredFlag;
        if (userLogin.getUserName().length() < 3 ||  userLogin.getUserName().length() > 10 ) {
            return new ResultDO<>(false,"昵称不合法!");
        }
        if ( userLogin.getPassword().length() < 6 || userLogin.getPassword().length() > 16 ){
            return new ResultDO<>(false,"密码格式错误!");
        }
        if (!userLogin.getEmail().matches(Regex.email)){
            return new ResultDO<>(false,"邮箱格式错误!");
        }
        int nameCount = bMemUserInfoMapper.getUserByName(userLogin.getUserName());
        if (nameCount != 0){
            return new ResultDO<>(false,"昵称已被注册!");
        }
        TMemUserInfo user = bMemUserInfoMapper.selectByEmail(userLogin.getEmail());
        TMemUserInfo userInfo = new TMemUserInfo();
        if (user != null){
            if (user.getDelFlag() == 1){
                return new ResultDO<>(false,"邮箱已被注册!");
            } else {
                // registeredFlag = 1 修改未验证的账号
                registeredFlag = 2;
                userLogin.setUserId(user.getUserId());
                userInfo.setUserId(user.getUserId());
            }
        } else {
            // 新增账号
            registeredFlag = 1;
        }
        userLogin.setCreatorUserName(userLogin.getUserName());
        userLogin.setModifierUserName(userLogin.getUserName());
        userLogin.setDelFlag((byte) 2);

        userInfo.setEmail(userLogin.getEmail());
        userInfo.setUserName(userLogin.getUserName());
        userInfo.setModifierUserName(userLogin.getUserName());
        userInfo.setCreatorUserName(userLogin.getUserName());
        userInfo.setDelFlag((byte) 2);
        //加盐加密.
        String salt = MD5.generateSalt();
        String code  = MD5.md5WithSalt(userInfo.getEmail(), salt);
        String password = MD5.md5WithSalt(userLogin.getPassword(),salt);
        userLogin.setPassword(password);
        userLogin.setPasswordSalt(salt);

        redisFeign.putRedis(new RedisBean("email:confirm:" + code, userInfo.getEmail(), 86400L));

        Mail mail = new Mail();
        mail.setSubject("账号激活");
        mail.setMessage("您好，请在 24 小时内点击此链接以完成激活 " +
                "http://localhost:8080/confirm_verification/" + code );
        mail.setReceiver(userInfo.getEmail());

        ThreadFactory.execute(new Runnable() {
            @Override
            public void run() {
                MailUtil.intiSend(mail);
            }
        });
        try {
            if (registeredFlag == 2){
                rollBack(tMemUserInfoMapper.updateByPrimaryKeySelective(userInfo));
                rollBack(tMemUserLoginMapper.updateByPrimaryKeySelective(userLogin));
            } else {
                rollBack(bMemUserInfoMapper.insertSelectiveReturnKey(userInfo));
                userLogin.setUserId(userInfo.getUserId());
                rollBack(tMemUserLoginMapper.insertSelective(userLogin));
            }
            return new ResultDO<TMemUserInfo>(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            rollBack();
            return new ResultDO<TMemUserInfo>(false,"注册失败");
        }
    }

    @Override
    public ResultDO<PageBean<TForumThemeInfo>> getUserThemes(Long userId,Integer limit,Integer page) {
        PageHelper.startPage(page, limit);
        List<TForumThemeInfo> list = bForumThemeInfoMapper.selectByUserId(userId);
        return new ResultDO<PageBean<TForumThemeInfo>>(new PageBean<>(list));
    }

    @Override
    public ResultDO<String> resetPassword(String email, String newPassword) {
        String salt = MD5.generateSalt();
        String password = MD5.md5WithSalt(newPassword,salt);
        Integer count = bMemUserLoginMapper.resetPassword(email, password, salt);
        if(count != 1){
            return new ResultDO<String>(false,"密码修改失败");
        }
        return new ResultDO<String>("密码修改成功");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT, rollbackFor = { Exception.class })
    public ResultDO<Boolean> confirmUser (String mail){
        Integer info  = bMemUserInfoMapper.setUserStatus(mail);
        Integer login = bMemUserLoginMapper.setUserStatus(mail);
        if(info != 1 || login != 1){
            rollBack();
            return new ResultDO<>(false,"验证失败!未知的错误");
        }
        return new ResultDO<>();
    }
}
