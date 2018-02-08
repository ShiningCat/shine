package com.shine.forum.service.user;

import com.github.pagehelper.PageHelper;
import com.shine.cm.common.bean.business.forum.BForumReplyInfo;
import com.shine.cm.common.bean.business.user.UserCommentInfo;
import com.shine.cm.common.bean.business.user.UserReplyInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.cm.service.user.UserActivityService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import com.shine.forum.mapper.business.comment.BForumCommentInfoMapper;
import com.shine.forum.mapper.business.reply.BForumReplyInfoMapper;
import com.shine.forum.mapper.business.theme.BForumThemeInfoMapper;
import com.shine.forum.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityServiceImpl extends BaseService implements UserActivityService {

    @Autowired
    private BForumThemeInfoMapper bForumThemeInfoMapper;

    @Autowired
    private BForumReplyInfoMapper bForumReplyInfoMapper;

    @Autowired
    private BForumCommentInfoMapper bForumCommentInfoMapper;

    @Override
    public ResultDO<PageBean<TForumThemeInfo>> getUserThemes(Long userId, Integer limit, Integer page) {
        PageHelper.startPage(page, limit);
        List<TForumThemeInfo> list = bForumThemeInfoMapper.getThemeByUserId(userId);
        return new ResultDO<PageBean<TForumThemeInfo>>(new PageBean<>(list));
    }

    @Override
    public ResultDO<PageBean<UserReplyInfo>> getUserReply(Long userId, Integer limit, Integer page) {
        PageHelper.startPage(page, limit);
        List<UserReplyInfo> list = bForumReplyInfoMapper.getReplyByUserId(userId);
        return new ResultDO<PageBean<UserReplyInfo>>(new PageBean<>(list));
    }

    @Override
    public ResultDO<PageBean<UserCommentInfo>> getUserComments(Long userId, Integer limit, Integer page) {
        PageHelper.startPage(page,limit);
        List<UserCommentInfo> list = bForumCommentInfoMapper.getCommentsByUserId(userId);
        return new ResultDO<PageBean<UserCommentInfo>>(new PageBean(list));
    }

}
