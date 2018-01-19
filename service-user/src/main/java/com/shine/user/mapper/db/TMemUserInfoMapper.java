package com.shine.user.mapper.db;

import com.shine.cm.common.bean.db.TMemUserInfo;
import java.util.Date;

/**
 * <p>操作表mem_user_info的dao层 .</p>
 * <p>包含方法：</p>
 * <li>  <p>根据数据库主键物理删除表mem_user_info记录 </p>:int deleteByPrimaryKey()</li>
 * <li>  <p>插入表mem_user_info记录，sql中没有空判断 </p>:int insert()</li>
 * <li>  <p>插入表mem_user_info记录，sql中有空判断 </p>:int insertSelective()</li>
 * <li>  <p>根据[Long userId]查询表mem_user_info记录 </p>:com.shine.cm.common.bean.db.TMemUserInfo selectByPrimaryKey()</li>
 * <li>  <p>修改表mem_user_info记录，sql中有空判断 </p>:int updateByPrimaryKeySelective()</li>
 * <li>  <p>修改表mem_user_info记录，sql中没有空判断 </p>:int updateByPrimaryKey()</li>
 * <li>  <p>获取数据库时间 </p>:java.util.Date getSystemTime()</li>
 * <li>  <p>逻辑删除 </p>:int logicDelete()</li>
 */
public interface TMemUserInfoMapper {
    /**
     * <p>根据数据库主键物理删除表mem_user_info记录 .</p>
     * @param java.lang.Long
     * @return int
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * <p>插入表mem_user_info记录，sql中没有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserInfo
     * @return int
     */
    int insert(TMemUserInfo record);

    /**
     * <p>插入表mem_user_info记录，sql中有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserInfo
     * @return int
     */
    int insertSelective(TMemUserInfo record);

    /**
     * <p>根据[Long userId]查询表mem_user_info记录 .</p>
     * @param java.lang.Long
     * @return com.shine.cm.common.bean.db.TMemUserInfo
     */
    TMemUserInfo selectByPrimaryKey(Long userId);

    /**
     * <p>修改表mem_user_info记录，sql中有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserInfo
     * @return int
     */
    int updateByPrimaryKeySelective(TMemUserInfo record);

    /**
     * <p>修改表mem_user_info记录，sql中没有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserInfo
     * @return int
     */
    int updateByPrimaryKey(TMemUserInfo record);

    /**
     * <p>获取数据库时间 .</p>
     * @return java.util.Date
     */
    Date getSystemTime();

    /**
     * <p>逻辑删除 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserInfo
     * @return int
     */
    int logicDelete(TMemUserInfo bean);
}