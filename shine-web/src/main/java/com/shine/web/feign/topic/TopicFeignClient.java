package com.shine.web.feign.topic;

import com.shine.cm.common.bean.db.TForumTopicInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-forum")
public interface TopicFeignClient {
    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    ResultDO<PageBean<TForumTopicInfo>> topics(@RequestParam(value = "limit") Integer limit, @RequestParam(value = "page") Integer page);

    @RequestMapping(value = "/topics/{topicId}", method = RequestMethod.GET)
    ResultDO<TForumTopicInfo> topic(@PathVariable(value = "topicId") Long topicId);
}
