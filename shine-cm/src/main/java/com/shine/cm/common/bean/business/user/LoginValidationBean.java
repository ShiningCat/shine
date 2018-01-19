package com.shine.cm.common.bean.business.user;

import com.shine.common.util.verification.CaptchaBean;

import java.io.Serializable;

public class LoginValidationBean extends CaptchaBean implements Serializable{

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
