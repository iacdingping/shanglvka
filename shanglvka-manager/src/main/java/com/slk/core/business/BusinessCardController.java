/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.core.business;
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

import com.slk.hibernate.core.entity.BusinessCard;
import com.slk.hibernate.core.service.BusinessCardService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 商旅地图Controller
 * @author 禹波
 * @version 2014-09-27
 */
@Controller
@RequestMapping(value = "${adminPath}/business/businessCard")
public class BusinessCardController extends BaseController {

	@Autowired
	private BusinessCardService businessCardService;
	
	@ModelAttribute
	public BusinessCard get(@RequestParam(required=false) Long id) {
		if (id != null){
			return businessCardService.get(id);
		}else{
			return new BusinessCard();
		}
	}
	
	@RequiresPermissions("business:businessCard:view")
	@RequestMapping(value = {"list", ""})
	public String list(BusinessCard businessCard, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			businessCard.setCreateBy(user);
//		}
        Page<BusinessCard> page = businessCardService.find(new Page<BusinessCard>(request, response), businessCard); 
        model.addAttribute("page", page);
		return "modules/business/businessCardList";
	}

	@RequiresPermissions("business:businessCard:view")
	@RequestMapping(value = "form")
	public String form(BusinessCard businessCard, Model model) {
		model.addAttribute("businessCard", businessCard);
		return "modules/business/businessCardForm";
	}

	@RequiresPermissions("business:businessCard:edit")
	@RequestMapping(value = "save")
	public String save(BusinessCard businessCard, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, businessCard)){
			return form(businessCard, model);
		}
		businessCardService.save(businessCard);
		addMessage(redirectAttributes, "保存商旅地图成功");
		return "redirect:"+Global.getAdminPath()+"/business/businessCard/?repage";
	}
	
	@RequiresPermissions("business:businessCard:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		businessCardService.delete(id);
		addMessage(redirectAttributes, "删除商旅地图成功");
		return "redirect:"+Global.getAdminPath()+"/business/businessCard/?repage";
	}

}
