/*
SQLyog Trial v10.51 
MySQL - 5.6.13 : Database - shanglvka
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shanglvka` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shanglvka`;

/*Table structure for table `slk_code` */

DROP TABLE IF EXISTS `slk_code`;

CREATE TABLE `slk_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(3) DEFAULT NULL COMMENT '类型码',
  `code` varchar(50) DEFAULT '0' COMMENT '编码',
  `dictionary_code` varchar(50) DEFAULT NULL COMMENT '字典码',
  `dictionary_value` varchar(50) DEFAULT NULL COMMENT '字典值',
  `reserve_value` varchar(200) DEFAULT NULL COMMENT '备用值',
  `comment` varchar(50) DEFAULT NULL COMMENT '备注',
  `created` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  `last_operate_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slk_code` */

/*Table structure for table `slk_department` */

DROP TABLE IF EXISTS `slk_department`;

CREATE TABLE `slk_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `parent` bigint(20) DEFAULT NULL COMMENT '上级部门',
  `duty` varchar(100) DEFAULT NULL COMMENT '职责',
  `created` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  `last_operate_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slk_department` */

/*Table structure for table `slk_module` */

DROP TABLE IF EXISTS `slk_module`;

CREATE TABLE `slk_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent` varchar(50) DEFAULT NULL COMMENT '父模块',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `expanded` varchar(100) DEFAULT NULL COMMENT '是否展开',
  `type` varchar(100) DEFAULT NULL COMMENT '类型 1菜单 2功能',
  `order` int(11) DEFAULT NULL COMMENT '排序',
  `created` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  `last_operate_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slk_module` */

/*Table structure for table `slk_platform_user` */

DROP TABLE IF EXISTS `slk_platform_user`;

CREATE TABLE `slk_platform_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `platform_coding` varchar(100) DEFAULT NULL COMMENT '平台号码',
  `bind` int(11) DEFAULT '0' COMMENT '绑定状态， 0 取消关注， 1 关注， 2 绑定， 3 解绑定',
  `bind_user` varchar(50) DEFAULT NULL COMMENT '绑定用户',
  `created` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  `last_operate_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slk_platform_user` */

/*Table structure for table `slk_role` */

DROP TABLE IF EXISTS `slk_role`;

CREATE TABLE `slk_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent` varchar(50) DEFAULT NULL COMMENT '父角色',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `created` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  `last_operate_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slk_role` */

/*Table structure for table `slk_role_module` */

DROP TABLE IF EXISTS `slk_role_module`;

CREATE TABLE `slk_role_module` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent` varchar(50) DEFAULT NULL COMMENT '父角色',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `module` bigint(20) DEFAULT NULL COMMENT '模块',
  `role` bigint(20) DEFAULT NULL COMMENT '角色',
  `created` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  `last_operate_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slk_role_module` */

/*Table structure for table `slk_user` */

DROP TABLE IF EXISTS `slk_user`;

CREATE TABLE `slk_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `true_name` varchar(50) DEFAULT NULL COMMENT '真实名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `login_enable` tinyint(4) DEFAULT '1' COMMENT '是否能登陆',
  `ip_enable` varchar(100) DEFAULT NULL COMMENT '允许登陆IP',
  `created` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  `last_operate_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slk_user` */

/*Table structure for table `slk_user_log` */

DROP TABLE IF EXISTS `slk_user_log`;

CREATE TABLE `slk_user_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL COMMENT '用户',
  `ip` varchar(50) DEFAULT NULL COMMENT '用户登陆IP',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `created` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  `last_operate_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slk_user_log` */

/*Table structure for table `slk_user_role` */

DROP TABLE IF EXISTS `slk_user_role`;

CREATE TABLE `slk_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL COMMENT '用户',
  `role` varchar(50) DEFAULT NULL COMMENT '角色',
  `created` date DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT '0',
  `last_operate_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slk_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
