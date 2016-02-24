package com.slk.core.weichat.webservice;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.slk.core.weichat.webservice.response.BaseResponse;
import com.slk.core.weichat.webservice.response.GetCardInfoResponse;
import com.slk.core.weichat.webservice.response.GetCardNoByIDResponse;
import com.slk.core.weichat.webservice.response.GetCardPointResponse;
import com.slk.core.weichat.webservice.response.GetTransactionResponse;
import com.slk.core.weichat.webservice.response.ResponseParser;

@Component
public class ShangLvSoapClientTest {

	/**
	 * 绑定 
	 * 需要先调用查询余额接口  校验密码是否正确
	 * @param weChatNo
	 * @param cardNo
	 * @param password
	 * @return
	 */
	public BaseResponse bind(String weChatNo, String cardNo, String password) {
		try {
			System.out.println(cardNo + "---" + cardNo.hashCode() % 3);
			if(cardNo.hashCode() % 3 == 0) {
				return  ResponseParser.parse(BaseResponse.class, 
								"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
								"<DBSET RESULT=\"0\">" +
								" <R>" +
								"  <C N=\"ERRORCODE\">1</C>" +
								"  <C N=\"ERRORMSG\">卡号、微信号不一致</C>" +
								" </R>" +
								"</DBSET>");
			} else {
				return  ResponseParser.parse(BaseResponse.class, 
						"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
						"<DBSET RESULT=\"1\">" +
						" <R>" +
						"  <C N=\"ERRORCODE\"></C>" +
						"  <C N=\"ERRORMSG\">绑定成功</C>" +
						" </R>" +
						"</DBSET>");
			}
		} catch(Exception e) {
			return new BaseResponse(0, "10001", "服务错误" + e.toString());
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
		try {
			if(cardNo.hashCode() % 3 == 0) {
				return  ResponseParser.parse(BaseResponse.class, 
								"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
								"<DBSET RESULT=\"0\">" +
								" <R>" +
								"  <C N=\"ERRORCODE\">1</C>" +
								"  <C N=\"ERRORMSG\">卡号、微信号不一致</C>" +
								" </R>" +
								"</DBSET>");
			} else {
				return  ResponseParser.parse(BaseResponse.class, 
						"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
						"<DBSET RESULT=\"1\">" +
						" <R>" +
						"  <C N=\"ERRORCODE\"></C>" +
						"  <C N=\"ERRORMSG\">success</C>" +
						" </R>" +
						"</DBSET>");
			}
		} catch(Exception e) {
			return new BaseResponse(0, "10001", "服务错误" + e.toString());
		}
	}
	
	/**
	 * 减积分
	 * @param weChatNo
	 * @param cardNo
	 * @param point
	 * @return
	 */
	public BaseResponse minusCardPoint(String weChatNo, String cardNo, Integer point) {
		try {
			if(cardNo.hashCode() % 3 == 0) {
				return  ResponseParser.parse(BaseResponse.class, 
								"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
								"<DBSET RESULT=\"0\">" +
								" <R>" +
								"  <C N=\"ERRORCODE\">1</C>" +
								"  <C N=\"ERRORMSG\">卡号、微信号不一致</C>" +
								" </R>" +
								"</DBSET>");
			} else {
				return  ResponseParser.parse(BaseResponse.class, 
						"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
						"<DBSET RESULT=\"1\">" +
						" <R>" +
						"  <C N=\"ERRORCODE\"></C>" +
						"  <C N=\"ERRORMSG\">operation成功</C>" +
						" </R>" +
						"</DBSET>");
			}
		} catch(Exception e) {
			return new BaseResponse(0, "10001", "服务错误" + e.toString());
		}
	}
	
	/**
	 * 查积分
	 * @param weChatNo
	 * @param cardNo
	 * @return
	 */
	public GetCardPointResponse getCardPoint(String weChatNo, String cardNo) {
		try {
			return  ResponseParser.parse(GetCardPointResponse.class, 
							"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
							"<DBSET RESULT=\"1\">" +
							" <R>" +
							"  <C N=\"Point\">30</C>" +
							" </R>" +
							"</DBSET>");
		} catch(Exception e) {
			return new GetCardPointResponse(0, "10001", "服务错误" + e.toString());
		}
	}
	
	/**
	 * 查询余额及有效期
	 * @param cardNo
	 * @param password
	 * @return
	 */
	public GetCardInfoResponse getCardInfo(String cardNo, String password) {
		try {
			return  ResponseParser.parse(GetCardInfoResponse.class, 
							"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
							"<DBSET RESULT=\"1\">" +
							" <R>" +
							"  <C N=\"Money\">30</C>" +
							"  <C N=\"Deadline\">20250101</C>" +
							" </R>" +
							"</DBSET>");
		} catch(Exception e) {
			return new GetCardInfoResponse(0, "10001", "服务错误" + e.toString());
		}
	}
	
	/**
	 * 查询交易记录
	 * @param idNo 身份证卡号
	 * @return
	 */
	public GetTransactionResponse getTransactions(String cardNo, String password, Date beginTime, Date endTime) {
		try {
			return  ResponseParser.parse(GetTransactionResponse.class, 
							"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + 
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
							"</DBSET>");
		} catch(Exception e) {
			return new GetTransactionResponse(0, "10001", "服务错误" + e.toString());
		}
	}
	
	/**
	 * 查询身份证名下的卡号集合
	 * @param idNo 身份证卡号
	 * @return
	 */
	public GetCardNoByIDResponse getCardByID(String idNo) {
		try {
			return  ResponseParser.parse(GetCardNoByIDResponse.class, 
							"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
							"<DBSET RESULT=\"1\">" +
							" <R>" +
							"  <C N=\"CardNO\">1100880000000027518</C>" +
							" </R>" +
							" <R>" +
							"  <C N=\"CardNO\">1100880000000044364</C>" +
							" </R>" +
							"</DBSET>");
		} catch(Exception e) {
			return new GetCardNoByIDResponse(0, "10001", "服务错误" + e.toString());
		}
	}

	public BaseResponse registerCardByID(String idNo) {
		return null;
	}

	public BaseResponse registerCard(String cardNo, String password, String cvv) {
		return null;
	}

	public String invoke(String method, String jsonData) {
		return "It's test";
	}

	public String getUserName() {
		return "username";
	}

	public String getPassword() {
		return "password";
	}
	
}
