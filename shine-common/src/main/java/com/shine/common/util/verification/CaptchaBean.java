package com.shine.common.util.verification;

import java.io.Serializable;

public class CaptchaBean implements Serializable{

    private String geetest_challenge;

    private String geetest_validate;

    private String geetest_seccode;

    private String userId;

    private String gt_server_status;

    public String getGeetest_challenge() {
        return geetest_challenge;
    }

    public void setGeetest_challenge(String geetest_challenge) {
        this.geetest_challenge = geetest_challenge;
    }

    public String getGeetest_validate() {
        return geetest_validate;
    }

    public void setGeetest_validate(String geetest_validate) {
        this.geetest_validate = geetest_validate;
    }

    public String getGeetest_seccode() {
        return geetest_seccode;
    }

    public void setGeetest_seccode(String geetest_seccode) {
        this.geetest_seccode = geetest_seccode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGt_server_status() {
        return gt_server_status;
    }

    public void setGt_server_status(String gt_server_status) {
        this.gt_server_status = gt_server_status;
    }
}
