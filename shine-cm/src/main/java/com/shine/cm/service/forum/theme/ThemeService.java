package com.shine.cm.service.forum.theme;

import com.shine.cm.common.bean.business.forum.BForumThemeInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

public interface ThemeService {
    public ResultDO<PageBean<BForumThemeInfo>> themes(Integer pageNum, Long topicId);

    public ResultDO<Boolean> postTheme (TForumThemeInfo themeInfo);

    public ResultDO<BForumThemeInfo> theme(Long themeId);
}
