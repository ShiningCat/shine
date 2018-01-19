package com.shine.cm.service.user.token;

import com.shine.cm.common.bean.business.token.Token;
import com.shine.cm.common.bean.db.TMemUserInfo;

public interface TokenManager {
    /**
     * 创建一个 token 关联上指定用户
     * @return 生成的 token
     */
    public Token createToken (TMemUserInfo userInfo);
    /**
     * 检查 token 是否有效
     * @return 是否有效
     */
    public boolean checkToken (String token);
    /**
     * 获取token对象
     * @return
     */
    public Token getToken (String token);
    /**
     * 清除 token
     */
    public boolean deleteToken (String token);
}