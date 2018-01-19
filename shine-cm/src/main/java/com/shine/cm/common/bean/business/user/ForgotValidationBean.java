package com.shine.cm.common.bean.business.user;

import com.shine.common.util.verification.CaptchaBean;

import java.io.Serializable;

public class ForgotValidationBean extends CaptchaBean implements Serializable {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
