package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表forum_topic_info数据库Bean .</p>
 */
public class TForumTopicInfo implements Serializable {
    /**
     * <p>主题(版块)ID .</p>
     */
    private Long topicId;

    /**
     * <p>主题(版块)名称 .</p>
     */
    private String topicName;

    /**
     * <p>主题(版块)创建人ID .</p>
     */
    private Long topicUserId;

    /**
     * <p>主题(版块)创建人名称 .</p>
     */
    private String topicUserName;

    /**
     * <p>主题(版块)图片 .</p>
     */
    private String topicImage;

    /**
     * <p>主题(版块)说明或发布公告内容 .</p>
     */
    private String topicContent;

    /**
     * <p>主题(版块)热门帖子数量 .</p>
     */
    private Integer topicThemeNumber;

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

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Long getTopicUserId() {
        return topicUserId;
    }

    public void setTopicUserId(Long topicUserId) {
        this.topicUserId = topicUserId;
    }

    public String getTopicUserName() {
        return topicUserName;
    }

    public void setTopicUserName(String topicUserName) {
        this.topicUserName = topicUserName;
    }

    public String getTopicImage() {
        return topicImage;
    }

    public void setTopicImage(String topicImage) {
        this.topicImage = topicImage;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public Integer getTopicThemeNumber() {
        return topicThemeNumber;
    }

    public void setTopicThemeNumber(Integer topicThemeNumber) {
        this.topicThemeNumber = topicThemeNumber;
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
        sb.append(", topicId=").append(topicId);
        sb.append(", topicName=").append(topicName);
        sb.append(", topicUserId=").append(topicUserId);
        sb.append(", topicUserName=").append(topicUserName);
        sb.append(", topicImage=").append(topicImage);
        sb.append(", topicContent=").append(topicContent);
        sb.append(", topicThemeNumber=").append(topicThemeNumber);
        sb.append(", modifierUserName=").append(modifierUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creatorUserName=").append(creatorUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}