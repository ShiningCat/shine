package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表mem_user_login数据库Bean .</p>
 */
public class TMemUserLogin implements Serializable {
    /**
     * <p>用户ID .</p>
     */
    private Long userId;

    /**
     * <p>手机号 .</p>
     */
    private String phone;

    /**
     * <p>密码 .</p>
     */
    private String password;

    /**
     * <p>密码盐值 .</p>
     */
    private String passwordSalt;

    /**
     * <p>邮箱 .</p>
     */
    private String email;

    /**
     * <p>用户名(昵称) .</p>
     */
    private String userName;

    /**
     * <p>用户等级(暂未开放) .</p>
     */
    private Byte userLevel;

    /**
     * <p>用户权限(暂未开放) .</p>
     */
    private Byte userRole;

    /**
     * <p>用户上次登录时间 .</p>
     */
    private Date loginTime;

    /**
     * <p>修改人账号 .</p>
     */
    private String modifierUserName;

    /**
     * <p>修改时间 .</p>
     */
    private Date modifyTime;

    /**
     * <p>创建人账号 .</p>
     */
    private String creatorUserName;

    /**
     * <p>创建时间 .</p>
     */
    private Date createTime;

    /**
     * <p>删除标识 (1-正常；2-删除) .</p>
     */
    private Byte delFlag;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Byte userLevel) {
        this.userLevel = userLevel;
    }

    public Byte getUserRole() {
        return userRole;
    }

    public void setUserRole(Byte userRole) {
        this.userRole = userRole;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getModifierUserName() {
        return modifierUserName;
    }

    public void setModifierUserName(String modifierUserName) {
        this.modifierUserName = modifierUserName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreatorUserName() {
        return creatorUserName;
    }

    public void setCreatorUserName(String creatorUserName) {
        this.creatorUserName = creatorUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", phone=").append(phone);
        sb.append(", password=").append(password);
        sb.append(", passwordSalt=").append(passwordSalt);
        sb.append(", email=").append(email);
        sb.append(", userName=").append(userName);
        sb.append(", userLevel=").append(userLevel);
        sb.append(", userRole=").append(userRole);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", modifierUserName=").append(modifierUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creatorUserName=").append(creatorUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}