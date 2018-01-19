package com.shine.common.util.mailutil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MailUtil {

    public static void main(String[] args){
        Mail mail = new Mail();
        mail.setHost("smtp.qq.com");
        mail.setName("shine");
        mail.setSender("zhaitonghui.vip@foxmail.com");
//        mail.setReceiver("974389800@qq.com");
        mail.setReceiver("15856443200@163.com");
        mail.setUsername("1312523313");
        //标题
        mail.setSubject("账号激活");
        mail.setPassword("sgftvwpniyupgaji");
        //内容
        mail.setMessage("您好，请在 24 小时内点击此链接以完成激活 " +
                "https://www.baidu.com");
        boolean isOk = send(mail);
        if (isOk){
            System.out.println("发送成功");
        }else {
            System.out.println("发送失败");
        }
    }
    public static boolean intiSend(Mail mail){
        mail.setHost("smtp.qq.com");
        mail.setName("shine");
        mail.setSender("zhaitonghui.vip@foxmail.com");
        mail.setUsername("1312523313");
        mail.setPassword("sgftvwpniyupgaji");
        return send(mail);
    }
    public static boolean send(Mail mail) {
        Properties properties = mail.getProperties();
        properties.put("mail.smtp.auth","true");
        // 设置邮件服务器
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(mail.getUsername(), mail.getPassword()); //发件人邮件用户名、密码
            }
        });
        session.setDebug(false);
        try {
            // 创建邮件对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 发件人地址   and 设置别名
            message.setFrom(new InternetAddress(mail.getSender(), MimeUtility.encodeText("阳光漫漫", "UTF-8", "b")));
            // Set To:  收件人地址
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(mail.getReceiver()));
            // Set Subject: 标题
            message.setSubject(mail.getSubject());
            // 设置内容
            message.setText(mail.getMessage());
            // 发送消息
            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
