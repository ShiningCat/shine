package com.shine.user.mapper.business;


import com.shine.cm.common.bean.business.user.UserFavoriteInfo;

import java.util.List;

public interface BMemUserFavoriteMapper {

    List<UserFavoriteInfo> getFavoriteByUserId(Long userId);

}