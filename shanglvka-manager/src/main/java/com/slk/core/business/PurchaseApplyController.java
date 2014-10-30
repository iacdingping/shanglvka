/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.core.business;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.slk.hibernate.core.entity.PurchaseApply;
import com.slk.hibernate.core.service.PurchaseApplyService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 申购单Controller
 * 
 * @author 禹波
 * @version 2014-09-27
 */
@Controller
@RequestMapping(value = "${adminPath}/business/purchaseApply")
public class PurchaseApplyController extends BaseController {

	@Autowired
	private PurchaseApplyService purchaseApplyService;

	@ModelAttribute
	public PurchaseApply get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return purchaseApplyService.get(id);
		} else {
			return new PurchaseApply();
		}
	}

	@RequiresPermissions("business:purchaseApply:view")
	@RequestMapping(value = { "list", "" })
	public String list(PurchaseApply purchaseApply, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		// if (!user.isAdmin()){
		// purchaseApply.setCreateBy(user);
		// }
		Page<PurchaseApply> page = purchaseApplyService.find(
				new Page<PurchaseApply>(request, response), purchaseApply);
		model.addAttribute("page", page);
		return "modules/business/purchaseApplyList";
	}

	@RequiresPermissions("business:purchaseApply:view")
	@RequestMapping(value = "form")
	public String form(PurchaseApply purchaseApply, Model model) {
		model.addAttribute("purchaseApply", purchaseApply);
		return "modules/business/purchaseApplyForm";
	}

	@RequiresPermissions("business:purchaseApply:edit")
	@RequestMapping(value = "save")
	public String save(PurchaseApply purchaseApply, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, purchaseApply)) {
			return form(purchaseApply, model);
		}
		if (purchaseApply.getId() == null) {
			purchaseApply.setIsTreat("0");
			purchaseApply.setCreateTime(new Date());
		}
		purchaseApplyService.save(purchaseApply);
		addMessage(redirectAttributes, "保存申购单成功");
		return "redirect:" + Global.getAdminPath()
				+ "/business/purchaseApply/?repage";
	}

	@RequiresPermissions("business:purchaseApply:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		purchaseApplyService.treat(id);
		addMessage(redirectAttributes, "处理申购单成功");
		return "redirect:" + Global.getAdminPath()
				+ "/business/purchaseApply/?repage";
	}

}
