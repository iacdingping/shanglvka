/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.core.controller.mp;

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

import com.slk.core.PageList;
import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.entity.mp.WeixinUser;
import com.slk.core.manager.mp.WeixinUserManager;
import com.slk.core.query.mp.WeixinUserQuery;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 微信用户Controller
 * 
 * @author 禹波
 * @version 2014-09-27
 */
@Controller
@RequestMapping(value = "${adminPath}/mp/weixinUser")
public class WpUserController extends BaseController {

	@Autowired
	private WeixinUserManager weixinUserManager;

	@ModelAttribute
	public WeixinUser get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return weixinUserManager.getById(id);
		} else {
			return new WeixinUser();
		}
	}

	@RequiresPermissions("mp:weixinUser:view")
	@RequestMapping(value = { "list", "" })
	public String list(WeixinUserQuery buttonMenuQuery,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		PageList<WeixinUser> pageList = weixinUserManager
				.findPage(buttonMenuQuery);
		model.addAttribute("pageList", pageList);
		model.addAttribute("pageQuery", buttonMenuQuery);
		return "modules/mp/weixinUserList";
	}

	@RequiresPermissions("mp:weixinUser:view")
	@RequestMapping(value = "form")
	public String form(WeixinUser weixinUser, Model model) {
		model.addAttribute("weixinUser", weixinUser);
		return "modules/mp/weixinUserForm";
	}

	@RequiresPermissions("mp:weixinUser:edit")
	@RequestMapping(value = "save")
	public String save(WeixinUser weixinUser, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, weixinUser)) {
			return form(weixinUser, model);
		}
		weixinUserManager.save(weixinUser);
		addMessage(redirectAttributes, "保存微信用户成功");
		return "redirect:" + Global.getAdminPath() + "/mp/weixinUser/?repage";
	}

	@RequiresPermissions("mp:weixinUser:view")
	@RequestMapping(value = "setStaff")
	public String setStaff(Long id, RedirectAttributes redirectAttributes) {
		weixinUserManager.setStaff(id);
		addMessage(redirectAttributes, "设置微信用户成功");
		return "redirect:" + Global.getAdminPath() + "/mp/weixinUser/?repage";
	}

}
