package com.slk.wap.controller.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.manager.mp.WeixinUserManager;
import com.slk.hibernate.core.entity.BusinessCard;
import com.slk.hibernate.core.entity.PurchaseApply;
import com.slk.hibernate.core.service.BusinessCardService;
import com.slk.hibernate.core.service.PurchaseApplyService;
import com.slk.wap.common.ConstantActivity;
import com.slk.wap.common.security.SessionUser;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 我的商旅卡
 */
@Controller
@RequestMapping("/card")
public class MyCardController extends BaseController {
	@Autowired
	private BusinessCardService businessCardService;
	@Autowired
	private WeixinUserManager weixinUserManager;
	@Autowired
	private PurchaseApplyService purchaseApplyService;

	@RequestMapping("/jump")
	public String jump(Model model, HttpServletRequest request) {
		SessionUser user = (SessionUser) request.getSession().getAttribute(
				ConstantActivity.SESSION_USER_KEY);
		WeixinUser weixinUser = user.getWeixinUser();
		if (weixinUser != null && weixinUser.getIsStaff()) {
			model.addAttribute("list", businessCardService.list());
			return "/card/list";
		}
		return "/card/purchase";

	}

	@RequestMapping(value = "purchaseSave")
	public String save(PurchaseApply purchaseApply, Model model,
			ModelMap modelMap, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, purchaseApply)) {
			addMessage(redirectAttributes, "数据不对");
			return "redirect:/card/purchase";
		}
		if (purchaseApply.getId() != null) {
			addMessage(redirectAttributes, "数据不对");
			return "/card/purchase";
		}
		purchaseApply.setIsTreat("0");
		purchaseApply.setCreateTime(new Date());
		purchaseApplyService.save(purchaseApply);
		addMessage(redirectAttributes, "提交申购单成功");
		return "/card/purchase";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", businessCardService.list());
		return "/card/list";
	}

	@RequestMapping("/index")
	public String index(BusinessCard businessCard, Model model) {
		model.addAttribute("businessCard",
				businessCardService.get(businessCard.getId()));
		return "/card/index";
	}

	@RequestMapping("detail")
	public String detail() {
		return "/card/detail";
	}
}
