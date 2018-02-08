/*
MySQL - 5.5.5-10.2.8-MariaDB-10.2.8+maria~jessie : Database - shine
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shine` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shine`;

/*Table structure for table `forum_comment_info` */

DROP TABLE IF EXISTS `forum_comment_info`;

CREATE TABLE `forum_comment_info` (
  `COMMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `COMMENT_REPLY_ID` bigint(20) DEFAULT NULL COMMENT '评论回复ID',
  `COMMENT_USER_ID` bigint(20) DEFAULT NULL COMMENT '评论人用户ID',
  `COMMENT_USER_NAME` varchar(20) DEFAULT NULL COMMENT '评论人用户名称 ',
  `COMMENT_CONTENT` varchar(400) DEFAULT NULL COMMENT '评论内容',
  `REPLY_SOMEONE` tinyint(2) NOT NULL DEFAULT 2 COMMENT '是否回复某人(1-是；2-否)',
  `COMMENT_REPLY_USER_ID` bigint(20) DEFAULT NULL COMMENT '被回复人ID',
  `COMMENT_REPLY_USER_NAME` varchar(20) DEFAULT NULL COMMENT '被回复人昵称',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人名称',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) NOT NULL DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`COMMENT_ID`),
  KEY `REPLY_ID` (`COMMENT_REPLY_ID`),
  KEY `USER_ID` (`COMMENT_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Table structure for table `forum_reply_info` */

DROP TABLE IF EXISTS `forum_reply_info`;

CREATE TABLE `forum_reply_info` (
  `REPLY_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回复ID',
  `REPLY_THEME_ID` bigint(20) DEFAULT NULL COMMENT '回复话题ID',
  `REPLY_USER_ID` bigint(20) DEFAULT NULL COMMENT '回复用户ID',
  `REPLY_USER_NAME` varchar(20) DEFAULT NULL COMMENT '回复用户名称',
  `REPLY_CONTENT` varchar(2000) DEFAULT NULL COMMENT '回复内容',
  `REPLY_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '回复时间',
  `REPLY_FLOOR` int(11) DEFAULT NULL COMMENT '回复楼层',
  `REPLY_COMMENT_NUMBER` int(11) DEFAULT 0 COMMENT '回复评论数量',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`REPLY_ID`),
  KEY `THEME_ID` (`REPLY_THEME_ID`),
  KEY `USER_ID` (`REPLY_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Table structure for table `forum_theme_info` */

DROP TABLE IF EXISTS `forum_theme_info`;

CREATE TABLE `forum_theme_info` (
  `THEME_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '话题(帖子)ID',
  `THEME_TOPIC_ID` bigint(20) DEFAULT NULL COMMENT '话题(帖子)所属主题(板块)Id',
  `THEME_USER_ID` bigint(20) DEFAULT NULL COMMENT '话题(帖子)发表人ID',
  `THEME_NAME` varchar(50) DEFAULT NULL COMMENT '话题(帖子)名称',
  `THEME_USER_NAME` varchar(20) DEFAULT NULL COMMENT '话题(帖子)发表人名称',
  `THEME_CONTENT` varchar(2000) DEFAULT NULL COMMENT '话题(帖子)内容',
  `THEME_REPLY_NUMBER` int(11) DEFAULT 0 COMMENT '话题(帖子)回复数量',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`THEME_ID`),
  KEY `TOPIC_ID` (`THEME_TOPIC_ID`),
  KEY `USER_ID` (`THEME_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Table structure for table `forum_topic_info` */

DROP TABLE IF EXISTS `forum_topic_info`;

CREATE TABLE `forum_topic_info` (
  `TOPIC_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主题(版块)ID',
  `TOPIC_NAME` varchar(40) DEFAULT NULL COMMENT '主题(版块)名称',
  `TOPIC_USER_ID` bigint(20) DEFAULT NULL COMMENT '主题(版块)创建人ID',
  `TOPIC_USER_NAME` varchar(20) DEFAULT NULL COMMENT '主题(版块)创建人名称',
  `TOPIC_IMAGE` varchar(200) DEFAULT NULL COMMENT '主题(版块)图片',
  `TOPIC_CONTENT` varchar(2000) DEFAULT NULL COMMENT '主题(版块)说明或发布公告内容',
  `TOPIC_THEME_NUMBER` int(11) DEFAULT NULL COMMENT '主题(版块)热门帖子数量',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(4) DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`TOPIC_ID`),
  KEY `USER_ID` (`TOPIC_USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Table structure for table `mem_email` */

DROP TABLE IF EXISTS `mem_email`;

CREATE TABLE `mem_email` (
  `EMAIL_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '邮件ID',
  `EMAIL_TYPE` tinyint(2) NOT NULL COMMENT '1,验证类',
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `CONFIRM_CODE` varchar(200) NOT NULL COMMENT '验证code',
  `EXPIRE_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '过期时间',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(1) DEFAULT 1 COMMENT '删除标识：1-正常；2-删除',
  PRIMARY KEY (`EMAIL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `mem_user_favorite` */

DROP TABLE IF EXISTS `mem_user_favorite`;

CREATE TABLE `mem_user_favorite` (
  `FAVORITE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收藏夹ID',
  `FAVORITE_USER_ID` bigint(20) NOT NULL COMMENT '收藏用户ID',
  `FAVORITE_THEME_ID` bigint(20) NOT NULL COMMENT '帖子ID',
  `FAVORITE_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '收藏时间',
  `MODIFY_TIME` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `DEL_FLAG` tinyint(2) DEFAULT NULL COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`FAVORITE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `mem_user_follow` */

DROP TABLE IF EXISTS `mem_user_follow`;

CREATE TABLE `mem_user_follow` (
  `FOLLOW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关注表ID',
  `FOLLOWERS_USER_ID` bigint(20) NOT NULL COMMENT '关注人ID',
  `FOLLOW_USER_ID` bigint(20) NOT NULL COMMENT '被关注人ID',
  `FOLLOW_EACH_OTHER` tinyint(2) NOT NULL DEFAULT 0 COMMENT '是否互相关注(0-否,1-是)',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`FOLLOW_ID`),
  KEY `FOLLOW_USER_ID` (`FOLLOW_USER_ID`),
  KEY `FOLLOWERS_USER_ID` (`FOLLOWERS_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `mem_user_info` */

DROP TABLE IF EXISTS `mem_user_info`;

CREATE TABLE `mem_user_info` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USER_NAME` varchar(20) DEFAULT NULL COMMENT '用户名称(昵称)',
  `SEX` tinyint(2) DEFAULT 0 COMMENT '用户性别 (0 默认 隐藏性别 1,男 ,2女)',
  `USER_AVATAR` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `PHONE` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `EMAIL` varchar(100) NOT NULL COMMENT '邮箱',
  `INTRODUCE` varchar(50) DEFAULT NULL COMMENT '个人介绍',
  `USER_LEVEL` tinyint(2) DEFAULT 0 COMMENT '用户等级',
  `THEME_NUMBER` int(11) DEFAULT 0 COMMENT '发帖数量',
  `REPLY_NUMBER` int(11) DEFAULT 0 COMMENT '回复数量',
  `COMMENT_NUMBER` int(11) DEFAULT 0 COMMENT '评论数',
  `USER_PRIVACY` tinyint(2) NOT NULL DEFAULT 0 COMMENT '隐私设置,0:开放,1:关闭',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `mem_user_login` */

DROP TABLE IF EXISTS `mem_user_login`;

CREATE TABLE `mem_user_login` (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `PHONE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `PASSWORD` varchar(40) NOT NULL COMMENT '密码',
  `PASSWORD_SALT` varchar(8) NOT NULL COMMENT '密码盐值',
  `EMAIL` varchar(100) NOT NULL COMMENT '邮箱',
  `USER_NAME` varchar(20) NOT NULL COMMENT '用户名(昵称)',
  `USER_LEVEL` tinyint(2) DEFAULT 0 COMMENT '用户等级(暂未开放)',
  `USER_ROLE` tinyint(2) DEFAULT 0 COMMENT '用户权限(暂未开放)',
  `LOGIN_TIME` timestamp NULL DEFAULT current_timestamp() COMMENT '用户上次登录时间',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `mem_user_message` */

DROP TABLE IF EXISTS `mem_user_message`;

CREATE TABLE `mem_user_message` (
  `MESSAGE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '私信ID',
  `MESSAGE_CONTENT` varchar(200) NOT NULL COMMENT '私信内容',
  `SEND_USER_ID` bigint(20) NOT NULL COMMENT '发送人ID',
  `SEND_USER_NAME` varchar(20) NOT NULL COMMENT '发送人名称',
  `RECEIVE_USER_ID` bigint(20) NOT NULL COMMENT '接收人ID',
  `RECEIVE_USER_NAME` varchar(20) NOT NULL COMMENT '接收人名称',
  `SEND_MESSAGE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '消息发送时间',
  `MESSAGE_IS_READ` tinyint(2) NOT NULL DEFAULT 0 COMMENT '消息是否查看 (0-未查看 1-已查看)',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`MESSAGE_ID`),
  KEY `SEND_USER_ID` (`SEND_USER_ID`),
  KEY `RECEIVE_USER_ID` (`RECEIVE_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `mem_user_ref_role` */

DROP TABLE IF EXISTS `mem_user_ref_role`;

CREATE TABLE `mem_user_ref_role` (
  `REF_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关联ID',
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '权限ID',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) DEFAULT 1 COMMENT '删除标识(1-正常；2-删除)',
  PRIMARY KEY (`REF_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `sys_notice` */

DROP TABLE IF EXISTS `sys_notice`;

CREATE TABLE `sys_notice` (
  `NOTICE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通知ID',
  `RECEIVE_USER_ID` bigint(20) NOT NULL COMMENT '接收通知人ID',
  `RECEIVE_USER_NAME` varchar(20) NOT NULL COMMENT '接收通知人名称',
  `SEND_USER_ID` bigint(20) DEFAULT NULL COMMENT '通知发送人ID(系统通知,默认为空)',
  `SEND_USER_NAME` varchar(20) DEFAULT NULL COMMENT '通知发送人名称',
  `SEND_NOTICE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '通知发送时间',
  `NOTICE_THEME_ID` bigint(20) DEFAULT NULL COMMENT '帖子ID(回复评论类通知,加入帖子ID)',
  `NOTICE_THEME_TITLE` varchar(40) DEFAULT NULL COMMENT '帖子标题',
  `NOTICE_THEME_FLOOR` int(11) DEFAULT NULL COMMENT '帖子楼层 (用于定位用户的回复)',
  `NOTICE_REPLY_ID` bigint(20) DEFAULT NULL COMMENT '回复ID(评论通知,是否在某个回复下)',
  `NOTICE_IS_READ` tinyint(2) DEFAULT NULL COMMENT '通知是否查看 (0-未查看 1-已查看)',
  `NOTICE_TYPE` tinyint(2) DEFAULT NULL COMMENT '通知类型   1-回复,2-评论,3-关注',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`NOTICE_ID`),
  KEY `RECEIVE_USER_ID` (`RECEIVE_USER_ID`),
  KEY `SEND_USER_ID` (`SEND_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `ROLE_ID` bigint(2) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_NAME` varchar(20) NOT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(100) NOT NULL COMMENT '角色说明',
  `ROLE_TYPE` tinyint(2) DEFAULT NULL COMMENT '角色类型',
  `MODIFIER_USER_NAME` varchar(20) DEFAULT NULL COMMENT '修改人账号',
  `MODIFY_TIME` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '修改时间',
  `CREATOR_USER_NAME` varchar(20) DEFAULT NULL COMMENT '创建人账号',
  `CREATE_TIME` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
  `DEL_FLAG` tinyint(2) DEFAULT 1 COMMENT '删除标识 (1-正常；2-删除)',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
