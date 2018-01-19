package com.shine.cm.common.bean.business.user;

import com.shine.common.util.verification.CaptchaBean;

import java.io.Serializable;

public class RePasswordVakidationBean extends CaptchaBean implements Serializable{

    private String code;

    private String password;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
