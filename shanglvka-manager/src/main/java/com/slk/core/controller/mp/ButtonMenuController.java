package com.slk.core.controller.mp;

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
import com.slk.core.entity.mp.ButtonMenu;
import com.slk.core.manager.mp.ButtonMenuManager;
import com.slk.core.query.mp.ButtonMenuQuery;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Controller
@RequestMapping(value = "${adminPath}/mp/buttonMenu")
public class ButtonMenuController extends BaseController {
	
	@Autowired
	private ButtonMenuManager buttonMenuManager;
	
	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,
	 * 先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void getButtonMenu(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("buttonMenu", buttonMenuManager.getById(id));
		}
	}
	
	@RequiresPermissions("mp:buttonMenu:view")
	@RequestMapping(value = { "list", "" })
	public String list(ButtonMenuQuery buttonMenuQuery, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		PageList<ButtonMenu> pageList = buttonMenuManager.findPage(buttonMenuQuery);
		model.addAttribute("pageList", pageList);
		model.addAttribute("pageQuery", buttonMenuQuery);
		return "modules/mp/ButtonMenuList";
	}
	
	@RequiresPermissions("mp:buttonMenu:view")
	@RequestMapping(value = "form")
	public String form(ButtonMenu buttonMenu, Model model) {
		model.addAttribute("buttonMenu", buttonMenu);
		return "modules/mp/ButtonMenuForm";
	}
	
	@RequiresPermissions("mp:buttonMenu:edit")
	@RequestMapping(value = "save")
	public String save(ButtonMenu buttonMenu, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, buttonMenu)) {
			return form(buttonMenu, model);
		}
		buttonMenuManager.saveOrUpdate(buttonMenu);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + Global.getAdminPath()
				+ "/mp/buttonMenu/?repage";
	}

	@RequiresPermissions("mp:buttonMenu:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		buttonMenuManager.deleteById(id);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + Global.getAdminPath()
				+ "/mp/buttonMenu/?repage";
	}
}