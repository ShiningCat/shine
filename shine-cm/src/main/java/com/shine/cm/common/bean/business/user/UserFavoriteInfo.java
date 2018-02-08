package com.shine.cm.common.bean.business.user;

import com.shine.cm.common.bean.db.TMemUserFavorite;

import java.io.Serializable;

public class UserFavoriteInfo extends TMemUserFavorite implements Serializable {

    private String themeName;

    private Integer themeReplyNumber;

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public Integer getThemeReplyNumber() {
        return themeReplyNumber;
    }

    public void setThemeReplyNumber(Integer themeReplyNumber) {
        this.themeReplyNumber = themeReplyNumber;
    }
}
