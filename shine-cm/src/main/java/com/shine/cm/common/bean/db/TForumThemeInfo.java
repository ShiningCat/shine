package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表forum_theme_info数据库Bean .</p>
 */
public class TForumThemeInfo implements Serializable {
    /**
     * <p>话题(帖子)ID .</p>
     */
    private Long themeId;

    /**
     * <p>话题(帖子)所属主题(板块)Id .</p>
     */
    private Long themeTopicId;

    /**
     * <p>话题(帖子)发表人ID .</p>
     */
    private Long themeUserId;

    /**
     * <p>话题(帖子)名称 .</p>
     */
    private String themeName;

    /**
     * <p>话题(帖子)发表人名称 .</p>
     */
    private String themeUserName;

    /**
     * <p>话题(帖子)内容 .</p>
     */
    private String themeContent;

    /**
     * <p>话题(帖子)回复数量 .</p>
     */
    private Integer themeReplyNumber;

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

    public Long getThemeId() {
        return themeId;
    }

    public void setThemeId(Long themeId) {
        this.themeId = themeId;
    }

    public Long getThemeTopicId() {
        return themeTopicId;
    }

    public void setThemeTopicId(Long themeTopicId) {
        this.themeTopicId = themeTopicId;
    }

    public Long getThemeUserId() {
        return themeUserId;
    }

    public void setThemeUserId(Long themeUserId) {
        this.themeUserId = themeUserId;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeUserName() {
        return themeUserName;
    }

    public void setThemeUserName(String themeUserName) {
        this.themeUserName = themeUserName;
    }

    public String getThemeContent() {
        return themeContent;
    }

    public void setThemeContent(String themeContent) {
        this.themeContent = themeContent;
    }

    public Integer getThemeReplyNumber() {
        return themeReplyNumber;
    }

    public void setThemeReplyNumber(Integer themeReplyNumber) {
        this.themeReplyNumber = themeReplyNumber;
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
        sb.append(", themeId=").append(themeId);
        sb.append(", themeTopicId=").append(themeTopicId);
        sb.append(", themeUserId=").append(themeUserId);
        sb.append(", themeName=").append(themeName);
        sb.append(", themeUserName=").append(themeUserName);
        sb.append(", themeContent=").append(themeContent);
        sb.append(", themeReplyNumber=").append(themeReplyNumber);
        sb.append(", modifierUserName=").append(modifierUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creatorUserName=").append(creatorUserName);
        sb.append(", createTime=").append(createTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}