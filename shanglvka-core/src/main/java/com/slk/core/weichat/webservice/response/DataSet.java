package com.slk.core.weichat.webservice.response;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.thinkgem.jeesite.common.mapper.JaxbMapper;
import com.thinkgem.jeesite.common.utils.StringUtils;

@XmlRootElement(name="DBSET")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSet {

	@XmlAttribute(name="RESULT")
	private Integer result;
	
	@XmlElement(name="R")
	private List<Row> rows;
	
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	public List<Row> getRows() {
		return rows;
	}
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	public static void main(String[] args) {
		DataSet dataSet = new DataSet();
		
		Row r1 = new Row();
		Row r2 = new Row();
		dataSet.setRows(Arrays.asList(r1, r2));
		
		Column r1c1 = new Column();
		Column r1c2 = new Column();
		Column r1c3 = new Column();
		Column r1c4 = new Column();
		r1.setColumns(Arrays.asList(r1c1, r1c2, r1c3, r1c4));
		
		r1c1.setKey("r1c1");
		r1c1.setValue("r1c1");
		r1c2.setKey("r1c2");
		r1c2.setValue("r1c2");
		
		r1c3.setKey("r1c3");
		r1c3.setValue("r1c3");
		r1c4.setKey("r1c4");
		r1c4.setValue("r1c4");
		
		Column r2c1 = new Column();
		Column r2c2 = new Column();
		Column r2c3 = new Column();
		r2.setColumns(Arrays.asList(r2c1, r2c2, r2c3));
		r2c1.setKey("r2c1");
		r2c1.setValue("r2c1");
		
		// 2行2列设置成另外的dataSet
//		r2c2.setKey("r2c2");
//		RequestDataSet dataSet2 = new RequestDataSet();
//		r2c2.setDataSet(dataSet2);
//		Row r11 = new Row();
//		dataSet2.setRows(Arrays.asList(r11));
//		Column r11c1 = new Column();
//		Column r11c2 = new Column();
//		r11.setColumns(Arrays.asList(r11c1, r11c2));
//		r11c1.setKey("r11c1");
//		r11c1.setValue("r11c1");
//		r11c2.setKey("r11c2");
//		r11c2.setValue("r11c2");
		
//		System.out.println(JaxbMapper.toXml(dataSet));
		
		
		String xml = "<DBSET>" +
				"  <R>" +
				"    <C N=\"dw\">0250</C>" +
				"    <C N=\"dwmc\">杭州商旅公司</C>" +
				"    <C N=\"gdslb\">" +
				"      <DBSET>" +
				"        <R>" +
				"          <C N=\"gds\">025027</C>" +
				"          <C N=\"gdsmc\">客服中心</C>" +
				"        </R>" +
				"        <R>" +
				"          <C N=\"gds\">025020</C>" +
				"          <C N=\"gdsmc\">黄龙营业厅</C>" +
				"        </R>	" +
				"      </DBSET>" +
				"    </C>" +
				"  </R>" +
				"</DBSET>";
		System.out.println(xml);
		String regular = "(<\\?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"\\?>)*(<DBSET>.*)(<DBSET>.*</DBSET>)(.*</DBSET>)";
		Pattern pattern = Pattern.compile(regular);
		Matcher match = pattern.matcher(xml);
		
//		String regular2 = "<R.*>.*<c.*>(.*)</c></R>";	// row regular
		if(match.matches()) {
			StringBuffer sb = new StringBuffer();
			System.out.println("match.group(0):" + match.group(0));
			System.out.println("match.group(1):" + match.group(1));
			System.out.println("match.group(2):" + match.group(2));
//			System.out.println("match.group(3):" + match.group(3));
			sb.append(StringUtils.isNotBlank(match.group(1)) ?  match.group(1) : "")
			   .append(match.group(2))
			   .append(match.group(3).replaceAll("<", "&lt;").replaceAll(">", "&gt;"))
			   .append(match.group(4));
			   
			System.out.println(sb);
			xml = sb.toString();
		}
		System.out.println(xml.matches(regular));
		
		
		DataSet rds = JaxbMapper.fromXml(xml, DataSet.class);
		System.out.println(JaxbMapper.toXml(rds));
		
//		RequestDataSet ds2  = JaxbMapper.fromXml(xml, RequestDataSet.class);
	}
}
