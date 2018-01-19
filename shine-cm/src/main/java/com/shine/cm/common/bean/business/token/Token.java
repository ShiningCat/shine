package com.shine.cm.common.bean.business.token;

import com.shine.cm.common.bean.db.TMemUserInfo;

public class Token {
    private String token;

    private TMemUserInfo userInfo;

    public Token() {
    }

    public Token(String token, TMemUserInfo userInfo) {
        this.token = token;
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TMemUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(TMemUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
