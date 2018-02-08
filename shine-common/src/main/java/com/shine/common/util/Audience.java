package com.shine.common.util;

public class Audience {

    // Audience 客户端应用类型: web, app
    private String audienceId = "web";
    // md5("ZhaiTongHui12138!...") b622988ba6e1873f65ec43d509138b2c
    // base64("b622988ba6e1873f65ec43d509138b2c") YjYyMjk4OGJhNmUxODczZjY1ZWM0M2Q1MDkxMzhiMmM=
    private String base64Secret = "YjYyMjk4OGJhNmUxODczZjY1ZWM0M2Q1MDkxMzhiMmM=";
    // jwt 签发者, 可以是网站域名或是签发者名称
    private String issuer = "shine";
    // jwt token 过期时间 一天
    private int expiresSecond = 86400;

    public String getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(String audienceId) {
        this.audienceId = audienceId;
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public int getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(int expiresSecond) {
        this.expiresSecond = expiresSecond;
    }
}
