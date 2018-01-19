package com.shine.user.controller.verification;

import com.shine.common.util.MD5;
import com.shine.common.util.verification.GeetestConfig;
import com.shine.common.util.verification.GeetestLib;
import com.shine.user.controller.BaseController;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;

@RestController
public class StartCaptchaController extends BaseController {

    @RequestMapping(value = "/verification/code")
    public Object captcha(HttpServletRequest request ){
        GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
                GeetestConfig.isnewfailback());

        String resStr = "{}";

        String userId = MD5.md5WithSalt(new Date().toString(),MD5.generateSalt());

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>(3);

        param.put("user_id", userId); //网站用户id
        param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("ip_address", getIpAddr()); //传输用户请求验证时所携带的IP
        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(param);
        //将服务器状态设置到session中
//        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
//        request.getSession().setAttribute("userid", userid);

        JSONObject obj = new JSONObject(gtSdk.getResponseStr());
        obj.put("userId", userId);
        obj.put("gt_server_status",gtServerStatus);

        resStr = obj.toString();

        return  resStr;
    }
}
