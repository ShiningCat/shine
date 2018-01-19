package com.shine.user.feign.token;

import com.shine.cm.common.bean.business.token.Token;
import com.shine.common.util.verification.CaptchaBean;
import com.shine.common.vo.ResultDO;
import org.springframework.stereotype.Component;

@Component
public class TokenFallbark implements TokenFeign {
    @Override
    public ResultDO<Token> login(String email, String password) {
        return null;
    }

    @Override
    public ResultDO<String> logout(String token) {
        return null;
    }

}
