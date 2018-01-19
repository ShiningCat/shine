package com.shine.user.controller.verification;

import com.shine.common.util.verification.CaptchaBean;
import com.shine.common.util.verification.GeetestConfig;
import com.shine.common.util.verification.GeetestLib;
import com.shine.user.controller.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;


public class VerifyCaptcha{

    public static boolean verifyCaptcha( CaptchaBean captchaBean , String ip) {
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
                GeetestConfig.isnewfailback());
        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("user_id", captchaBean.getUserId()); //网站用户id
        param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("ip_address", ip); //传输用户请求验证时所携带的IP
        int gtResult = 0;
        if (Integer.valueOf(captchaBean.getGt_server_status()) == 1) {
            //gt-server正常，向gt-server进行二次验证
            gtResult = gtSdk.enhencedValidateRequest(captchaBean.getGeetest_challenge(), captchaBean.getGeetest_validate(), captchaBean.getGeetest_seccode(), param);
        } else {
            // gt-server非正常情况下，进行failback模式验证
            gtResult = gtSdk.failbackValidateRequest(captchaBean.getGeetest_challenge(), captchaBean.getGeetest_validate(), captchaBean.getGeetest_seccode());
        }
        if (gtResult == 1) {
            return true;
        } else {
            return false;
        }
    }

}
