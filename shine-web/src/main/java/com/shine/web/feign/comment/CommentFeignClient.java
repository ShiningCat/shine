package com.shine.web.feign.comment;

import com.shine.cm.common.bean.business.forum.BForumCommentInfo;
import com.shine.cm.common.bean.db.TForumCommentInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-forum")
public interface CommentFeignClient {

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResultDO<PageBean<BForumCommentInfo>> comments(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "replyId") Long replyId);

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public ResultDO<Boolean> postComment(@RequestBody TForumCommentInfo commentInfo);
}
