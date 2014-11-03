/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.core.business;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.slk.hibernate.core.entity.MerchantType;
import com.slk.hibernate.core.service.MerchantTypeService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.entity.Menu;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 商旅类别Controller
 * 
 * @author 禹波
 * @version 2014-09-27
 */
@Controller
@RequestMapping(value = "${adminPath}/business/merchantType")
public class MerchantTypeController extends BaseController {

	@Autowired
	private MerchantTypeService merchantTypeService;

	@ModelAttribute
	public MerchantType get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return merchantTypeService.get(id);
		} else {
			return new MerchantType();
		}
	}

	@RequiresPermissions("business:merchantType:view")
	@RequestMapping(value = { "list", "" })
	public String list(MerchantType merchantType, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		// if (!user.isAdmin()){
		// merchantType.setCreateBy(user);
		// }
		if (merchantType.getId() == null) {
			merchantType.setId(1L);
		}
		List<MerchantType> list = Lists.newArrayList();
		List<MerchantType> sourcelist = merchantTypeService.findAll();
		MerchantType.sortList(list, sourcelist, merchantType.getId());
		model.addAttribute("list", list);
		return "modules/business/merchantTypeList";
	}

	@RequiresPermissions("business:merchantType:view")
	@RequestMapping(value = "form")
	public String form(MerchantType merchantType, Model model) {
		if (merchantType.getParent() == null
				|| merchantType.getParent().getId() == null) {
			merchantType.setParent(new MerchantType(1L));
		}
		merchantType.setParent(merchantTypeService.get(merchantType.getParent()
				.getId()));
		model.addAttribute("merchantType", merchantType);
		return "modules/business/merchantTypeForm";
	}

	@RequiresPermissions("business:merchantType:edit")
	@RequestMapping(value = "save")
	public String save(MerchantType merchantType, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, merchantType)) {
			return form(merchantType, model);
		}
		if (merchantType.getId() == null) {
		}
		merchantTypeService.save(merchantType);
		addMessage(redirectAttributes, "保存商旅类别成功");
		return "redirect:" + Global.getAdminPath()
				+ "/business/merchantType/?repage";
	}

	@RequiresPermissions("business:merchantType:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		if (MerchantType.isAdmin(id)) {
			addMessage(redirectAttributes, "删除商旅类别失败, 不允许删除顶级类别或为空");
		} else {
			merchantTypeService.delete(id);
			addMessage(redirectAttributes, "处理商旅类别成功");
		}
		return "redirect:" + Global.getAdminPath()
				+ "/business/merchantType/?repage";
	}

	@RequiresUser
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(
			@RequestParam(required = false) String extId,
			HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		// User user = UserUtils.getUser();
		List<MerchantType> list = merchantTypeService.findAll();
		for (int i = 0; i < list.size(); i++) {
			MerchantType e = list.get(i);
			if (extId == null || (extId != null && !extId.equals(e.getId()))) {
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				// map.put("pId",
				// !user.isAdmin()&&e.getId().equals(user.getMerchantType().getId())?0:e.getParent()!=null?e.getParent().getId():0);
				map.put("pId", e.getParent() != null ? e.getParent().getId()
						: 0);
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
}
