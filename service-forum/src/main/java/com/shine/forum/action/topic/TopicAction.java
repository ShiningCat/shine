package com.shine.forum.action.topic;

import com.shine.cm.common.bean.db.TForumTopicInfo;
import com.shine.cm.service.forum.topic.TopicService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicAction {

    @Autowired
    private TopicService topicService;

    @GetMapping(value = "/topic")
    public ResultDO<PageBean<TForumTopicInfo>> topics(@RequestParam Integer limit, @RequestParam Integer page) {
        return topicService.topics(limit, page);
    }

    @GetMapping(value = "/topic/{topicId}")
    public ResultDO<TForumTopicInfo> topic(@PathVariable Long topicId) {
        return topicService.topic(topicId);
    }

    @PutMapping(value = "/topic")
    public ResultDO<Boolean> setTopic(TForumTopicInfo bean){
        return topicService.setTopic(bean);
    }

    @DeleteMapping(value = "/topic")
    public ResultDO<Boolean> delTopic(TForumTopicInfo bean){
        return topicService.delTopic(bean);
    }

    @PostMapping(value = "/topic")
    public ResultDO<Boolean> createTopic(@RequestBody TForumTopicInfo bean){
        return  topicService.createTopic(bean);
    }

}
