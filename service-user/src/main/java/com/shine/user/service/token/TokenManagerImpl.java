package com.shine.user.service.token;

import com.shine.cm.common.bean.business.token.Token;
import com.shine.cm.common.bean.db.TMemUserInfo;
import com.shine.cm.service.user.token.TokenManager;
import com.shine.common.entity.RedisBean;
import com.shine.common.util.MD5;
import com.shine.user.fegin.RedisFeign;
import com.shine.user.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenManagerImpl extends BaseService implements TokenManager {

    @Autowired
    private RedisFeign redisFeign;

    @Override
    public Token createToken(TMemUserInfo userInfo) {
        String tokenId = MD5.md5(System.currentTimeMillis()+"");
        Token token = new Token(tokenId,userInfo);
        RedisBean redisBean = new RedisBean(tokenId, userInfo, 84000L);
        Boolean tokenFlag = redisFeign.putRedis(redisBean);
        return tokenFlag == true ? token : new Token();
    }

    @Override
    public boolean checkToken(String tokenId){
        return redisFeign.exists(tokenId);
    }

    @Override
    public Token getToken(String tokenId) {
        RedisBean redisBean = redisFeign.getRedis(tokenId);

        TMemUserInfo userInfo = (TMemUserInfo) redisBean.getValue();
        return new Token(tokenId,userInfo);
    }

    @Override
    public boolean deleteToken(String token) {
        return redisFeign.delRedis(token);
    }
}
