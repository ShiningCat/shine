package com.shine.user.action.token;


import com.shine.cm.common.bean.business.token.Token;
import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.cm.service.user.token.TokenManager;
import com.shine.common.util.MD5;
import com.shine.common.vo.ResultDO;

import com.shine.user.mapper.business.BMemUserInfoMapper;
import com.shine.user.mapper.business.BMemUserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenAction {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private BMemUserInfoMapper bMemUserInfoMapper;

    @Autowired
    private BMemUserLoginMapper bMemUserLoginMapper;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResultDO<Token> login(@RequestParam String email, @RequestParam String password ){
        String salt = bMemUserLoginMapper.getSaltByEmail(email);
        if(salt == null){
            return new ResultDO<Token>(false,"邮箱未注册");
        }
        String md5Password = MD5.md5WithSalt(password,salt);
        TMemUserInfo userInfo = bMemUserInfoMapper.selectUserByCheckPassword(email,md5Password);
        if(userInfo == null){
            return new ResultDO<Token>(false,"密码错误");
        }
        Token token = tokenManager.createToken(userInfo);
        return new ResultDO<Token>(token);
    }
    @RequestMapping(value = "/token", method = RequestMethod.DELETE)
    public ResultDO<String> logout(@RequestParam String token){
        boolean dt = tokenManager.deleteToken(token);
        if (!dt) {
            return new ResultDO<>(false,"登出失败,token不存在");
        }
        return new ResultDO<>("登出成功");
    }
}
