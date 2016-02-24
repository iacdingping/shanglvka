package com.slk.core.weichat.webservice;

import java.net.URL;
import java.util.Date;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPHeaderElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.slk.core.weichat.webservice.request.AbstractParam;
import com.slk.core.weichat.webservice.request.AddCardPointParam;
import com.slk.core.weichat.webservice.request.BindParam;
import com.slk.core.weichat.webservice.request.GetCardInfoParam;
import com.slk.core.weichat.webservice.request.GetCardNoByIDParam;
import com.slk.core.weichat.webservice.request.GetCardPointParam;
import com.slk.core.weichat.webservice.request.GetTransactionParam;
import com.slk.core.weichat.webservice.request.MinusCardPointParam;
import com.slk.core.weichat.webservice.request.RegisterLossCardByIDParam;
import com.slk.core.weichat.webservice.request.RegisterLossCardParam;
import com.slk.core.weichat.webservice.response.BaseResponse;
import com.slk.core.weichat.webservice.response.GetCardInfoResponse;
import com.slk.core.weichat.webservice.response.GetCardNoByIDResponse;
import com.slk.core.weichat.webservice.response.GetCardPointResponse;
import com.slk.core.weichat.webservice.response.GetTransactionResponse;
import com.slk.core.weichat.webservice.response.ResponseCode;
import com.slk.core.weichat.webservice.response.ResponseResult;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.DateUtils;

@Component
public class ShangLvSoapClientImpAxis {

	@Value("${soap.wechat.url}")
	private String url = "http://localhost:7000/services/Service";
	@Value("${soap.wechat.username}")
	public String userName = "harmony3";
	@Value("${soap.wechat.password}")
	public String password = "harmony3";
	@Value("${soap.wechat.path}")
	private String path = "harmony.services.user.Pay.WX";
	
	private Logger log = LoggerFactory.getLogger(ShangLvSoapClientImpAxis.class);
	
	public String callSerivce(String method, String jsonData) throws Exception {
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(new URL(url));
		call.addHeader(new SOAPHeaderElement("Authorization", "username", userName));
		call.addHeader(new SOAPHeaderElement("Authorization", "password", password));
		call.setOperationName("invoke");
		String res = (String) call.invoke(new Object[] { path, method, jsonData });
		return res;
	}
	
	private JsonMapper jsonMapper = JsonMapper.nonDefaultMapper();
	
	public String invoke(String method, String requestBody) throws ServiceInvalidError {
		try {
			return callSerivce(method, requestBody);
		} catch(Throwable t) {
			log.error("Service invoke {} with request body {} failed.", method, requestBody, t);
			throw new ServiceInvalidError(t);
		}
	}
	
	public String invoke(AbstractParam param) throws ServiceInvalidError {
		return invoke(param.getMethod(), param.getExample());
	}
	
	public BaseResponse baseOperate(AbstractParam param) {
		String result = "";
		try {
			result = invoke(param);
			
			BaseResponse response = jsonMapper.fromJson(result, BaseResponse.class);
			
			return response;
		} catch (ServiceInvalidError e) {
			
		} catch (Throwable t) {
			log.error(String.format("Service invoke [%s], returned [%s] parse error.", jsonMapper.toJson(param), result), t);
		}
		return new BaseResponse(ResponseResult.FAIURE.ordinal(), ResponseCode.INVALID_SERVICE.getCode(), ResponseCode.INVALID_SERVICE.getMessage());
	}
	
	/**
	 * 绑定 
	 * 需要先调用查询余额接口  校验密码是否正确
	 * @param weChatNo
	 * @param cardNo
	 * @param password
	 * @return
	 */
	public BaseResponse bind(String weChatNo, String cardNo, String password) {
		GetCardInfoResponse response = getCardInfo(cardNo, cardNo);
		if(response.isSuccess()) {
			return baseOperate(new BindParam(weChatNo, cardNo));
		} else {
			return new BaseResponse(ResponseResult.FAIURE.ordinal(), response.getErrorCode(), response.getErrorMsg());
		}
	}
	
	/**
	 * 增加积分
	 * @param weChatNo
	 * @param cardNo
	 * @param point
	 * @return
	 */
	public BaseResponse addCardPoint(String weChatNo, String cardNo, Integer point) {
		return baseOperate(new AddCardPointParam(weChatNo, cardNo, point));
	}
	
