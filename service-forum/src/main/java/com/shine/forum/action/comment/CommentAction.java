package com.shine.forum.action.comment;

import com.shine.cm.common.bean.business.forum.BForumCommentInfo;
import com.shine.cm.common.bean.db.TForumCommentInfo;
import com.shine.cm.service.forum.comment.CommentService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentAction {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResultDO<PageBean<BForumCommentInfo>> comments(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "replyId") Long replyId){

        return commentService.comments(pageNum,replyId);
    }

    @PostMapping("/comments")
    public ResultDO<Boolean> postComment(@RequestBody TForumCommentInfo commentInfo){
        return commentService.postComment(commentInfo);
    }
}
