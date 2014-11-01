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

import com.slk.hibernate.core.entity.MerchantBrand;
import com.slk.hibernate.core.service.MerchantBrandService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 商旅品牌Controller
 * 
 * @author 禹波
 * @version 2014-09-27
 */
@Controller
@RequestMapping(value = "${adminPath}/business/merchantBrand")
public class MerchantBrandController extends BaseController {

	@Autowired
	private MerchantBrandService merchantBrandService;

	@ModelAttribute
	public MerchantBrand get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return merchantBrandService.get(id);
		} else {
			return new MerchantBrand();
		}
	}

	@RequiresPermissions("business:merchantBrand:view")
	@RequestMapping(value = { "list", "" })
	public String list(MerchantBrand merchantBrand, HttpServletRequest request,
			HttpServletResponse response, Model model) {
//		User user = UserUtils.getUser();
		// if (!user.isAdmin()){
		// merchantBrand.setCreateBy(user);
		// }
		Page<MerchantBrand> page = merchantBrandService.find(
				new Page<MerchantBrand>(request, response), merchantBrand);
		model.addAttribute("page", page);
		return "modules/business/merchantBrandList";
	}

	@RequiresPermissions("business:merchantBrand:view")
	@RequestMapping(value = "form")
	public String form(MerchantBrand merchantBrand, Model model) {
		model.addAttribute("merchantBrand", merchantBrand);
		return "modules/business/merchantBrandForm";
	}

	@RequiresPermissions("business:merchantBrand:edit")
	@RequestMapping(value = "save")
	public String save(MerchantBrand merchantBrand, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, merchantBrand)) {
			return form(merchantBrand, model);
		}
		if (merchantBrand.getId() == null) {
		}
		merchantBrandService.save(merchantBrand);
		addMessage(redirectAttributes, "保存商旅品牌成功");
		return "redirect:" + Global.getAdminPath()
				+ "/business/merchantBrand/?repage";
	}

	@RequiresPermissions("business:merchantBrand:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		merchantBrandService.delete(id);
		addMessage(redirectAttributes, "处理商旅品牌成功");
		return "redirect:" + Global.getAdminPath()
				+ "/business/merchantBrand/?repage";
	}

}
