package com.shine.forum.mapper.business.comment;

import com.shine.cm.common.bean.business.forum.BForumCommentInfo;
import com.shine.cm.common.bean.business.user.UserCommentInfo;

import java.util.List;

public interface BForumCommentInfoMapper {

    List<BForumCommentInfo> selectCommentPageList(Long replyId);

    List<UserCommentInfo> getCommentsByUserId(Long userId);
}
