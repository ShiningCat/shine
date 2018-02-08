package com.shine.user.action.token;


import com.shine.cm.common.bean.business.token.Token;
import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.common.util.MD5;
import com.shine.common.vo.ResultDO;

import com.shine.user.mapper.business.BMemUserInfoMapper;
import com.shine.user.mapper.business.BMemUserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenAction {

    @Autowired
    private BMemUserInfoMapper bMemUserInfoMapper;

    @Autowired
    private BMemUserLoginMapper bMemUserLoginMapper;

    @PostMapping(value = "/tokens")
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
        return new ResultDO<Token>(new Token(userInfo));
    }
}
