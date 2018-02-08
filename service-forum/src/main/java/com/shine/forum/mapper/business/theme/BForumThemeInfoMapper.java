package com.shine.forum.mapper.business.theme;

import com.shine.cm.common.bean.business.forum.BForumThemeInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;

import java.util.List;

public interface BForumThemeInfoMapper {
    List<BForumThemeInfo> selectThemePageList(Long topicId);

    BForumThemeInfo getThemeById(Long themeId);

    Integer updateThemeReplyCount(Long themeId);

    List<TForumThemeInfo> getThemeByUserId(Long userId);
}