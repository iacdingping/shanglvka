/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.core.mp;

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

import com.slk.core.PageList;
import com.slk.core.entity.mp.WapHome;
import com.slk.core.manager.mp.WapHomeManager;
import com.slk.core.query.mp.WapHomeQuery;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 网站首页Controller
 * 
 * @author 禹波
 * @version 2014-08-23
 */
@Controller
@RequestMapping(value = "${adminPath}/mp/wapHome")
public class WapHomeController extends BaseController {

	@Autowired
	private WapHomeManager wapHomeManager;

	@ModelAttribute
	public WapHome get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return wapHomeManager.getById(id);
		} else {
			return new WapHome();
		}
	}

	@RequiresPermissions("mp:wapHome:view")
	@RequestMapping(value = { "list", "" })
	public String list(WapHomeQuery wapHomeQuery, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		PageList<WapHome> pageList = wapHomeManager.findPage(wapHomeQuery);
		model.addAttribute("pageList", pageList);
		return "modules/mp/wapHomeList";
	}

	@RequiresPermissions("mp:wapHome:view")
	@RequestMapping(value = "form")
	public String form(WapHome wapHome, Model model) {
		model.addAttribute("wapHome", wapHome);
		return "modules/mp/wapHomeForm";
	}

	@RequiresPermissions("mp:wapHome:edit")
	@RequestMapping(value = "save")
	public String save(WapHome wapHome, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wapHome)) {
			return form(wapHome, model);
		}
		wapHomeManager.saveOrUpdate(wapHome);
		addMessage(redirectAttributes, "保存网站首页成功");
		return "redirect:" + Global.getAdminPath()
				+ "/mp/wapHome/?repage";
	}

	@RequiresPermissions("mp:wapHome:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		wapHomeManager.deleteById(id);
		addMessage(redirectAttributes, "删除网站首页成功");
		return "redirect:" + Global.getAdminPath()
				+ "/mp/wapHome/?repage";
	}

}
