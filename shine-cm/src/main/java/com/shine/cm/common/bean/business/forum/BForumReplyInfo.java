package com.shine.cm.common.bean.business.forum;

import com.shine.cm.common.bean.db.TForumReplyInfo;

public class BForumReplyInfo extends TForumReplyInfo{

    private String userAvatar;

    private String introduce;

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "BForumReplyInfo{" +
                "userAvatar='" + userAvatar + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
