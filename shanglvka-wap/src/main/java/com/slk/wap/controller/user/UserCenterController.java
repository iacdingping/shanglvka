package com.slk.wap.controller.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slk.core.entity.mp.UserBindCard;
import com.slk.core.manager.mp.UserBindCardManager;
import com.slk.core.weichat.webservice.IShangLvSoapClient;
import com.slk.core.weichat.webservice.response.BaseResponse;
import com.slk.core.weichat.webservice.response.GetCardInfoResponse;
import com.slk.core.weichat.webservice.response.GetCardPointResponse;
import com.slk.core.weichat.webservice.response.GetTransactionResponse;
import com.slk.wap.common.constant.ConstantActivity;
import com.slk.wap.common.security.NeedLogin;
import com.slk.wap.common.security.SessionUser;
import com.thinkgem.jeesite.common.web.BaseController;


/**
 * 个人中心
 * 未登录的跳转至首页
 */
@Controller
@RequestMapping("uc/")
@NeedLogin(noLoginUrl="/")
public class UserCenterController extends BaseController {

	@Autowired
	private IShangLvSoapClient shanglvSoapClient;
	@Autowired
	private UserBindCardManager userBindCardManager;
	
	//private static final String URI = "uc/";
	private static final String VIEW_PATH = "user/";
	
	/**首页*/
	@RequestMapping("index")
	public String index(){
		return VIEW_PATH+"index";
	}
	
	@RequestMapping(value="bind", method=RequestMethod.GET)
	public String bindForm(@RequestParam(value="cardNo", required=false)String cardNo, 
			ModelMap map) {
		map.put("cardNo", cardNo);
		return VIEW_PATH + "bindForm";
	}
	
	@RequestMapping(value="bind", method=RequestMethod.POST)
	public String bind(@RequestParam(value="cardNo")String cardNo, 
			@RequestParam(value="password")String password, 
			ModelMap map, HttpServletRequest request) {
		map.put("cardNo", cardNo);
		HttpSession session = request.getSession();
		SessionUser user = (SessionUser)session.getAttribute(ConstantActivity.SESSION_USER_KEY);
		BaseResponse br = shanglvSoapClient.bind(user.getWeixinUser().getPlatformCode(), cardNo, password);
		if(br.isSuccess()) {
			UserBindCard userCard = new UserBindCard();
			userCard.setCardNo(cardNo);
			userCard.setPassword(password);
			userCard.setCreateDate(new Date());
			userCard.setPlatformCode(user.getWeixinUser().getPlatformCode());
			userBindCardManager.save(userCard);
			return "redirect:/uc/card/list";
		} else {
			map.put("message", br.getErrorMsg());
			return VIEW_PATH + "bindForm";
		}
	}
	
	/**
	 * 列出所有绑定的卡片
	 * 没有绑定的卡片呢    给用户展现绑定地址 或者是购买地址
	 * 有卡片的时候 需要输入密码 查询余额  ajax 请求 
	 * 查询消费记录 另外弹出页面
	 */
	@RequestMapping(value="card/list", method=RequestMethod.GET)
	public String cardList(HttpServletRequest request, ModelMap map){
		HttpSession session = request.getSession();
		SessionUser user = (SessionUser)session.getAttribute(ConstantActivity.SESSION_USER_KEY);
		
		String openId = user.getWeixinUser().getPlatformCode();
		List<UserBindCard> cards = userBindCardManager.listByPlatformCode(openId);
		//本地绑定记录查询 如过没有则提示用户去购买
		// 存在绑定的卡 用户输入密码 然后查询
		map.put("cards", cards);
		return VIEW_PATH+"cardList";
	}
	
	/**
	 * 余额查询
	 * 注意 参数中如果密码出现特殊字符  可能会被baseController 给屏蔽掉  
	 */
	@RequestMapping(value="yecx", method=RequestMethod.POST)
	@ResponseBody
	public GetCardInfoResponse yecx(HttpServletRequest request, 
			@RequestParam("password") String password,
			@RequestParam("cardNo") String cardNo){
		//本地绑定记录查询 如过没有则提示用户去购买
		// 存在绑定的卡 用户输入密码 然后查询
		GetCardInfoResponse cardInfo = shanglvSoapClient.getCardInfo(cardNo, password);
		return cardInfo;
	}
	
	/**交易记录*/
	@RequestMapping(value="jyjl", method=RequestMethod.GET)
	public String jyjl(@RequestParam(value="password", required=false) String password,
			@RequestParam(value="cardNo", required=false) String cardNo,
			ModelMap map){
		map.put("cardNo", cardNo);
		map.put("password", password);
		return VIEW_PATH+"jyjl";
	}
	
	/**
	 * 交易记录查询
	 * 按月查询   下滑一次 增加10条显示页面
	 */
	@RequestMapping(value="jyjl", method=RequestMethod.POST)
	@ResponseBody
	public GetTransactionResponse jyjl(HttpServletRequest request, 
			@RequestParam("password") String password,
			@RequestParam("cardNo") String cardNo,
			@RequestParam("beginTime") Date beginTime,
			@RequestParam(value="endTime", required=false) Date endTime){
		//本地绑定记录查询 如过没有则提示用户去购买
		// 存在绑定的卡 用户输入密码 然后查询
		endTime = endTime == null ? new Date() : endTime;
		GetTransactionResponse transactions = shanglvSoapClient.getTransactions(cardNo, password, beginTime, endTime);
		return transactions;
	}
	
	/**积分查询 */
	@RequestMapping(value="jfcx", method=RequestMethod.GET)
	public String jfcxForm(){
		return VIEW_PATH+"jfcx";
	}
	
	/**积分查询 */
	@RequestMapping(value="jfcx", method=RequestMethod.POST)
	@ResponseBody
	public GetCardPointResponse jfcx(HttpServletRequest request, 
			@RequestParam("cardNo") String cardNo){
		HttpSession session = request.getSession();
		SessionUser user = (SessionUser)session.getAttribute(ConstantActivity.SESSION_USER_KEY);
		
		String openId = user.getWeixinUser().getPlatformCode();
		GetCardPointResponse cardPoint = shanglvSoapClient.getCardPoint(openId, cardNo);
		return cardPoint;
	}
	
	/**
	 * 积分兑换 在绑定用户card的时候  有校验过密码·
	 * 这里可以不用再次校验
	 * 或者前面绑定的时候保存用户密码 然后与本地库校验  不一致的再校验接口服务数据
	 * @return
	 */
	@RequestMapping("jfdh")
	public String jfdh(){
		return VIEW_PATH+"jfdh";
	}
}
