#drop table slv_platform_user
DROP TABLE IF EXISTS slv_platform_user;
CREATE TABLE slv_platform_user
(
`id` 							BIGINT	PRIMARY KEY AUTO_INCREMENT,
`platform_coding`		VARCHAR(100)	COMMENT '平台号码',
`bind`						INT DEFAULT 0 COMMENT '绑定状态， 0 取消关注， 1 关注， 2 绑定， 3 解绑定',
`bind_user`				VARCHAR(50) COMMENT '绑定用户',
`created`					DATE,
`deleted`					TINYINT DEFAULT 0,
`last_operate_time` 	DATE
);

