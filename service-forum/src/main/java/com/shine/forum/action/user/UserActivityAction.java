package com.shine.forum.action.user;

import com.shine.cm.common.bean.business.user.UserCommentInfo;
import com.shine.cm.common.bean.business.user.UserReplyInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.cm.service.user.UserActivityService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserActivityAction {

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping(value = "/{userId}/themes")
    ResultDO<PageBean<TForumThemeInfo>> getUserThemes(@PathVariable Long userId, @RequestParam Integer limit, @RequestParam Integer page){
        return userActivityService.getUserThemes(userId,limit,page);
    }

    @GetMapping(value = "/{userId}/reply")
    ResultDO<PageBean<UserReplyInfo>> getUserReply(@PathVariable Long userId, @RequestParam Integer limit, @RequestParam Integer page){
        return userActivityService.getUserReply(userId,limit,page);
    }

    @GetMapping(value = "/{userId}/comments")
    ResultDO<PageBean<UserCommentInfo>> getUserComments(@PathVariable Long userId, @RequestParam Integer limit, @RequestParam Integer page){
        return userActivityService.getUserComments(userId,limit,page);
    }

}
