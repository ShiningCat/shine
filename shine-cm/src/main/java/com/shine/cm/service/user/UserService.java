package com.shine.cm.service.user;


import com.shine.cm.common.bean.business.user.UserFavoriteInfo;
import com.shine.cm.common.bean.db.TMemUserFavorite;
import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.cm.common.bean.db.TMemUserLogin;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

public interface UserService {


    public ResultDO<TMemUserInfo> createUser (TMemUserLogin user);

    public ResultDO<String> resetPassword (String email, String newPassword);

    public ResultDO<Boolean> confirmUser (String mail);

    public ResultDO<TMemUserInfo> getUser(Long userId);

    public ResultDO<PageBean<UserFavoriteInfo>> getFavorites(Long userId, Integer limit, Integer page);
}