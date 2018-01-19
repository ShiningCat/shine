package com.shine.user.mapper.business;

import com.shine.cm.common.bean.db.TMemUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

@Mapper
public interface BMemUserInfoMapper {

    TMemUserInfo selectByEmail(String email);

    TMemUserInfo selectByPhoneNum(String phone);

    TMemUserInfo selectUserByCheckPassword(@Param("email") String email, @Param("password") String password);

    Integer getUserByName(String userName);

    Integer insertSelectiveReturnKey(TMemUserInfo userInfo);

    @Update("update ${db.shine}.mem_user_info set del_flag = 1 where EMAIL =  #{mail,jdbcType=VARCHAR}")
    Integer setUserStatus(String mail);
}
