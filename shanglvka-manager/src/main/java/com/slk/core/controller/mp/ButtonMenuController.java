package com.slk.core.controller.mp;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
	public ButtonMenu getButtonMenu(@RequestParam(required = false) Long id) {
		if (id != null) {
			return buttonMenuManager.getById(id);
		} else {
			return new ButtonMenu();
		}
	}

	@RequiresPermissions("mp:buttonMenu:view")
	@RequestMapping(value = { "list", "" })
	public String list(ButtonMenuQuery buttonMenuQuery,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		PageList<ButtonMenu> pageList = buttonMenuManager
				.findPage(buttonMenuQuery);
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
		}else if (buttonMenu.getId() != null
				&& buttonMenu.getId() == buttonMenu.getParent().getId()) {
			addMessage(model, "不能选择自己作为父菜单");
			return form(buttonMenu, model);
		}
		if(buttonMenu.getParent().getId()==null){
			buttonMenu.setParent(new ButtonMenu(0L));
		}
		Long count=buttonMenuManager.countByParent(buttonMenu);
		if((buttonMenu.getParent().getId()==null || buttonMenu.getParent().getId()==0) && count>2){
			addMessage(model, "顶级菜单不能超过三个");
			return form(buttonMenu, model);
		}else if((buttonMenu.getParent().getId()!=null && buttonMenu.getParent().getId()>0) && count>5){
			addMessage(model, "同父子菜单不能超过五个");
			return form(buttonMenu, model);
		}
		buttonMenuManager.saveOrUpdate(buttonMenu);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + Global.getAdminPath() + "/mp/buttonMenu/?repage";
	}

	@RequiresPermissions("mp:buttonMenu:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		buttonMenuManager.deleteById(id);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + Global.getAdminPath() + "/mp/buttonMenu/?repage";
	}

	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(
			@RequestParam(required = false) Long extId,
			@RequestParam(required = false) Long type,
			@RequestParam(required = false) Long grade,
			HttpServletResponse response) {
		response.setContentType("application/json; charset=UTF-8");
		List<Map<String, Object>> mapList = Lists.newArrayList();
		ButtonMenuQuery query = new ButtonMenuQuery();
		query.setParent(new ButtonMenu(0L));
		List<ButtonMenu> list = buttonMenuManager.list(query);
		for (int i = 0; i < list.size(); i++) {
			ButtonMenu e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParent() != null ? e.getParent().getId() : 0);
			map.put("name", e.getName());
			map.put("show", e);
			mapList.add(map);
		}
		return mapList;
	}
}