package com.shine.forum.mapper.business.theme;

import com.shine.cm.common.bean.business.forum.BForumThemeInfo;

import java.util.List;

public interface BForumThemeInfoMapper {
    List<BForumThemeInfo> selectThemePageList(Long topicId);
}