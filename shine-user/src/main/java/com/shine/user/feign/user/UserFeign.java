package com.shine.user.feign.user;

import com.shine.cm.common.bean.business.user.UserFavoriteInfo;
import com.shine.cm.common.bean.db.TMemUserFavorite;
import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.cm.common.bean.db.TMemUserLogin;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "service-user", fallback = UserFallbark.class)
public interface UserFeign {
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    ResultDO<TMemUserInfo> creationUser(@RequestBody TMemUserLogin userLoginBean);

    @RequestMapping(value = "/users/confirm_verification/{code}" ,method = RequestMethod.GET)
    ResultDO<Boolean> confirmUser(@PathVariable(value = "code")  String code);

    @RequestMapping(value = "/users/update_password/mail", method = RequestMethod.POST)
    ResultDO<Boolean> sendMsg(@RequestParam(value = "email") String email);

    @RequestMapping(value = "/users/update_password/{code}", method = RequestMethod.GET)
    ResultDO<String> resetPassword(@PathVariable(value = "code") String code);

    @RequestMapping(value = "/users/update_password", method = RequestMethod.POST)
    ResultDO<String> resetPassword(@RequestParam(value = "code") String code, @RequestParam(value = "password") String password);

    @RequestMapping(value = "/users/{userId}")
    ResultDO<TMemUserInfo> getUser(@PathVariable(value = "userId")  Long userId);

    @RequestMapping(value = "/users/{userId}/favorites")
    ResultDO<PageBean<UserFavoriteInfo>> getFavorites(@PathVariable(value = "userId")  Long userId, @RequestParam(value = "limit") Integer limit, @RequestParam(value = "page") Integer page);
}
