package com.shine.user.feign.user;

import com.shine.cm.common.bean.business.user.UserFavoriteInfo;

import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.cm.common.bean.db.TMemUserLogin;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

import org.springframework.stereotype.Component;

@Component
public class UserFallbark implements UserFeign {

    @Override
    public ResultDO<TMemUserInfo> creationUser(TMemUserLogin userLoginBean) {
        return null;
    }

    @Override
    public ResultDO<Boolean> confirmUser(String code) {
        return new ResultDO<>();
    }

    @Override
    public ResultDO<Boolean> sendMsg(String email) {
        return null;
    }

    @Override
    public ResultDO<String> resetPassword(String code) {
        return null;
    }

    @Override
    public ResultDO<String> resetPassword(String code, String newPassword) {
        return null;
    }

    @Override
    public ResultDO<TMemUserInfo> getUser(Long userId) {
        return null;
    }

    @Override
    public ResultDO<PageBean<UserFavoriteInfo>> getFavorites(Long userId, Integer limit, Integer page) {
        return null;
    }
}
