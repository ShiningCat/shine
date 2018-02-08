package com.shine.web.controller.reply;

import com.shine.cm.common.bean.business.forum.BForumReplyInfo;
import com.shine.cm.common.bean.db.TForumReplyInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import com.shine.web.controller.BaseController;
import com.shine.web.feign.reply.ReplyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReplyController extends BaseController {

    @Autowired
    private ReplyFeignClient replyFeignClient;

    @GetMapping(value = "/reply")
    public ResultDO<PageBean<BForumReplyInfo>> replys(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "themeId") Long themeId){
        return replyFeignClient.replys(pageNum,themeId);
    }

    @PostMapping(value = "/reply")
    public ResultDO<Boolean> postReply(TForumReplyInfo replyInfo){
        return replyFeignClient.postReply(replyInfo);
    }

}
