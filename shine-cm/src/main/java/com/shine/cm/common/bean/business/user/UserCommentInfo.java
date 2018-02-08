package com.shine.cm.common.bean.business.user;

import com.shine.cm.common.bean.db.TForumCommentInfo;

import java.io.Serializable;

public class UserCommentInfo extends TForumCommentInfo implements Serializable{

    private String userName;

    private String userAvatar;

    private String replyContent;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
}
