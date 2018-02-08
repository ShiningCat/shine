package com.shine.forum.service.reply;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shine.cm.common.bean.business.forum.BForumReplyInfo;
import com.shine.cm.common.bean.db.TForumReplyInfo;
import com.shine.cm.service.forum.reply.ReplyService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import com.shine.forum.mapper.business.reply.BForumReplyInfoMapper;
import com.shine.forum.mapper.business.theme.BForumThemeInfoMapper;
import com.shine.forum.mapper.db.TForumReplyInfoMapper;
import com.shine.forum.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ReplyServiceImpl extends BaseService implements ReplyService{

    @Resource
    private BForumReplyInfoMapper replyInfoMapper;

    @Resource
    private TForumReplyInfoMapper tForumReplyInfoMapper;

    @Resource
    private BForumThemeInfoMapper bForumThemeInfoMapper;

    @Override
    public ResultDO<PageBean<BForumReplyInfo>> replys(Integer pageNum, Long themeId) {
        PageBean pageBean = new PageBean();
        PageHelper.startPage(pageNum, pageBean.getPageSize());
        List<BForumReplyInfo> replyInfos = replyInfoMapper.selectReplyPageList(themeId);
        return new ResultDO<PageBean<BForumReplyInfo>>(new PageBean<>(replyInfos));
    }

    @Override
    public ResultDO<Boolean> postReply(TForumReplyInfo replyInfo) {
        if(replyInfo.getReplyThemeId() == null || replyInfo.getReplyUserId() == null){
            return new ResultDO<>(false,"回复失败,请刷新页面重试");
        }
        if (replyInfo.getReplyContent().length() > 2000){
            return new ResultDO<>(false,"回复内容太长了哦");
        }
        replyInfo.setCreatorUserName(replyInfo.getReplyUserName());
        replyInfo.setModifierUserName(replyInfo.getReplyUserName());
        replyInfo.setReplyFloor(replyInfoMapper.selectReplyFloor(replyInfo.getReplyThemeId()));
        bForumThemeInfoMapper.updateThemeReplyCount(replyInfo.getReplyThemeId());
        int i = tForumReplyInfoMapper.insertSelective(replyInfo);
        if(i == 1){
            return new ResultDO<>(true);
        }
        return new ResultDO<>(false,"回复失败,请稍后重试!");
    }
}
