package com.thinkgem.jeesite.common.utils.excel.fieldtype;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;
import com.slk.hibernate.core.entity.MerchantType;
import com.thinkgem.jeesite.common.utils.Collections3;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.sys.service.SystemService;

public class TypeListType {
	private static SystemService systemService = SpringContextHolder
			.getBean(SystemService.class);

	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		List<MerchantType> merchantTypeList = Lists.newArrayList();
		List<MerchantType> allMerchantTypeList = systemService
				.findAllMerchantType();
		for (String s : StringUtils.split(val, ",")) {
			for (MerchantType e : allMerchantTypeList) {
				if (e.getName().equals(s)) {
					merchantTypeList.add(e);
				}
			}
		}
		return merchantTypeList.size() > 0 ? merchantTypeList : null;
	}

	/**
	 * 设置对象值（导出）
	 */
	public static String setValue(Object val) {
		if (val != null) {
			@SuppressWarnings("unchecked")
			List<MerchantType> merchantTypeList = (List<MerchantType>) val;
			return Collections3.extractToString(merchantTypeList, "name", ", ");
		}
		return "";
	}

}
