package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表mem_user_message数据库Bean .</p>
 */
public class TMemUserMessage implements Serializable {
    /**
     * <p>私信ID .</p>
     */
    private Long messageId;

    /**
     * <p>私信内容 .</p>
     */
    private String messageContent;

    /**
     * <p>发送人ID .</p>
     */
    private Long sendUserId;

    /**
     * <p>发送人名称 .</p>
     */
    private String sendUserName;

    /**
     * <p>接收人ID .</p>
     */
    private Long receiveUserId;

    /**
     * <p>接收人名称 .</p>
     */
    private String receiveUserName;

    /**
     * <p>消息发送时间 .</p>
     */
    private Date sendMessageTime;

    /**
     * <p>消息是否查看 (0-未查看 1-已查看) .</p>
     */
    private Byte messageIsRead;

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

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
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

    public Date getSendMessageTime() {
        return sendMessageTime;
    }

    public void setSendMessageTime(Date sendMessageTime) {
        this.sendMessageTime = sendMessageTime;
    }

    public Byte getMessageIsRead() {
        return messageIsRead;
    }

    public void setMessageIsRead(Byte messageIsRead) {
        this.messageIsRead = messageIsRead;
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
        sb.append(", messageId=").append(messageId);
        sb.append(", messageContent=").append(messageContent);
        sb.append(", sendUserId=").append(sendUserId);
        sb.append(", sendUserName=").append(sendUserName);
        sb.append(", receiveUserId=").append(receiveUserId);
        sb.append(", receiveUserName=").append(receiveUserName);
        sb.append(", sendMessageTime=").append(sendMessageTime);
        sb.append(", messageIsRead=").append(messageIsRead);
        sb.append(", modifierUserName=").append(modifierUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creatorUserName=").append(creatorUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}