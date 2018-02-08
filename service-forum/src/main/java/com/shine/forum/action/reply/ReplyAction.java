package com.shine.forum.action.reply;

import com.shine.cm.common.bean.business.forum.BForumReplyInfo;
import com.shine.cm.common.bean.business.forum.BForumThemeInfo;
import com.shine.cm.common.bean.db.TForumReplyInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.cm.service.forum.reply.ReplyService;
import com.shine.cm.service.forum.theme.ThemeService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReplyAction {

    @Autowired
    private ReplyService replyService;

    @GetMapping(value = "/reply")
    public ResultDO<PageBean<BForumReplyInfo>> replys(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "themeId") Long themeId ){
        return replyService.replys(pageNum, themeId);
    }
    @PostMapping(value = "/reply")
    ResultDO<Boolean> postTheme(@RequestBody TForumReplyInfo replyInfo){
        return replyService.postReply(replyInfo);
    }
}
