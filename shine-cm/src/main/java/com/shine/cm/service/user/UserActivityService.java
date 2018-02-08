package com.shine.cm.service.user;

import com.shine.cm.common.bean.business.user.UserCommentInfo;
import com.shine.cm.common.bean.business.user.UserReplyInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

public interface UserActivityService {

    public ResultDO<PageBean<TForumThemeInfo>> getUserThemes(Long userId, Integer limit, Integer page);

    public ResultDO<PageBean<UserReplyInfo>> getUserReply(Long userId, Integer limit, Integer page);

    public ResultDO<PageBean<UserCommentInfo>> getUserComments(Long userId, Integer limit, Integer page);
}
