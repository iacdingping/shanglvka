package com.slk.core.weichat.webservice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.slk.core.weichat.webservice.request.AbstractParam;
import com.thinkgem.jeesite.common.mapper.JaxbMapper;
import com.thinkgem.jeesite.common.utils.Reflections;
import com.thinkgem.jeesite.common.utils.StringUtils;

public class RequestUtil {

	public static String assembleRequestXml(AbstractParam param) {
		try {
			return JaxbMapper.toXml(convert(param));
		} catch (Exception e) {
			throw new RuntimeException("参数转换异常", e);
		}
	}
	
	/**
	 * param 转成 dataSet 数据集
	 * @param param
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static DataSet convert(AbstractParam param) throws IllegalArgumentException, IllegalAccessException {
		List<Field> fields = Reflections.getAllFieldWithOutIgnoreSign(param);
		
		DataSet ds = new DataSet();
		Row r = new Row();
		ds.setRows(Arrays.asList(r));
		List<Column> columns = new ArrayList<Column>();
		for(Field f : fields) {
			PropertyKey property = f.getAnnotation(PropertyKey.class);
			String key = property != null && StringUtils.isNotBlank(property.value()) ?
					property.value() : f.getName();
			String value = f.get(param).toString();
			Column c = new Column();
			c.setKey(key);
			c.setValue(value);
			columns.add(c);
		}
		r.setColumns(columns);
		
		return ds;
	}
}
