package com.shine.cm.service.user;

import com.shine.cm.common.bean.business.user.BMemUserLogin;
import com.shine.cm.common.bean.db.TForumThemeInfo;
import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.cm.common.bean.db.TMemUserLogin;
import com.shine.common.vo.PageBean;
import com.shine.common.vo.ResultDO;

public interface UserService {


    public ResultDO<TMemUserInfo> createUser (TMemUserLogin user);

    public ResultDO<PageBean<TForumThemeInfo>> getUserThemes(Long userId, Integer limit, Integer page);

    public ResultDO<String> resetPassword (String email, String newPassword);

    public ResultDO<Boolean> confirmUser (String mail);

}