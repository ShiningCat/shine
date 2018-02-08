package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表mem_user_info数据库Bean .</p>
 */
public class TMemUserInfo implements Serializable {
    /**
     * <p>用户ID .</p>
     */
    private Long userId;

    /**
     * <p>用户名称(昵称) .</p>
     */
    private String userName;

    /**
     * <p>用户性别 (0 默认 隐藏性别 1,男 ,2女) .</p>
     */
    private Byte sex;

    /**
     * <p>用户头像 .</p>
     */
    private String userAvatar;

    /**
     * <p>手机号码 .</p>
     */
    private String phone;

    /**
     * <p>邮箱 .</p>
     */
    private String email;

    /**
     * <p>个人介绍 .</p>
     */
    private String introduce;

    /**
     * <p>用户等级 .</p>
     */
    private Byte userLevel;

    /**
     * <p>发帖数量 .</p>
     */
    private Integer themeNumber;

    /**
     * <p>回复数量 .</p>
     */
    private Integer replyNumber;

    /**
     * <p>评论数 .</p>
     */
    private Integer commentNumber;

    /**
     * <p>隐私设置,0:开放,1:关闭 .</p>
     */
    private Byte userPrivacy;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Byte getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Byte userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getThemeNumber() {
        return themeNumber;
    }

    public void setThemeNumber(Integer themeNumber) {
        this.themeNumber = themeNumber;
    }

    public Integer getReplyNumber() {
        return replyNumber;
    }

    public void setReplyNumber(Integer replyNumber) {
        this.replyNumber = replyNumber;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Byte getUserPrivacy() {
        return userPrivacy;
    }

    public void setUserPrivacy(Byte userPrivacy) {
        this.userPrivacy = userPrivacy;
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
        sb.append(", userName=").append(userName);
        sb.append(", sex=").append(sex);
        sb.append(", userAvatar=").append(userAvatar);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", introduce=").append(introduce);
        sb.append(", userLevel=").append(userLevel);
        sb.append(", themeNumber=").append(themeNumber);
        sb.append(", replyNumber=").append(replyNumber);
        sb.append(", commentNumber=").append(commentNumber);
        sb.append(", userPrivacy=").append(userPrivacy);
        sb.append(", modifierUserName=").append(modifierUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creatorUserName=").append(creatorUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}