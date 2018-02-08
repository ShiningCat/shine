package com.shine.cm.common.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>表mem_user_favorite数据库Bean .</p>
 */
public class TMemUserFavorite implements Serializable {
    /**
     * <p>收藏夹ID .</p>
     */
    private Long favoriteId;

    /**
     * <p>收藏用户ID .</p>
     */
    private Long favoriteUserId;

    /**
     * <p>帖子ID .</p>
     */
    private Long favoriteThemeId;

    /**
     * <p>收藏时间 .</p>
     */
    private Date favoriteTime;

    /**
     * <p>修改时间 .</p>
     */
    private Date modifyTime;

    /**
     * <p>删除标识 (1-正常；2-删除) .</p>
     */
    private Byte delFlag;

    private static final long serialVersionUID = 1L;

    public Long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Long getFavoriteUserId() {
        return favoriteUserId;
    }

    public void setFavoriteUserId(Long favoriteUserId) {
        this.favoriteUserId = favoriteUserId;
    }

    public Long getFavoriteThemeId() {
        return favoriteThemeId;
    }

    public void setFavoriteThemeId(Long favoriteThemeId) {
        this.favoriteThemeId = favoriteThemeId;
    }

    public Date getFavoriteTime() {
        return favoriteTime;
    }

    public void setFavoriteTime(Date favoriteTime) {
        this.favoriteTime = favoriteTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
        sb.append(", favoriteId=").append(favoriteId);
        sb.append(", favoriteUserId=").append(favoriteUserId);
        sb.append(", favoriteThemeId=").append(favoriteThemeId);
        sb.append(", favoriteTime=").append(favoriteTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append("]");
        return sb.toString();
    }
}