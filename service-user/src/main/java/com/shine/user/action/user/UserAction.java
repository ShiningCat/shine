package com.shine.user.action.user;

import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.cm.common.bean.db.TMemUserLogin;
import com.shine.cm.service.redis.IRedisService;
import com.shine.cm.service.user.UserService;
import com.shine.common.entity.RedisBean;
import com.shine.common.util.JSONUtil;
import com.shine.common.util.MD5;
import com.shine.common.util.SerializeUtil;
import com.shine.common.util.StringUtil;
import com.shine.common.util.mailutil.Mail;
import com.shine.common.util.mailutil.MailUtil;
import com.shine.common.util.thread.ThreadFactory;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

import com.shine.user.fegin.RedisFeign;
import com.shine.user.mapper.business.BMemUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * GetMapping PostMapping PutMapping DeleteMapping
 * @GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。该注解将HTTP Get 映射到 特定的处理方法上。
 * RESTful API
 * GET /collection：返回资源对象的列表（数组）
 * GET /collection/resource：返回单个资源对象
 * POST /collection：返回新生成的资源对象
 * PUT /collection/resource：返回完整的资源对象
 * PATCH /collection/resource：返回完整的资源对象
 * DELETE /collection/resource：返回一个空文档
 */

@RestController
public class UserAction {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisFeign redisFeign;

    @Autowired
    private BMemUserInfoMapper bMemUserInfoMapper;

    @RequestMapping(value = "/{userId}/themes",method = RequestMethod.GET)
    ResultDO<PageBean<TForumThemeInfo>> getUserThemes(@PathVariable Long userId, @RequestParam Integer limit, @RequestParam Integer page){

        return userService.getUserThemes(userId,limit,page);
    }

    @RequestMapping(value = "/creation" ,method = RequestMethod.POST)
    ResultDO<TMemUserInfo> creationUser(@RequestBody TMemUserLogin userLoginBean){
        return userService.createUser(userLoginBean);
    }

    @RequestMapping(value = "/confirm_verification/{code}" ,method = RequestMethod.GET)
    ResultDO<Boolean> confirmUser(@PathVariable String code){
        RedisBean redisBean = redisFeign.getRedis("email:confirm:"+ code);
        if(redisBean == null || redisBean.getValue() == null ){
            return new ResultDO<>(false, "验证失败,过期或无效的验证链接");
        }
        redisFeign.delRedis("email:confirm:"+ code);
        return userService.confirmUser(redisBean.getValue().toString());
    }

    /**
     * 发送找回密码邮件
     * @param email
     * @return
     */
    @RequestMapping(value = "/reset-password/mail" ,method = RequestMethod.POST)
    ResultDO<Boolean> sendMsg (@RequestParam String email){
        TMemUserInfo userInfo = bMemUserInfoMapper.selectByEmail(email);
        if(userInfo == null){
            return new ResultDO<>(false, "该邮箱还没有注册过");
        }
        String code  = MD5.md5WithSalt(email, System.currentTimeMillis()+"");
        redisFeign.setRedis(new RedisBean("password:reset:" + code, email,(long) 86400));
        Mail mail = new Mail();
        mail.setSubject("密码重置");
        mail.setMessage("您好，请在 24 小时内点击此链接以重置密码 " +
                "http://localhost:8080/reset-password/" + code);
        mail.setReceiver(email);
        ThreadFactory.execute(new Runnable() {
            @Override
            public void run() {
                MailUtil.intiSend(mail);
            }
        });
        return new ResultDO<>();
    }

    /**
     * 找回密码页面
     * @param code
     * @return
     */
    @RequestMapping(value = "/reset-password/{code}", method = RequestMethod.GET)
    ResultDO<String> restPassword(@PathVariable String code){
        RedisBean redisBean = redisFeign.getRedis("password:reset:" + code);
        if(redisBean == null || redisBean.getValue() == null ){
            return new ResultDO<>(false, "错误,过期或无效的重置密码链接");
        }
        return new ResultDO<String>(redisBean.getValue().toString());
    }

    /**
     * 重置密码提交
     * @return
     */
    @RequestMapping(value = "/reset-password" , method = RequestMethod.POST)
    ResultDO<String> resetPassword(@RequestParam String code, @RequestParam String password ){
        RedisBean redisBean = redisFeign.getRedis("password:reset:" + code);
        if(redisBean == null || redisBean.getValue() == null ){
            return new ResultDO<String>(false, "错误,过期或无效的重置密码链接");
        }
        ResultDO<String> re = userService.resetPassword(redisBean.getValue().toString(), password);
        if (re.getSuccess()){
            Boolean flag = redisFeign.delRedis("password:reset:" + code);
        }
        return re;
    }

}
