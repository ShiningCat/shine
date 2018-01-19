package com.shine.forum.mapper.business.topic;

import com.shine.cm.common.bean.db.TForumTopicInfo;

import java.util.List;

public interface BForumTopicInfoMapper {

    List<TForumTopicInfo> selectAll();
}
