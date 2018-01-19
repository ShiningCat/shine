package com.shine.web.controller.theme;

import com.shine.cm.common.bean.business.forum.BForumThemeInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import com.shine.web.controller.BaseController;
import com.shine.web.feign.theme.ThemeFeginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThemeController extends BaseController{

    @Autowired
    private ThemeFeginClient themeFeginClient;

    @GetMapping(value = "/theme")
    public ResultDO<PageBean<BForumThemeInfo>> themes(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "topicId") Integer topicId){

        return themeFeginClient.themes(pageNum,topicId);
    }
    @PostMapping(value = "/theme")
    public ResultDO<Boolean> themes(TForumThemeInfo themeInfo){

        return themeFeginClient.postTheme(themeInfo);
    }
}
