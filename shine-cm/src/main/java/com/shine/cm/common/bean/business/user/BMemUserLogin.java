package com.shine.cm.common.bean.business.user;

import com.shine.cm.common.bean.db.TMemUserLogin;

import java.io.Serializable;

public class BMemUserLogin extends TMemUserLogin implements Serializable{

    private String password2;


    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
