package com.shine.web.util;

import com.shine.common.util.Audience;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtHelper {
    public static Claims parseJWT(String jsonWebToken){
        try {
            Audience audience = new Audience();
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(audience.getBase64Secret()))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String createJWT(String userId, String userName) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Audience audience = new Audience();
        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                // jwt 摘要算法
//                .setHeaderParam("alg", "HS256")
                .claim("userName", userName)
                .claim("userId", userId)
                // jwt 签发者, 可以是网站域名或是签发者名称
                .setIssuer(audience.getIssuer())
                // Audience 客户端应用类型: web, app
                .setAudience(audience.getAudienceId())
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (audience.getExpiresSecond() * 1000 >= 0) {
            long expMillis = nowMillis + audience.getExpiresSecond()*1000;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }
        //生成JWT
        return builder.compact();
    }

    public static void main(String[] args) {
//        String token = createJWT("3","shine");
//        System.out.println(token);
//        String token2 = createJWT("4","laozhai");
//        System.out.println(token2);

//        Claims cl = parseJWT("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6InNoaW5lIiwidXNlcklkIjoiMyIsImlzcyI6InNoaW5lIiwiYXVkIjoid2ViIiwiZXhwIjoxNTE3NTUzNzM0LCJuYmYiOjE1MTc1NTM3MzR9.vWLo8ZAyOA3Umf1ZFYDFDTFOB3PT06hjnofcpRbrPLY");
//        System.out.println(cl);
// System.out.println(token);
//        System.out.println(token);
    }
}
