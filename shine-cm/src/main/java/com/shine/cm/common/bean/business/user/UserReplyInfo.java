package com.shine.cm.common.bean.business.user;

import com.shine.cm.common.bean.db.TForumReplyInfo;

import java.io.Serializable;

public class UserReplyInfo extends TForumReplyInfo implements Serializable{

    private String themeName;

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    @Override
    public String toString() {
        return "UserReplyInfo{" +
                "themeName='" + themeName + '\'' +
                '}';
    }
}
