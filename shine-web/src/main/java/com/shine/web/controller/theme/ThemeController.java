package com.shine.web.controller.theme;

import com.shine.cm.common.bean.business.forum.BForumThemeInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import com.shine.web.controller.BaseController;
import com.shine.web.feign.theme.ThemeFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThemeController extends BaseController{

    @Autowired
    private ThemeFeignClient themeFeignClient;

    @GetMapping(value = "/themes")
    public ResultDO<PageBean<BForumThemeInfo>> themes(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "topicId") Long topicId){

        return themeFeignClient.themes(pageNum,topicId);
    }
    @PostMapping(value = "/themes")
    public ResultDO<Boolean> themes(TForumThemeInfo themeInfo){

        return themeFeignClient.postTheme(themeInfo);
    }

    @GetMapping(value = "/themes/{themeId}")
    public ResultDO<BForumThemeInfo> theme(@PathVariable(value = "themeId") Long themeId){

        return themeFeignClient.theme(themeId);
    }
}
