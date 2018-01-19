package com.shine.cm.service.forum.topic;

import com.shine.cm.common.bean.db.TForumTopicInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;


public interface TopicService {

    public ResultDO<PageBean<TForumTopicInfo>> topics(Integer limit,Integer page);

    public ResultDO<TForumTopicInfo> topic(Long topicId);

    public ResultDO<Boolean> createTopic (TForumTopicInfo bean);

    public ResultDO<Boolean> delTopic (TForumTopicInfo bean);

    public ResultDO<Boolean> setTopic (TForumTopicInfo bean);

}
