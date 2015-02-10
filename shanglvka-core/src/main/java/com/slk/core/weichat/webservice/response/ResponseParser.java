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

import com.slk.core.weichat.webservice.Column;
import com.slk.core.weichat.webservice.DataSet;
import com.slk.core.weichat.webservice.PropertyKey;
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
				PropertyKey p = f.getAnnotation(PropertyKey.class);
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
		
		xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
				"" + 
				"<DBSET RESULT=\"1\">" + 
				" <R>" + 
				"  <C N=\"MerchantName\">杭州知味观</C>" + 
				"  <C N=\"TransactionTime\">20130909 19:12:47</C>" + 
				"  <C N=\"Money\">49.96</C>" + 
				"  <C N=\"CardBalanceBefore\">49.96</C>" + 
				"  <C N=\"CardBalance\">0</C>" + 
				" </R>" + 
				" <R>" + 
				"  <C N=\"MerchantName\">杭州知味观</C>" + 
				"  <C N=\"TransactionTime\">20130906 19:26:42</C>" + 
				"  <C N=\"Money\">146.87</C>" + 
				"  <C N=\"CardBalanceBefore\">196.83</C>" + 
				"  <C N=\"CardBalance\">49.96</C>" + 
				" </R>" + 
				" <R>" + 
				"  <C N=\"MerchantName\">杭州知味观</C>" + 
				"  <C N=\"TransactionTime\">20130906 14:31:18</C>" + 
				"  <C N=\"Money\">59</C>" + 
				"  <C N=\"CardBalanceBefore\">255.83</C>" + 
				"  <C N=\"CardBalance\">196.83</C>" + 
				" </R>" + 
				" <R>" + 
				"  <C N=\"MerchantName\">杭州知味观</C>" + 
				"  <C N=\"TransactionTime\">20130905 13:37:55</C>" + 
				"  <C N=\"Money\">59</C>" + 
				"  <C N=\"CardBalanceBefore\">314.83</C>" + 
				"  <C N=\"CardBalance\">255.83</C>" + 
				" </R>" + 
				" <R>" + 
				"  <C N=\"MerchantName\">杭州知味观</C>" + 
				"  <C N=\"TransactionTime\">20130904 19:59:19</C>" + 
				"  <C N=\"Money\">87.02</C>" + 
				"  <C N=\"CardBalanceBefore\">401.85</C>" + 
				"  <C N=\"CardBalance\">314.83</C>" + 
				" </R>" + 
				" <R>" + 
				"  <C N=\"MerchantName\">杭州知味观</C>" + 
				"  <C N=\"TransactionTime\">20130904 15:15:27</C>" + 
				"  <C N=\"Money\">90.45</C>" + 
				"  <C N=\"CardBalanceBefore\">492.3</C>" + 
				"  <C N=\"CardBalance\">401.85</C>" + 
				" </R>" + 
				" <R>" + 
				"  <C N=\"MerchantName\">杭州知味观</C>" + 
				"  <C N=\"TransactionTime\">20130902 20:51:44</C>" + 
				"  <C N=\"Money\">158.65</C>" + 
				"  <C N=\"CardBalanceBefore\">650.95</C>" + 
				"  <C N=\"CardBalance\">492.3</C>" + 
				" </R>" + 
				" <R>" + 
				"  <C N=\"MerchantName\">杭州知味观</C>" + 
				"  <C N=\"TransactionTime\">20130902 15:00:51</C>" + 
				"  <C N=\"Money\">149.25</C>" + 
				"  <C N=\"CardBalanceBefore\">800.2</C>" + 
				"  <C N=\"CardBalance\">650.95</C>" + 
				" </R>" + 
				" <R>" + 
				"  <C N=\"MerchantName\">杭州知味观</C>" + 
				"  <C N=\"TransactionTime\">20130901 14:27:33</C>" + 
				"  <C N=\"Money\">199.8</C>" + 
				"  <C N=\"CardBalanceBefore\">1000</C>" + 
				"  <C N=\"CardBalance\">800.2</C>" + 
				" </R>" + 
				"</DBSET>";
		
		GetTransactionResponse transactions = parse(GetTransactionResponse.class, xml);
		System.out.println(JaxbMapper.toXml(transactions));
	}
}
