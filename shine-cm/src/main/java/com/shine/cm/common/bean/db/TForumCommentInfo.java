package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表forum_comment_info数据库Bean .</p>
 */
public class TForumCommentInfo implements Serializable {
    /**
     * <p>评论ID .</p>
     */
    private Long commentId;

    /**
     * <p>评论回复ID .</p>
     */
    private Long commentReplyId;

    /**
     * <p>评论人用户ID .</p>
     */
    private Long commentUserId;

    /**
     * <p>评论人用户名称  .</p>
     */
    private String commentUserName;

    /**
     * <p>评论内容 .</p>
     */
    private String commentContent;

    /**
     * <p>是否回复某人(1-是；2-否) .</p>
     */
    private Byte replySomeone;

    /**
     * <p>被回复人ID .</p>
     */
    private Long commentReplyUserId;

    /**
     * <p>被回复人昵称 .</p>
     */
    private String commentReplyUserName;

    /**
     * <p>修改人名称 .</p>
     */
    private String modifierUserName;

    /**
     * <p>修改时间 .</p>
     */
    private Date modifyTime;

    /**
     * <p>创建人名称 .</p>
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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentReplyId() {
        return commentReplyId;
    }

    public void setCommentReplyId(Long commentReplyId) {
        this.commentReplyId = commentReplyId;
    }

    public Long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Byte getReplySomeone() {
        return replySomeone;
    }

    public void setReplySomeone(Byte replySomeone) {
        this.replySomeone = replySomeone;
    }

    public Long getCommentReplyUserId() {
        return commentReplyUserId;
    }

    public void setCommentReplyUserId(Long commentReplyUserId) {
        this.commentReplyUserId = commentReplyUserId;
    }

    public String getCommentReplyUserName() {
        return commentReplyUserName;
    }

    public void setCommentReplyUserName(String commentReplyUserName) {
        this.commentReplyUserName = commentReplyUserName;
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
        sb.append(", commentId=").append(commentId);
        sb.append(", commentReplyId=").append(commentReplyId);
        sb.append(", commentUserId=").append(commentUserId);
        sb.append(", commentUserName=").append(commentUserName);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", replySomeone=").append(replySomeone);
        sb.append(", commentReplyUserId=").append(commentReplyUserId);
        sb.append(", commentReplyUserName=").append(commentReplyUserName);
        sb.append(", modifierUserName=").append(modifierUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creatorUserName=").append(creatorUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}