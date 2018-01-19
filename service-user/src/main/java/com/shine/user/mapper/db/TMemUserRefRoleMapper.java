package com.shine.user.mapper.db;

import com.shine.cm.common.bean.db.TMemUserRefRole;
import java.util.Date;

/**
 * <p>操作表mem_user_ref_role的dao层 .</p>
 * <p>包含方法：</p>
 * <li>  <p>根据数据库主键物理删除表mem_user_ref_role记录 </p>:int deleteByPrimaryKey()</li>
 * <li>  <p>插入表mem_user_ref_role记录，sql中没有空判断 </p>:int insert()</li>
 * <li>  <p>插入表mem_user_ref_role记录，sql中有空判断 </p>:int insertSelective()</li>
 * <li>  <p>根据[Long refId]查询表mem_user_ref_role记录 </p>:com.shine.cm.common.bean.db.TMemUserRefRole selectByPrimaryKey()</li>
 * <li>  <p>修改表mem_user_ref_role记录，sql中有空判断 </p>:int updateByPrimaryKeySelective()</li>
 * <li>  <p>修改表mem_user_ref_role记录，sql中没有空判断 </p>:int updateByPrimaryKey()</li>
 * <li>  <p>获取数据库时间 </p>:java.util.Date getSystemTime()</li>
 * <li>  <p>逻辑删除 </p>:int logicDelete()</li>
 */
public interface TMemUserRefRoleMapper {
    /**
     * <p>根据数据库主键物理删除表mem_user_ref_role记录 .</p>
     * @param java.lang.Long
     * @return int
     */
    int deleteByPrimaryKey(Long refId);

    /**
     * <p>插入表mem_user_ref_role记录，sql中没有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserRefRole
     * @return int
     */
    int insert(TMemUserRefRole record);

    /**
     * <p>插入表mem_user_ref_role记录，sql中有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserRefRole
     * @return int
     */
    int insertSelective(TMemUserRefRole record);

    /**
     * <p>根据[Long refId]查询表mem_user_ref_role记录 .</p>
     * @param java.lang.Long
     * @return com.shine.cm.common.bean.db.TMemUserRefRole
     */
    TMemUserRefRole selectByPrimaryKey(Long refId);

    /**
     * <p>修改表mem_user_ref_role记录，sql中有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserRefRole
     * @return int
     */
    int updateByPrimaryKeySelective(TMemUserRefRole record);

    /**
     * <p>修改表mem_user_ref_role记录，sql中没有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserRefRole
     * @return int
     */
    int updateByPrimaryKey(TMemUserRefRole record);

    /**
     * <p>获取数据库时间 .</p>
     * @return java.util.Date
     */
    Date getSystemTime();

    /**
     * <p>逻辑删除 .</p>
     * @param com.shine.cm.common.bean.db.TMemUserRefRole
     * @return int
     */
    int logicDelete(TMemUserRefRole bean);
}