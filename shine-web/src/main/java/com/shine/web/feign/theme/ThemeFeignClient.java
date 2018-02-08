package com.shine.web.feign.theme;

import com.shine.cm.common.bean.business.forum.BForumThemeInfo;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-forum")
public interface ThemeFeignClient {

    @RequestMapping(value = "/themes", method = RequestMethod.GET)
    ResultDO<PageBean<BForumThemeInfo>> themes(@RequestParam(value = "page")Integer pageNum, @RequestParam(value = "topicId") Long topicId);

    @RequestMapping(value = "/themes", method = RequestMethod.POST)
    ResultDO<Boolean> postTheme(@RequestBody TForumThemeInfo themeInfo);

    @RequestMapping(value = "/themes/{themeId}", method = RequestMethod.GET)
    ResultDO<BForumThemeInfo> theme(@PathVariable(value = "themeId")  Long themeId);
}
