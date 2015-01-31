package com.slk.core.weichat.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://services.harmony")
public interface ShangLvSoapService {

	@WebMethod(operationName="invoke")
	public @WebResult(name="out") String invoke(
			@WebParam(name="in0") String path, 
			@WebParam(name="in1") String method, 
			@WebParam(name="in2")String requestBody);
}
