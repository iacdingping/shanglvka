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

import com.slk.hibernate.core.entity.MerchantBrand;
import com.slk.hibernate.core.entity.MerchantMap;
import com.slk.hibernate.core.service.MerchantBrandService;
import com.slk.hibernate.core.service.MerchantMapService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.AreaService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 商旅地图Controller
 * 
 * @author 禹波
 * @version 2014-08-23
 */
@Controller
@RequestMapping(value = "${adminPath}/business/merchantMap")
public class MerchantMapController extends BaseController {

	@Autowired
	private MerchantMapService merchantMapService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private MerchantBrandService merchantBrandService;

	@ModelAttribute
	public MerchantMap get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return merchantMapService.get(id);
		} else {
			return new MerchantMap();
		}
	}

	@RequiresPermissions("business:merchantMap:view")
	@RequestMapping(value = { "list", "" })
	public String list(MerchantMap merchantMap, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()) {
			merchantMap.setCreateBy(user);
		}
		Page<MerchantMap> page = merchantMapService.find(new Page<MerchantMap>(
				request, response), merchantMap);
		model.addAttribute("page", page);
		return "modules/business/merchantMapList";
	}

	@RequiresPermissions("business:merchantMap:view")
	@RequestMapping(value = "form")
	public String form(MerchantMap merchantMap, Model model) {
		model.addAttribute("merchantMap", merchantMap);
		model.addAttribute("brandList", merchantBrandService.list());
		model.addAttribute("typeList", UserUtils.findAllMerchantType());
		return "modules/business/merchantMapForm";
	}

	@RequiresPermissions("business:merchantMap:edit")
	@RequestMapping(value = "save")
	public String save(MerchantMap merchantMap, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, merchantMap)) {
			return form(merchantMap, model);
		}
		merchantMap.setArea(areaService.get(merchantMap.getArea().getId()));
		merchantMapService.save(merchantMap);
		addMessage(redirectAttributes, "保存商旅地图成功");
		return "redirect:" + Global.getAdminPath()
				+ "/business/merchantMap/?repage";
	}

	@RequiresPermissions("business:merchantMap:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		merchantMapService.delete(id);
		addMessage(redirectAttributes, "删除商旅地图成功");
		return "redirect:" + Global.getAdminPath()
				+ "/business/merchantMap/?repage";
	}

}
