package com.slk.core.entity.mp;

/**
 * 类型 1 关注 2 取消关注 3 绑定
 * @author IAC-DINGPING
 *
 */
public enum WeixinUserType {

	START,	//数据库字典是从1开始 所以增加一个start
	JUST_PAY_ATTENTION,
	BOUND,
	CANCEL_ATTENTION;
}
