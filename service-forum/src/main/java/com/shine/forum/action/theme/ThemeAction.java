package com.shine.forum.action.theme;

import com.shine.cm.common.bean.business.forum.BForumThemeInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.cm.service.forum.theme.ThemeService;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ThemeAction {

    @Autowired
    private ThemeService themeService;

    @GetMapping(value = "/themes")
    public ResultDO<PageBean<BForumThemeInfo>> themes(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "topicId") Long topicId ){
        return themeService.themes(pageNum, topicId);
    }
    @PostMapping(value = "/themes")
    ResultDO<Boolean> postTheme(@RequestBody TForumThemeInfo themeInfo){
        return themeService.postTheme(themeInfo);
    }

    @GetMapping(value = "/themes/{themeId}")
    public ResultDO<BForumThemeInfo> theme(@PathVariable(value = "themeId") Long themeId){
        return themeService.theme(themeId);
    }
}
