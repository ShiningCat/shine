package com.shine.user.mapper.business;

import com.shine.cm.common.bean.db.TForumThemeInfo;

import java.util.List;

public interface BForumThemeInfoMapper {


    List<TForumThemeInfo> selectByUserId(Long userId);

}
