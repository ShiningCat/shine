package com.shine.forum.mapper.db;

import com.shine.cm.common.bean.db.TForumReplyInfo;
import java.util.Date;

/**
 * <p>操作表forum_reply_info的dao层 .</p>
 * <p>包含方法：</p>
 * <li>  <p>根据数据库主键物理删除表forum_reply_info记录 </p>:int deleteByPrimaryKey()</li>
 * <li>  <p>插入表forum_reply_info记录，sql中没有空判断 </p>:int insert()</li>
 * <li>  <p>插入表forum_reply_info记录，sql中有空判断 </p>:int insertSelective()</li>
 * <li>  <p>根据[Long replyId]查询表forum_reply_info记录 </p>:com.shine.cm.common.bean.db.TForumReplyInfo selectByPrimaryKey()</li>
 * <li>  <p>修改表forum_reply_info记录，sql中有空判断 </p>:int updateByPrimaryKeySelective()</li>
 * <li>  <p>修改表forum_reply_info记录，sql中没有空判断 </p>:int updateByPrimaryKey()</li>
 * <li>  <p>获取数据库时间 </p>:java.util.Date getSystemTime()</li>
 * <li>  <p>逻辑删除 </p>:int logicDelete()</li>
 */
public interface TForumReplyInfoMapper {
    /**
     * <p>根据数据库主键物理删除表forum_reply_info记录 .</p>
     * @param java.lang.Long
     * @return int
     */
    int deleteByPrimaryKey(Long replyId);

    /**
     * <p>插入表forum_reply_info记录，sql中没有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TForumReplyInfo
     * @return int
     */
    int insert(TForumReplyInfo record);

    /**
     * <p>插入表forum_reply_info记录，sql中有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TForumReplyInfo
     * @return int
     */
    int insertSelective(TForumReplyInfo record);

    /**
     * <p>根据[Long replyId]查询表forum_reply_info记录 .</p>
     * @param java.lang.Long
     * @return com.shine.cm.common.bean.db.TForumReplyInfo
     */
    TForumReplyInfo selectByPrimaryKey(Long replyId);

    /**
     * <p>修改表forum_reply_info记录，sql中有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TForumReplyInfo
     * @return int
     */
    int updateByPrimaryKeySelective(TForumReplyInfo record);

    /**
     * <p>修改表forum_reply_info记录，sql中没有空判断 .</p>
     * @param com.shine.cm.common.bean.db.TForumReplyInfo
     * @return int
     */
    int updateByPrimaryKey(TForumReplyInfo record);

    /**
     * <p>获取数据库时间 .</p>
     * @return java.util.Date
     */
    Date getSystemTime();

    /**
     * <p>逻辑删除 .</p>
     * @param com.shine.cm.common.bean.db.TForumReplyInfo
     * @return int
     */
    int logicDelete(TForumReplyInfo bean);
}