package com.shine.web.controller.comment;

import com.shine.cm.common.bean.business.forum.BForumCommentInfo;
import com.shine.cm.common.bean.db.TForumCommentInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import com.shine.web.controller.BaseController;
import com.shine.web.feign.comment.CommentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController extends BaseController {

    @Autowired
    private CommentFeignClient commentFeignClient;

    @GetMapping("/comments")
    public ResultDO<PageBean<BForumCommentInfo>> comments(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "replyId") Long replyId){
        return commentFeignClient.comments(pageNum,replyId);
    }

    @PostMapping("/comments")
    public ResultDO<Boolean> postComment(TForumCommentInfo commentInfo){
        return commentFeignClient.postComment(commentInfo);
    }
}
