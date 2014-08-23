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

/*Table structure for table `sys_code` */

DROP TABLE IF EXISTS `sys_code`;

CREATE TABLE `sys_code` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(3) DEFAULT NULL COMMENT '类型码',
  `code` VARCHAR(50) DEFAULT '0' COMMENT '编码',
  `dictionary_code` VARCHAR(50) DEFAULT NULL COMMENT '字典码',
  `dictionary_value` VARCHAR(50) DEFAULT NULL COMMENT '字典值',
  `reserve_value` VARCHAR(200) DEFAULT NULL COMMENT '备用值',
  `comment` VARCHAR(50) DEFAULT NULL COMMENT '备注',
  `created` DATE DEFAULT NULL,
  `deleted` TINYINT(4) DEFAULT '0',
  `last_operate_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_code` */

/*Table structure for table `sys_department` */

DROP TABLE IF EXISTS `sys_department`;

CREATE TABLE `sys_department` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) DEFAULT NULL COMMENT '名称',
  `parent` BIGINT(20) DEFAULT NULL COMMENT '上级部门',
  `duty` VARCHAR(100) DEFAULT NULL COMMENT '职责',
  `created` DATE DEFAULT NULL,
  `deleted` TINYINT(4) DEFAULT '0',
  `last_operate_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_department` */

/*Table structure for table `sys_module` */

DROP TABLE IF EXISTS `sys_module`;

CREATE TABLE `sys_module` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `parent` VARCHAR(50) DEFAULT NULL COMMENT '父模块',
  `name` VARCHAR(50) DEFAULT NULL COMMENT '名称',
  `icon` VARCHAR(100) DEFAULT NULL COMMENT '图标',
  `expanded` VARCHAR(100) DEFAULT NULL COMMENT '是否展开',
  `type` INT(3) DEFAULT NULL COMMENT '类型 1菜单 2功能',
  `permission` VARCHAR(255) COMMENT '权限query edit delete',
  `order` INT(11) DEFAULT NULL COMMENT '排序',
  `created` DATE DEFAULT NULL,
  `deleted` TINYINT(4) DEFAULT '0',
  `last_operate_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_module` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) DEFAULT NULL COMMENT '名称',
  `icon` VARCHAR(100) DEFAULT NULL COMMENT '图标',
  `created` DATE DEFAULT NULL,
  `deleted` TINYINT(4) DEFAULT '0',
  `last_operate_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_module` */

DROP TABLE IF EXISTS `sys_role_module`;

CREATE TABLE `sys_role_module` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) DEFAULT NULL COMMENT '名称',
  `icon` VARCHAR(100) DEFAULT NULL COMMENT '图标',
  `module` BIGINT(20) DEFAULT NULL COMMENT '模块',
  `role` BIGINT(20) DEFAULT NULL COMMENT '角色',
  `permission` VARCHAR(255) COMMENT '权限',
  `created` DATE DEFAULT NULL,
  `deleted` TINYINT(4) DEFAULT '0',
  `last_operate_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_module` */

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) DEFAULT NULL COMMENT '用户名',
  `login_name`	VARCHAR(255) NOT NULL UNIQUE,
  `password` VARCHAR(50) DEFAULT NULL COMMENT '密码',
  `salt` VARCHAR(64),
  `email` VARCHAR(128),
  `login_enable` TINYINT(1) DEFAULT '1' COMMENT '是否能登陆',
  `ip_enable` VARCHAR(255) DEFAULT NULL COMMENT '允许登陆IP',
  `created` DATE DEFAULT NULL,
  `deleted` TINYINT(4) DEFAULT '0',
  `last_operate_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

/*Table structure for table `sys_user_log` */

DROP TABLE IF EXISTS `sys_user_log`;

CREATE TABLE `sys_user_log` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(50) DEFAULT NULL COMMENT '用户',
  `ip` VARCHAR(50) DEFAULT NULL COMMENT '用户登陆IP',
  `remark` VARCHAR(200) DEFAULT NULL COMMENT '备注',
  `created` DATE DEFAULT NULL,
  `deleted` TINYINT(4) DEFAULT '0',
  `last_operate_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_log` */

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user` BIGINT(20) DEFAULT NULL COMMENT '用户',
  `role` BIGINT(20) DEFAULT NULL COMMENT '角色',
  `created` DATE DEFAULT NULL,
  `deleted` TINYINT(4) DEFAULT '0',
  `last_operate_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

/*Table structure for table `sys_platform_user` */

DROP TABLE IF EXISTS `slk_platform_user`;

CREATE TABLE `slk_platform_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `platform_coding` VARCHAR(100) DEFAULT NULL COMMENT '平台号码',
  `bind` INT(11) DEFAULT '0' COMMENT '绑定状态， 0 取消关注， 1 关注， 2 绑定， 3 解绑定',
  `bind_user` VARCHAR(50) DEFAULT NULL COMMENT '绑定用户',
  `created` DATE DEFAULT NULL,
  `deleted` TINYINT(4) DEFAULT '0',
  `last_operate_time` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_platform_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
