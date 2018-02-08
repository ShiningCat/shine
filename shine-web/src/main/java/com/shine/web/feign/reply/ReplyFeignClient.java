package com.shine.web.feign.reply;

import com.shine.cm.common.bean.business.forum.BForumReplyInfo;
import com.shine.cm.common.bean.db.TForumReplyInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-forum")
public interface ReplyFeignClient {

    @RequestMapping(value = "/reply", method = RequestMethod.GET)
    ResultDO<PageBean<BForumReplyInfo>> replys(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "themeId") Long themeId);

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    ResultDO<Boolean> postReply(@RequestBody TForumReplyInfo replyInfo);
}
