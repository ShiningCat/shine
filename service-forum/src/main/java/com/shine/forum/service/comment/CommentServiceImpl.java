package com.shine.forum.service.comment;

import com.github.pagehelper.PageHelper;
import com.shine.cm.common.bean.business.forum.BForumCommentInfo;
import com.shine.cm.common.bean.db.TForumCommentInfo;
import com.shine.cm.service.forum.comment.CommentService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import com.shine.forum.mapper.business.comment.BForumCommentInfoMapper;
import com.shine.forum.mapper.business.reply.BForumReplyInfoMapper;
import com.shine.forum.mapper.db.TForumCommentInfoMapper;
import com.shine.forum.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl extends BaseService implements CommentService{

    @Resource
    private BForumCommentInfoMapper bForumCommentInfoMapper;

    @Resource
    private BForumReplyInfoMapper bForumReplyInfoMapper;

    @Resource
    private TForumCommentInfoMapper tForumCommentInfoMapper;


    @Override
    public ResultDO<PageBean<BForumCommentInfo>> comments(Integer pageNum, Long replyId) {
        PageBean pageBean = new PageBean();
        PageHelper.startPage(pageNum, pageBean.getPageSize());
        List<BForumCommentInfo> commentInfos = bForumCommentInfoMapper.selectCommentPageList(replyId);
        return new ResultDO<PageBean<BForumCommentInfo>>(new PageBean<>(commentInfos));
    }

    @Override
    public ResultDO<Boolean> postComment(TForumCommentInfo commentInfo) {
        if(commentInfo.getCommentReplyId() == null || commentInfo.getCommentUserId() == null){
            return new ResultDO<>(false,"评论失败,请刷新页面重试");
        }
        if (commentInfo.getCommentContent().length() > 100){
            return new ResultDO<>(false,"评论内容太长了哦");
        }
        commentInfo.setModifierUserName(commentInfo.getCommentUserName());
        commentInfo.setCreatorUserName(commentInfo.getCommentUserName());
        bForumReplyInfoMapper.updateReplyCommentCount(commentInfo.getCommentReplyId());
        int i = tForumCommentInfoMapper.insertSelective(commentInfo);
        if (i == 1){
            return new ResultDO<>();
        }
        return new ResultDO<>(false,"发布评论失败");
    }
}
