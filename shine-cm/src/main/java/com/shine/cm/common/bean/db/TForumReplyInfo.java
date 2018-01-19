package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表forum_reply_info数据库Bean .</p>
 */
public class TForumReplyInfo implements Serializable {
    /**
     * <p>回复ID .</p>
     */
    private Long replyId;

    /**
     * <p>回复话题ID .</p>
     */
    private Long replyThemeId;

    /**
     * <p>回复用户ID .</p>
     */
    private Long replyUserId;

    /**
     * <p>回复用户名称 .</p>
     */
    private String replyUserName;

    /**
     * <p>回复内容 .</p>
     */
    private String replyContent;

    /**
     * <p>回复时间 .</p>
     */
    private Date replyTime;

    /**
     * <p>回复楼层 .</p>
     */
    private Integer replyFloor;

    /**
     * <p>回复评论数量 .</p>
     */
    private Integer replyCommentNumber;

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

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public Long getReplyThemeId() {
        return replyThemeId;
    }

    public void setReplyThemeId(Long replyThemeId) {
        this.replyThemeId = replyThemeId;
    }

    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getReplyFloor() {
        return replyFloor;
    }

    public void setReplyFloor(Integer replyFloor) {
        this.replyFloor = replyFloor;
    }

    public Integer getReplyCommentNumber() {
        return replyCommentNumber;
    }

    public void setReplyCommentNumber(Integer replyCommentNumber) {
        this.replyCommentNumber = replyCommentNumber;
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
        sb.append(", replyId=").append(replyId);
        sb.append(", replyThemeId=").append(replyThemeId);
        sb.append(", replyUserId=").append(replyUserId);
        sb.append(", replyUserName=").append(replyUserName);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", replyTime=").append(replyTime);
        sb.append(", replyFloor=").append(replyFloor);
        sb.append(", replyCommentNumber=").append(replyCommentNumber);
        sb.append(", modifierUserName=").append(modifierUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creatorUserName=").append(creatorUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}