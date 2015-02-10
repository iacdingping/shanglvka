package com.slk.core.entity.mp;

public enum CardStatus {
	UNBIND, 
	BIND,
	BIND_FAILED;
	
	private String pageShowInfo;
	private boolean needRebind;
}
