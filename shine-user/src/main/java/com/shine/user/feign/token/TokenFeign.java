package com.shine.user.feign.token;

import com.shine.cm.common.bean.business.token.Token;
import com.shine.common.util.verification.CaptchaBean;
import com.shine.common.vo.ResultDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-user", fallback = TokenFallbark.class)
public interface TokenFeign {

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    ResultDO<Token> login (@RequestParam(value = "email") String email, @RequestParam(value = "password") String password);

    @RequestMapping(value = "/token", method = RequestMethod.DELETE)
    ResultDO<String> logout(@RequestParam(value = "token") String token);

}
