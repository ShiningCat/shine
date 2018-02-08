package com.shine.user.feign.user;

import com.shine.cm.common.bean.business.user.UserCommentInfo;
import com.shine.cm.common.bean.business.user.UserReplyInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-forum")
public interface UserActivityFeign {

    @RequestMapping(value = "/{userId}/themes", method = RequestMethod.GET)
    ResultDO<PageBean<TForumThemeInfo>> getUserThemes(@PathVariable(value = "userId") Long userId, @RequestParam(value = "limit") Integer limit, @RequestParam(value = "page") Integer page);

    @RequestMapping(value = "/{userId}/reply", method = RequestMethod.GET)
    ResultDO<PageBean<UserReplyInfo>> getUserReply(@PathVariable(value = "userId") Long userId, @RequestParam(value = "limit") Integer limit, @RequestParam(value = "page") Integer page);

    @GetMapping(value = "/{userId}/comments")
    ResultDO<PageBean<UserCommentInfo>> getUserComments(@PathVariable(value = "userId") Long userId, @RequestParam(value = "limit") Integer limit, @RequestParam(value = "page") Integer page);
}
