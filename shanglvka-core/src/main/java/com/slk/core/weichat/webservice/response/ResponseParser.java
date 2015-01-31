package com.slk.core.weichat.webservice.response;

import com.thinkgem.jeesite.common.mapper.JaxbMapper;

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

	public static BaseResponse baseParse(String xml) {
		DataSet ds = JaxbMapper.fromXml(xml, DataSet.class);
		BaseResponse result = new BaseResponse(ds.getResult(), "", "");
		return result;
	}
	
	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
							"<DBSET RESULT=\"0\"/>";
		
		BaseResponse br = baseParse(xml);
		
		System.out.println(br.getResult());
	}
}
