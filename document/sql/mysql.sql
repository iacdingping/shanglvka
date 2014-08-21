DROP TABLE IF EXISTS `mp_platform_user`;
DROP TABLE IF EXISTS `mp_platform_keyword`;
DROP TABLE IF EXISTS `mp_platform_button_menu`;

CREATE TABLE `mp_platform_user`
(
`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
`identification` VARCHAR(255) COMMENT '身份标识',
`platform_code`  VARCHAR(50) COMMENT '平台号码',
`type` INT(4) COMMENT '类型 1 关注 2 取消关注 3 绑定',
`create_date` DATE,
`update_date` DATE,
`del_flag` INT(1) DEFAULT 0
)
COMMENT '微信用户';



CREATE TABLE `mp_platform_keyword` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `key` VARCHAR(200) COMMENT '关键字',
  `response_type` VARCHAR(25) DEFAULT NULL COMMENT '回复类型',
  `content` TEXT COMMENT '内容',
  `title` VARCHAR(200) DEFAULT NULL COMMENT '标题',
  `picture` VARCHAR(200) DEFAULT NULL COMMENT '图片地址',
  `url` VARCHAR(200) DEFAULT NULL COMMENT '链接',
  `priority` INT(4) DEFAULT '1' COMMENT '匹配优先级 越大优先级越高',
  `need_bind` INT(1) DEFAULT NULL COMMENT '是否需要绑定',
  `unbind_content` TEXT COMMENT '未绑定内容',
  `create_date` DATE DEFAULT NULL,
  `update_date` DATE DEFAULT NULL,
  `del_flag` INT(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) COMMENT='平台关键字自动回复';


CREATE TABLE mp_platform_button_menu (
`id` 		BIGINT(20) 	PRIMARY KEY AUTO_INCREMENT,
`name` 		VARCHAR(10) 	COMMENT '菜单名称',
`key` 		VARCHAR(20) 	COMMENT '响应键标识(mp_platform_keyword关键字对应)',
`parent` 	BIGINT(20) 	COMMENT '父ID',
`type` 		VARCHAR(20) 	COMMENT '类型 BUTTON,LINK',
`create_date` 	DATE,
`update_date`	DATE,
`del_flag` 	TINYINT(1) DEFAULT 0
)
COMMENT '微信平台自定义菜单';