	/**
	 * 减积分
	 * @param weChatNo
	 * @param cardNo
	 * @param point
	 * @return
	 */
	public BaseResponse minusCardPoint(String weChatNo, String cardNo, Integer point) {
		return baseOperate(new MinusCardPointParam(weChatNo, cardNo, point));
	}
	
	/**
	 * 查积分
	 * @param weChatNo
	 * @param cardNo
	 * @return
	 */
	public GetCardPointResponse getCardPoint(String weChatNo, String cardNo) {
		String result = "";
		try {
			result = invoke(new GetCardPointParam(weChatNo, cardNo));
			
			GetCardPointResponse response = jsonMapper.fromJson(result, GetCardPointResponse.class);
			
			return response;
		} catch (ServiceInvalidError e) {
			
		} catch (Throwable t) {
			log.error(String.format("MinusCardPoint weChatNo [%s], cardNo [%s], result [%s], parse error.", weChatNo, cardNo, result), t);
		}
		return new GetCardPointResponse(ResponseResult.FAIURE.ordinal(), ResponseCode.INVALID_SERVICE.getCode(), ResponseCode.INVALID_SERVICE.getMessage());
	}
	
	/**
	 * 查询余额及有效期
	 * @param cardNo
	 * @param password
	 * @return
	 */
	public GetCardInfoResponse getCardInfo(String cardNo, String password) {
		String result = "";
		try {
			result = invoke(new GetCardInfoParam(cardNo, password));
			
			GetCardInfoResponse response = jsonMapper.fromJson(result, GetCardInfoResponse.class);
			
			return response;
		} catch (ServiceInvalidError e) {
			
		} catch (Throwable t) {
			log.error(String.format("GetCardInfo cardNo [%s], password [%s] result [%s], parse error.", cardNo, password, result), t);
		}
		return new GetCardInfoResponse(ResponseResult.FAIURE.ordinal(), ResponseCode.INVALID_SERVICE.getCode(), ResponseCode.INVALID_SERVICE.getMessage());
	}
	
	/**
	 * 查询交易记录
	 * @param idNo 身份证卡号
	 * @return
	 */
	public GetTransactionResponse getTransactions(String cardNo, String password, Date beginTime, Date endTime) {
		String result = "";
		try {
			result = invoke(new GetTransactionParam(cardNo, password, 
					DateUtils.formatDate(beginTime, "yyyyMMdd hh:mm:ss"), 
					DateUtils.formatDate(endTime, "yyyyMMdd hh:mm:ss")));
			
			GetTransactionResponse response = jsonMapper.fromJson(result, GetTransactionResponse.class);
			
			return response;
		} catch (ServiceInvalidError e) {
			
		} catch (Throwable t) {
			log.error(String.format("getTransactions cardNo [%s], result [%s], parse error.", cardNo, result), t);
		}
		return new GetTransactionResponse(ResponseResult.FAIURE.ordinal(), ResponseCode.INVALID_SERVICE.getCode(), ResponseCode.INVALID_SERVICE.getMessage());
	}
	
	/**
	 * 查询身份证名下的卡号集合
	 * @param idNo 身份证卡号
	 * @return
	 */
	public GetCardNoByIDResponse getCardByID(String idNo) {
		String result = "";
		try {
			result = invoke(new GetCardNoByIDParam(idNo));
			
			GetCardNoByIDResponse response = jsonMapper.fromJson(result, GetCardNoByIDResponse.class);
			
			return response;
		} catch (ServiceInvalidError e) {
			
		} catch (Throwable t) {
			log.error(String.format("GetCardByID idNo [%s], result [%s], parse error.", idNo, result), t);
		}
		return new GetCardNoByIDResponse(ResponseResult.FAIURE.ordinal(), ResponseCode.INVALID_SERVICE.getCode(), ResponseCode.INVALID_SERVICE.getMessage());
	}
	
	/**
	 * 口头挂失身份证下所有卡
	 * @param idNo 身份证号
	 * @return
	 */
	public BaseResponse registerCardByID(String idNo) {
		return baseOperate(new RegisterLossCardByIDParam(idNo));
	}
	
	/**
	 * 口头挂失单卡
	 * @param cardNo
	 * @param password
	 * @param cvv cvv码
	 * @return
	 */
	public BaseResponse registerCard(String cardNo, String password, String cvv) {
		return baseOperate(new RegisterLossCardParam(cardNo, password, cvv));
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}
