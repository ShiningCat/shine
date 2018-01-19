package com.shine.user.mapper.business;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BMemUserLoginMapper {

    String getSaltByEmail(String email);

    Integer resetPassword(@Param(value = "email") String email, @Param(value = "password") String password, @Param(value = "salt") String salt);

    @Update("update ${db.shine}.mem_user_login set DEL_FLAG = 1 where EMAIL = #{mail,jdbcType=VARCHAR}")
    Integer setUserStatus(String mail);
}
