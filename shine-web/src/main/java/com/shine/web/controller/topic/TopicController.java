package com.shine.web.controller.topic;

import com.shine.web.controller.BaseController;
import com.shine.web.feign.topic.TopicFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController extends BaseController{

    @Autowired
    private TopicFeignClient topicFeignClient;

    @GetMapping(value = "/topic")
    public Object topics(@RequestParam(defaultValue = "20") Integer limit, @RequestParam(defaultValue = "1") Integer page) {

        return topicFeignClient.topics(limit, page);
    }

    @GetMapping(value = "/topic/{topicId}")
    public Object topic(@PathVariable Long topicId) {
        return topicFeignClient.topic(topicId);
    }
}