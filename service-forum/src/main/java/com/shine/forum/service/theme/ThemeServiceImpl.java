package com.shine.forum.service.theme;

import com.github.pagehelper.PageHelper;
import com.shine.cm.common.bean.business.forum.BForumThemeInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.cm.service.forum.theme.ThemeService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import com.shine.forum.mapper.business.theme.BForumThemeInfoMapper;
import com.shine.forum.mapper.db.TForumThemeInfoMapper;
import com.shine.forum.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ThemeServiceImpl extends BaseService implements ThemeService{

    @Resource
    private BForumThemeInfoMapper bForumThemeInfoMapper;

    @Resource
    private TForumThemeInfoMapper tForumThemeInfoMapper;

    @Override
    public ResultDO<PageBean<BForumThemeInfo>> themes(Integer pageNum, Long topicId) {
        PageBean pageBean = new PageBean();
        PageHelper.startPage(pageNum, pageBean.getPageSize());
        List<BForumThemeInfo> themeInfos = bForumThemeInfoMapper.selectThemePageList(topicId);
        return new ResultDO<PageBean<BForumThemeInfo>>(new PageBean<>(themeInfos));
    }

    @Override
    public ResultDO<Boolean> postTheme(TForumThemeInfo themeInfo) {
        if(themeInfo.getThemeUserId() == null || themeInfo.getThemeTopicId() == null){
            return new ResultDO<>(false,"发帖失败,请刷新页面重试");
        }
        if(themeInfo.getThemeName().length() > 40){
            return new ResultDO<>(false,"标题太长了哦");
        }
        if(themeInfo.getThemeContent().length() > 2000){
            return new ResultDO<>(false,"内容太长了哦");
        }
        themeInfo.setCreatorUserName(themeInfo.getThemeUserName());
        themeInfo.setModifierUserName(themeInfo.getThemeUserName());
        int i = tForumThemeInfoMapper.insertSelective(themeInfo);
        if(i == 1){
            return new ResultDO<Boolean>();
        } else {
            return new ResultDO<>(false,"发帖失败,请稍后重试");
        }
    }

    @Override
    public ResultDO<BForumThemeInfo> theme(Long themeId) {
        return new ResultDO<>(bForumThemeInfoMapper.getThemeById(themeId));
    }
}
