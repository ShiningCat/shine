package com.shine.cm.service.forum.reply;

import com.shine.cm.common.bean.business.forum.BForumReplyInfo;
import com.shine.cm.common.bean.db.TForumReplyInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

public interface ReplyService {

    ResultDO<PageBean<BForumReplyInfo>> replys(Integer pageNum, Long themeId);

    ResultDO<Boolean> postReply(TForumReplyInfo replyInfo);
}
