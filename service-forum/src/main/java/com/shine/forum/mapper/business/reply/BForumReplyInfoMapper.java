package com.shine.forum.mapper.business.reply;

import com.shine.cm.common.bean.business.forum.BForumReplyInfo;
import com.shine.cm.common.bean.business.user.UserReplyInfo;

import java.util.List;


public interface BForumReplyInfoMapper {

    List<BForumReplyInfo> selectReplyPageList(Long themeId);

    Integer selectReplyFloor(Long themeId);

    Integer updateReplyCommentCount(Long replyId);

    List<UserReplyInfo> getReplyByUserId(Long userId);
}
