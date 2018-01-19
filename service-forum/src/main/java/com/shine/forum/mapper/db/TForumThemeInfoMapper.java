package com.shine.forum.mapper.db;

import com.shine.cm.common.bean.db.TForumThemeInfo;
import java.util.Date;

/**
 * <p>操作表forum_theme_info的dao层 .</p>
 * <p>包含方法：</p>
 * <li>  <p>根据数据库主键物理删除表forum_theme_info记录 </p>:int deleteByPrimaryKey()</li>
 * <li>  <p>插入表forum_theme_info记录，sql中没有空判断 </p>:int insert()</li>
 * <li>  <p>插入表forum_theme_info记录，sql中有空判断 </p>:int insertSelective()</li>
 * <li>  <p>根据[Long themeId]查询表forum_theme_info记录 </p>:com.shine.cm.common.bean.db.TForumThemeInfo selectByPrimaryKey()</li>
 * <li>  <p>修改表forum_theme_info记录，sql中有空判断 </p>:int updateByPrimaryKeySelective()</li>
 * <li>  <p>修改表forum_theme_info记录，sql中没有空判断 </p>:int updateByPrimaryKey()</li>
 * <li>  <p>获取数据库时间 </p>:java.util.Date getSystemTime()</li>
 * <li>  <p>逻辑删除 </p>:int logicDelete()</li>
 */
public interface TForumThemeInfoMapper {
    /**
     * <p>根据数据库主键物理删除表forum_theme_info记录 .</p>
     * @param java.lang.Long
     * @return int
     */
    int deleteByPrimaryKey(Long themeId);

    /**
     * <p>插入表forum_theme_info记录，sql中没有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TForumThemeInfo
     * @return int
     */
    int insert(TForumThemeInfo record);

    /**
     * <p>插入表forum_theme_info记录，sql中有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TForumThemeInfo
     * @return int
     */
    int insertSelective(TForumThemeInfo record);

    /**
     * <p>根据[Long themeId]查询表forum_theme_info记录 .</p>
     * @param java.lang.Long
     * @return com.shine.cm.common.bean.db.TForumThemeInfo
     */
    TForumThemeInfo selectByPrimaryKey(Long themeId);

    /**
     * <p>修改表forum_theme_info记录，sql中有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TForumThemeInfo
     * @return int
     */
    int updateByPrimaryKeySelective(TForumThemeInfo record);

    /**
     * <p>修改表forum_theme_info记录，sql中没有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TForumThemeInfo
     * @return int
     */
    int updateByPrimaryKey(TForumThemeInfo record);

    /**
     * <p>获取数据库时间 .</p>
     * @return java.util.Date
     */
    Date getSystemTime();

    /**
     * <p>逻辑删除 .</p>
     * @param com.shine.cm.common.bean.db.TForumThemeInfo
     * @return int
     */
    int logicDelete(TForumThemeInfo bean);
}