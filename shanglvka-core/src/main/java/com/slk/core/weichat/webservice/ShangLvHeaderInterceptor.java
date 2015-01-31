package com.slk.core.weichat.webservice;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ShangLvHeaderInterceptor extends AbstractSoapInterceptor {

	private String userName;
	private String password;
	
	public ShangLvHeaderInterceptor() {
        super(Phase.WRITE);
    }
	
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
        List<Header> headers=message.getHeaders(); 
        headers.add(getHeader("Authorization", "username", userName));
        headers.add(getHeader("Authorization", "password", password));
	}
	
	/**
	 * 带子节点的头信息
	 * @param message
	 * @throws Fault
	 */
	public void handleMessage2(SoapMessage message) throws Fault {
	    QName qName=new QName("http://yourdomain.com/");    
	    Document doc = DOMUtils.createDocument();  
	    Element root = doc.createElement("AuthenticationToken");  

	    Element username = doc.createElement("username");  
	    username.setTextContent("yeetrack.com");  

	    Element password = doc.createElement("password");  
	    password.setTextContent("yeetrack.com");  

	    Element args = doc.createElement("someargs");  
	    args.setTextContent("其他参数");  

	    root.appendChild(username);  
	    root.appendChild(password);  
	    root.appendChild(args);  
	    SoapHeader header = new SoapHeader(qName, root);
	        // 获取SOAP消息的全部头  
	    List<Header> headers = message.getHeaders();  
	    
	    headers.add(header);    
	}

	/**
	 * 一般的键值对 soapHeader example :
	 * <p>
	 * List<Header> headers=message.getHeaders();
	 * </p>
	 * <p> 
     * headers.add(getHeader("nameSpace", "username", "youthflies"));
     * headers.add(getHeader("nameSpace", "password", "youthflies"));
     * </p>
	 * @param key
	 * @param value
	 * @return
	 */
    private Header getHeader(String nameSpace, String key, String value) { 
        QName qName=new QName(nameSpace, key); 

        Document document=DOMUtils.createDocument(); 
        Element element=document.createElementNS(nameSpace, key); 
        element.setTextContent(value); 

        SoapHeader header=new SoapHeader(qName, element); 
        return(header); 
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
