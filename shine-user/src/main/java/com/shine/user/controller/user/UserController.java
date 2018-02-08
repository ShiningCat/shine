package com.shine.user.controller.user;

import com.shine.cm.common.bean.business.token.Token;
import com.shine.cm.common.bean.business.user.*;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.cm.common.bean.db.TMemUserFavorite;
import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.cm.common.bean.db.TMemUserLogin;
import com.shine.common.util.verification.CaptchaBean;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import com.shine.user.controller.BaseController;
import com.shine.user.controller.verification.VerifyCaptcha;
import com.shine.user.feign.token.TokenFeign;
import com.shine.user.feign.user.UserActivityFeign;
import com.shine.user.feign.user.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/users")
public class UserController extends BaseController {

    @Autowired
    private UserFeign userFeignClient;

    @Autowired
    private UserActivityFeign userActivityFeign;

    @Autowired
    private TokenFeign tokenFeignClient;

    /**
     * 获取用ID 为xx 的用户信息
     * @param userId
     * @return
     */
    @GetMapping(value = "/{userId}")
    public ResultDO<TMemUserInfo> getUser(@PathVariable(value = "userId") Long userId){
        return userFeignClient.getUser(userId);
    }

    /**
     * 创建用户
     * @return
     */
    @PostMapping
    public Object creationUser(RegisterValidationBean registerValidationBean){
        CaptchaBean captchaBean = new CaptchaBean();
        captchaBean.setGeetest_challenge(registerValidationBean.getGeetest_challenge());
        captchaBean.setGeetest_seccode(registerValidationBean.getGeetest_seccode());
        captchaBean.setGeetest_validate(registerValidationBean.getGeetest_validate());
        captchaBean.setGt_server_status(registerValidationBean.getGt_server_status());
        captchaBean.setUserId(registerValidationBean.getUserId());
        Boolean userCheck = VerifyCaptcha.verifyCaptcha(captchaBean,getIpAddr());
        if (!userCheck){
            return new ResultDO<Token>(false,"验证码验证失败,请重试");
        }
        TMemUserLogin user = new TMemUserLogin();
        user.setUserName(registerValidationBean.getUserName());
        user.setEmail(registerValidationBean.getEmail());
        user.setPassword(registerValidationBean.getPassword());
        return userFeignClient.creationUser(user);
    }

    /**
     * 修改
     * @param userId
     * @param user
     * @return
     */
    @PutMapping(value = "/{id}")
    public Object editUser(@PathVariable Long userId, @RequestParam TMemUserInfo user){

        return "OK";
    }

    /**
     * 注册验证
     * @param code 验证码
     * @return
     */
    @GetMapping(value = "/confirm_verification/{code}")
    public Object confirmUser(@PathVariable String code){
        return userFeignClient.confirmUser(code);
    }

    /**
     * 发送一封邮件
     * @param  forgotValidationBean
     * @return
     */
    @PostMapping(value = "/update_password/mail")
    public Object sendMsg (ForgotValidationBean forgotValidationBean){
        CaptchaBean captchaBean = new CaptchaBean();
        captchaBean.setGeetest_challenge(forgotValidationBean.getGeetest_challenge());
        captchaBean.setGeetest_seccode(forgotValidationBean.getGeetest_seccode());
        captchaBean.setGeetest_validate(forgotValidationBean.getGeetest_validate());
        captchaBean.setGt_server_status(forgotValidationBean.getGt_server_status());
        captchaBean.setUserId(forgotValidationBean.getUserId());
        Boolean userCheck = VerifyCaptcha.verifyCaptcha(captchaBean,getIpAddr());
        if (!userCheck){
            return new ResultDO<Token>(false,"验证码验证失败,请重试");
        }
        return userFeignClient.sendMsg(forgotValidationBean.getEmail());
    }
    /**
     * 找回密码
     * @param code
     * @return
     */
    @GetMapping(value = "/update_password/{code}")
    public Object resetPassword(@PathVariable String code){
        return userFeignClient.resetPassword(code);
    }

    /**
     * 重置密码提交
     * @return
     */
    @PutMapping(value = "/update_password")
    public Object updatePassword(RePasswordVakidationBean rePasswordVakidationBean ){
        CaptchaBean captchaBean = new CaptchaBean();
        captchaBean.setGeetest_challenge(rePasswordVakidationBean.getGeetest_challenge());
        captchaBean.setGeetest_seccode(rePasswordVakidationBean.getGeetest_seccode());
        captchaBean.setGeetest_validate(rePasswordVakidationBean.getGeetest_validate());
        captchaBean.setGt_server_status(rePasswordVakidationBean.getGt_server_status());
        captchaBean.setUserId(rePasswordVakidationBean.getUserId());
        Boolean userCheck = VerifyCaptcha.verifyCaptcha(captchaBean,getIpAddr());
        if (!userCheck){
            return new ResultDO<Token>(false,"验证码验证失败,请重试");
        }
//        RePasswordVakidationBean rePasswordVakidationBean = new RePasswordVakidationBean();
        return userFeignClient.resetPassword(rePasswordVakidationBean.getCode(),rePasswordVakidationBean.getPassword());
    }


    @GetMapping(value = "/{userId}/comments")
    ResultDO<PageBean<UserCommentInfo>> getUserComments(@PathVariable Long userId, @RequestParam(defaultValue = "20") Integer limit, @RequestParam(value = "page", defaultValue = "1") Integer page){
        return userActivityFeign.getUserComments(userId,limit,page);
    }

    /**
     * 我的动态
     * @param userId
     * @return
     */
    @GetMapping(value = "/{userId}/activities")
    public Object getUserActivities(@PathVariable Long userId){
        return "OK";
    }

    /**
     * 我的帖子
     * @param userId:用户 limit:每页数量 page:页码
     * @return
     */
    @GetMapping(value = "/{userId}/themes")
    public ResultDO<PageBean<TForumThemeInfo>> getUserThemes(@PathVariable Long userId, @RequestParam(defaultValue = "20") Integer limit, @RequestParam(value = "page", defaultValue = "1") Integer page){
        return  userActivityFeign.getUserThemes(userId,limit,page);
    }

    /**
     * 我的回复
     * @param userId:用户 limit:每页数量 page:页码
     * @return
     */
    @GetMapping(value = "/{userId}/reply")
    public ResultDO<PageBean<UserReplyInfo>> getUserReply(@PathVariable Long userId, @RequestParam(defaultValue = "20") Integer limit, @RequestParam(value = "page", defaultValue = "1") Integer page){
        return  userActivityFeign.getUserReply(userId,limit,page);
    }

    @GetMapping(value = "/{userId}/favorites")
    public ResultDO<PageBean<UserFavoriteInfo>> getUserFavorites(@PathVariable Long userId, @RequestParam(defaultValue = "20") Integer limit, @RequestParam(value = "page", defaultValue = "1") Integer page){
        return  userFeignClient.getFavorites(userId,limit,page);
    }
}
