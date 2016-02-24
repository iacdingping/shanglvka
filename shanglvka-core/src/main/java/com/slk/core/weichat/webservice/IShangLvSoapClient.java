package com.slk.core.weichat.webservice;

import java.util.Date;

import com.slk.core.weichat.webservice.response.BaseResponse;
import com.slk.core.weichat.webservice.response.GetCardInfoResponse;
import com.slk.core.weichat.webservice.response.GetCardNoByIDResponse;
import com.slk.core.weichat.webservice.response.GetCardPointResponse;
import com.slk.core.weichat.webservice.response.GetTransactionResponse;

public interface IShangLvSoapClient {

	/**
	 * 绑定 
	 * 需要先调用查询余额接口  校验密码是否正确
	 * @param weChatNo
	 * @param cardNo
	 * @param password
	 * @return
	 */
	public BaseResponse bind(String weChatNo, String cardNo, String password);
	
	/**
	 * 增加积分
	 * @param weChatNo
	 * @param cardNo
	 * @param point
	 * @return
	 */
	public BaseResponse addCardPoint(String weChatNo, String cardNo, Integer point) ;
	
	/**
	 * 减积分
	 * @param weChatNo
	 * @param cardNo
	 * @param point
	 * @return
	 */
	public BaseResponse minusCardPoint(String weChatNo, String cardNo, Integer point) ;
	
	/**
	 * 查积分
	 * @param weChatNo
	 * @param cardNo
	 * @return
	 */
	public GetCardPointResponse getCardPoint(String weChatNo, String cardNo);
	
	/**
	 * 查询余额及有效期
	 * @param cardNo
	 * @param password
	 * @return
	 */
	public GetCardInfoResponse getCardInfo(String cardNo, String password);
	
	/**
	 * 查询交易记录
	 * @param idNo 身份证卡号
	 * @return
	 */
	public GetTransactionResponse getTransactions(String cardNo, String password, Date beginTime, Date endTime) ;	
	/**
	 * 查询身份证名下的卡号集合
	 * @param idNo 身份证卡号
	 * @return
	 */
	public GetCardNoByIDResponse getCardByID(String idNo);
	
	/**
	 * 口头挂失身份证下所有卡
	 * @param idNo 身份证号
	 * @return
	 */
	public BaseResponse registerCardByID(String idNo) ;
	
	/**
	 * 口头挂失单卡
	 * @param cardNo
	 * @param password
	 * @param cvv cvv码
	 * @return
	 */
	public BaseResponse registerCard(String cardNo, String password, String cvv) ;

	public String invoke(String method, String jsonData) throws ServiceInvalidError;
	
	public String getUserName();
	
	public String getPassword();
}
