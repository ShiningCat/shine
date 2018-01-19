package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表sys_notice数据库Bean .</p>
 */
public class TSysNotice implements Serializable {
    /**
     * <p>通知ID .</p>
     */
    private Long noticeId;

    /**
     * <p>接收通知人ID .</p>
     */
    private Long receiveUserId;

    /**
     * <p>接收通知人名称 .</p>
     */
    private String receiveUserName;

    /**
     * <p>通知发送人ID(系统通知,默认为空) .</p>
     */
    private Long sendUserId;

    /**
     * <p>通知发送人名称 .</p>
     */
    private String sendUserName;

    /**
     * <p>通知发送时间 .</p>
     */
    private Date sendNoticeTime;

    /**
     * <p>帖子ID(回复评论类通知,加入帖子ID) .</p>
     */
    private Long noticeThemeId;

    /**
     * <p>帖子标题 .</p>
     */
    private String noticeThemeTitle;

    /**
     * <p>帖子楼层 (用于定位用户的回复) .</p>
     */
    private Integer noticeThemeFloor;

    /**
     * <p>回复ID(评论通知,是否在某个回复下) .</p>
     */
    private Long noticeReplyId;

    /**
     * <p>通知是否查看 (0-未查看 1-已查看) .</p>
     */
    private Byte noticeIsRead;

    /**
     * <p>通知类型   1-回复,2-评论,3-关注 .</p>
     */
    private Byte noticeType;

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

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(Long receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }

    public Long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public Date getSendNoticeTime() {
        return sendNoticeTime;
    }

    public void setSendNoticeTime(Date sendNoticeTime) {
        this.sendNoticeTime = sendNoticeTime;
    }

    public Long getNoticeThemeId() {
        return noticeThemeId;
    }

    public void setNoticeThemeId(Long noticeThemeId) {
        this.noticeThemeId = noticeThemeId;
    }

    public String getNoticeThemeTitle() {
        return noticeThemeTitle;
    }

    public void setNoticeThemeTitle(String noticeThemeTitle) {
        this.noticeThemeTitle = noticeThemeTitle;
    }

    public Integer getNoticeThemeFloor() {
        return noticeThemeFloor;
    }

    public void setNoticeThemeFloor(Integer noticeThemeFloor) {
        this.noticeThemeFloor = noticeThemeFloor;
    }

    public Long getNoticeReplyId() {
        return noticeReplyId;
    }

    public void setNoticeReplyId(Long noticeReplyId) {
        this.noticeReplyId = noticeReplyId;
    }

    public Byte getNoticeIsRead() {
        return noticeIsRead;
    }

    public void setNoticeIsRead(Byte noticeIsRead) {
        this.noticeIsRead = noticeIsRead;
    }

    public Byte getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Byte noticeType) {
        this.noticeType = noticeType;
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
        sb.append(", noticeId=").append(noticeId);
        sb.append(", receiveUserId=").append(receiveUserId);
        sb.append(", receiveUserName=").append(receiveUserName);
        sb.append(", sendUserId=").append(sendUserId);
        sb.append(", sendUserName=").append(sendUserName);
        sb.append(", sendNoticeTime=").append(sendNoticeTime);
        sb.append(", noticeThemeId=").append(noticeThemeId);
        sb.append(", noticeThemeTitle=").append(noticeThemeTitle);
        sb.append(", noticeThemeFloor=").append(noticeThemeFloor);
        sb.append(", noticeReplyId=").append(noticeReplyId);
        sb.append(", noticeIsRead=").append(noticeIsRead);
        sb.append(", noticeType=").append(noticeType);
        sb.append(", modifierUserName=").append(modifierUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creatorUserName=").append(creatorUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}