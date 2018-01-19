package com.shine.user.controller.token;

import com.shine.cm.common.bean.business.token.Token;

import com.shine.cm.common.bean.business.user.LoginValidationBean;
import com.shine.common.util.verification.CaptchaBean;
import com.shine.common.vo.ResultDO;
import com.shine.user.controller.BaseController;
import com.shine.user.controller.verification.VerifyCaptcha;
import com.shine.user.feign.token.TokenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/token")
public class TokenController extends BaseController {

    @Autowired
    private TokenFeign tokenFeignClient;

    /**
     * 登录
     * LoginTestBean 登录验证bean
     * @return
     */
    @PostMapping
    public Object login(LoginValidationBean loginTestBean){
        CaptchaBean captchaBean = new CaptchaBean();
        captchaBean.setGeetest_challenge(loginTestBean.getGeetest_challenge());
        captchaBean.setGeetest_seccode(loginTestBean.getGeetest_seccode());
        captchaBean.setGeetest_validate(loginTestBean.getGeetest_validate());
        captchaBean.setGt_server_status(loginTestBean.getGt_server_status());
        captchaBean.setUserId(loginTestBean.getUserId());
        Boolean userCheck = VerifyCaptcha.verifyCaptcha(captchaBean,getIpAddr());
        if (!userCheck){
            return new ResultDO<Token>(false,"验证码验证失败,请重试");
        }
        ResultDO<Token> token = tokenFeignClient.login(loginTestBean.getEmail(),loginTestBean.getPassword());
        return token;
    }

    @DeleteMapping
    public Object logout(@RequestParam String token){
        ResultDO<String> msg = tokenFeignClient.logout(token);
        return msg;
    }


}
