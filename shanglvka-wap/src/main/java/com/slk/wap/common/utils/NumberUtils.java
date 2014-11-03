package com.slk.wap.common.utils;

public class NumberUtils {

	/**
	 * 判断targetNumber在 beginNumber 和 endNumber 之间
	 * @param beginNumber
	 * @param endNumber
	 * @param targetNumber
	 * @return
	 */
	public static boolean compareNumberBetween(int beginNumber, int endNumber,
			int targetNumber) {
		return targetNumber >= beginNumber && targetNumber < endNumber;
	}
}
