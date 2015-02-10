package com.slk.core.weichat.webservice.response;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.slk.core.weichat.webservice.Column;
import com.slk.core.weichat.webservice.DataSet;
import com.slk.core.weichat.webservice.Row;
import com.thinkgem.jeesite.common.mapper.JaxbMapper;
import com.thinkgem.jeesite.common.utils.Reflections;

/**
 * 返回字符串 解析
 * 
 * convert 
 * <code>
 * <?xml version="1.0" encoding="UTF-8" ?> 
 * <DBSET> 
 * 		<R> 
 * 			<C N="dw">0100</C> 
 * 			<C N="dwmc">杭州商旅公司</C> 
 * 		</R> 
 *	</DBSET>
 *</code>
 * to BaseResposne or sub class.
 * 
 * @author iacdp
 *
 */
public class ResponseParser {
	private static BeanUtilsBean bub = BeanUtilsBean.getInstance();
	private static ConvertUtilsBean cub = bub.getConvertUtils();

	/**
	 * column 转成map
	 * @param columns
	 * @return
	 */
	public static Map<String, String> convertColumn2Map(List<Column> columns) {
		Map<String, String> result = new HashMap<String, String>();
		for(Column c :  columns) {
			result.put(c.getKey(), c.getValue());
		}
		
		return result;
	}
	
	/**
	 * map 转bean属性
	 * @param type
	 * @param properties
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static <T> T populate(Class<T> type, Map<String, ? extends Object> properties) 
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		System.out.println(long.class.isPrimitive());
		
		if(type.isPrimitive() || type == String.class || properties.size() == 1) {
			return (T)cub.convert(properties.entrySet().iterator().next().getValue(), type);
		}
		T t = type.newInstance();
		populate(t, properties);
		return t;
	}
	
	/**
	 * BeanUtils 默认根据field name 设置属性  我们需要用jsonProperty 获取属性别名
	 * @param bean
	 * @param properties
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void populate(Object bean, Map<String, ? extends Object> properties) 
			throws IllegalAccessException, InvocationTargetException {
		for (Field f : Reflections.getAllFieldWithOutIgnoreSign(bean)) {
			String name = f.getName();
			Object v = properties.get(name);
			if(v == null) {
				JsonProperty p = f.getAnnotation(JsonProperty.class);
				if(p!= null && StringUtils.isNotBlank(p.value())) {
					v = properties.get(p.value());
				}
			}
			
			if(v != null) {
				bub.setProperty(bean, name, v);
			}
		}
	}
	
	public static BaseResponse baseParse(String xml) throws IllegalAccessException, InvocationTargetException {
		DataSet ds = JaxbMapper.fromXml(xml, DataSet.class);
		BaseResponse br = new BaseResponse();
		if(ds.getRows() != null && !ds.getRows().isEmpty()) {
			List<Column> columns = ds.getRows().get(0).getColumns();
			populate(br, convertColumn2Map(columns));
		}
		br.setResult(ds.getResult());
		return br;
	}
	
	public static <T extends BaseResponse> T parse(Class<T> type, String xml)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException  {
		DataSet ds = JaxbMapper.fromXml(xml, DataSet.class);
		T t = type.newInstance();
		if(ds.getRows() != null && !ds.getRows().isEmpty()) {
			// 多行row 如何处理
			if(ds.getRows().size() == 1) {
				List<Column> columns = ds.getRows().get(0).getColumns();
				populate(t, convertColumn2Map(columns));
			} else {
				// 1、需要找到row 所对应的属性  假定 多行row时 只允许同种类型
				// \\\\\很明显对ESB的接口 多返回的head_object body_object 就不适用\\\\\\
				List<Field> fields = Reflections.getSelfFieldWithOutIgnoreSign(t);
				Field currentField = null;
				Class<?> propertyClass = null;
				for(Field f : fields) {
					if(List.class.isAssignableFrom(f.getType())) {
						//集合属性  把 row对应的 列转换成collection中的类
						ParameterizedType pt = (ParameterizedType)f.getGenericType();
						System.out.println(pt.getActualTypeArguments().length);  
						System.out.println(pt.getActualTypeArguments()[0]);
						propertyClass = (Class)pt.getActualTypeArguments()[0];
						currentField = f;
						break;
					}
				}
				
				if(propertyClass == null) {
					throw new RuntimeException(String.format("Class %s must have one Collection property. Deserilized xml has multi Rows. xml:%s", type.getName(), xml));
				}
				System.out.println("currentField.getType().getName():" + currentField.getType().getName());
				List c = new ArrayList();
				for(Row r : ds.getRows()) {
					List<Column> columns = r.getColumns();
					c.add(populate(propertyClass, convertColumn2Map(columns)));
				}
//				Reflections.setFieldValue(t, currentField.getName(), c);
				currentField.set(t, c);
			}
		}
		t.setResult(ds.getResult());
		return t;
	}
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
		/*String xml = 
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DBSET RESULT=\"0\">" +
				" <R>" +
				"  <C N=\"ERRORCODE\">1</C>" +
				"  <C N=\"ERRORMSG\">卡号、微信号不一致</C>" +
				" </R>" +
				"</DBSET>";
		
		BaseResponse br = baseParse(xml);
		
		BaseResponse br2 = parse(BaseResponse.class, xml);
		
		System.out.println(JaxbMapper.toXml(br));
		System.out.println(JaxbMapper.toXml(br2));
		
		
		//
		xml = 
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DBSET RESULT=\"1\">" +
				" <R>" +
				"  <C N=\"Point\">30</C>" +
				" </R>" +
				"</DBSET>";
		
		GetCardPointResponse gcpr = parse(GetCardPointResponse.class, xml);
		System.out.println(JaxbMapper.toXml(gcpr));*/
		
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<DBSET RESULT=\"1\">" +
				" <R>" +
				"  <C N=\"CardNO\">1100880000000027518</C>" +
				" </R>" +
				" <R>" +
				"  <C N=\"CardNO\">1100880000000044364</C>" +
				" </R>" +
				"</DBSET>";
		GetCardNoByIDResponse gcnbr = parse(GetCardNoByIDResponse.class, xml);
		System.out.println(JaxbMapper.toXml(gcnbr));
	}
}
