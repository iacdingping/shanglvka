package com.slk.core.controller.weichat.webservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slk.core.weichat.webservice.RequestBody;
import com.slk.core.weichat.webservice.ServiceInvalidError;
import com.slk.core.weichat.webservice.ShangLvSoapClient;
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

@Controller
@RequestMapping("${adminPath}/shanglv/soap")
public class ShanvLvSoapController {
	
	@Autowired
	private ShangLvSoapClient shanglvSoapClient;

	@RequestMapping(value="request", method=RequestMethod.GET)
	public String requestForm(ModelMap map) {
		map.put("requestMethod", ajaxRequestMethod());
		return "modules/soap/form";
	}
	
	@RequestMapping(value="ajaxRequest", method=RequestMethod.POST)
	@ResponseBody
	public String ajaxRequest(RequestBody requestBody) {
		System.out.println(requestBody.getMethod() + " : " + requestBody.getJsonData());
		try {
			return shanglvSoapClient.invoke(requestBody.getMethod(), requestBody.getJsonData());
		} catch (ServiceInvalidError e) {
			e.printStackTrace();
			return "service error :" + e.toString();
		}
	}
	
	@RequestMapping(value="ajaxRequestMethod", method=RequestMethod.POST)
	@ResponseBody
	public List<? extends AbstractParam> ajaxRequestMethod() {
		BindParam bind = new BindParam("weChatNo", "cardNo");
		AddCardPointParam addCardPoint = new AddCardPointParam("weChatNo", "cardNo", 10);
		MinusCardPointParam minusCardPoint = new MinusCardPointParam("weChatNo", "cardNo", 10);
		GetCardPointParam getCardPoint = new GetCardPointParam("weChatNo", "cardNo");
		GetCardInfoParam getCardInfo = new GetCardInfoParam("cardNo", "password");
		GetTransactionParam getTransaction = new GetTransactionParam("cardNo", "password", "beginTime", "endTime");
		GetCardNoByIDParam getCardNoByID = new GetCardNoByIDParam("identificationCard");
		RegisterLossCardByIDParam registerById = new RegisterLossCardByIDParam("identificationCard");
		RegisterLossCardParam register = new RegisterLossCardParam("cardNo", "password", "cvv");
		return Arrays.asList(bind, addCardPoint, minusCardPoint, getCardPoint, getCardInfo, getTransaction, getCardNoByID, registerById, register);
	}
}
