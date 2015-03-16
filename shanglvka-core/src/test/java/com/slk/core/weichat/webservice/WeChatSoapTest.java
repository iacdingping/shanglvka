package com.slk.core.weichat.webservice;

import java.net.URL;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPHeaderElement;

public class WeChatSoapTest {

	public static void main(String[] args) {
		validateMobile_SellOrder();
	}
	
	public static String validateMobile_SellOrder() {
		String method = "ValidateMobile_SellOrde";
		String data = ""; // 业务数据组织成XML格式的字符串来交互
		try {
			String res = callSerivce(method, data.toString());
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String callSerivce(String method, String jsonData) {
		Service service = new Service();
//		String WSDL = "http://172.16.19.95:7001/services/Service";
		String WSDL = "http://127.0.0.1:7000/services/Service";
		String UserName = "harmony3";
		String Password = "harmony3";
		String Path = "harmony.services.user.Pay";
		Call call;
		try {
			call = (Call) service.createCall();
			call.setTargetEndpointAddress(new URL(WSDL));
			call.addHeader(new SOAPHeaderElement("Authorization", "username",
					UserName));
			call.addHeader(new SOAPHeaderElement("Authorization", "password",
					Password));
			call.setOperationName("invoke");
			String res = (String) call.invoke(new Object[] { Path, method,
					jsonData });
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
