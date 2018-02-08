package com.shine.cm.service.forum.comment;

import com.shine.cm.common.bean.business.forum.BForumCommentInfo;
import com.shine.cm.common.bean.db.TForumCommentInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

public interface CommentService {

    public ResultDO<PageBean<BForumCommentInfo>> comments(Integer pageNum, Long replyId);

    public ResultDO<Boolean> postComment(TForumCommentInfo commentInfo);
}
