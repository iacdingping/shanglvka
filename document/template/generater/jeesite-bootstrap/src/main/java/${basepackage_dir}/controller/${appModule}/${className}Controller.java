<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#macro mapperEl value>${r"${"}${value}}</#macro>
package ${basepackage}.controller.${appModule};

import iac.dp.tourism.util.ExtJsPageHelper;
import iac.dp.tourism.util.PageList;
import iac.dp.tourism.util.PageQuery;

import java.io.IOException;
import java.util.HashMap;
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

import com.slk.core.entity.mp.WapHome;
import com.slk.core.query.mp.WapHomeQuery;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;

<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
@Controller
@RequestMapping(value = "<@mapperEl 'adminPath'/>/${appModule}/${classNameLower}")
public class ${className}Controller extends BaseController {
	
	@Autowired
	private ${className}Manager ${classNameLower}Manager;
	
	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,
	 * 先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void get${className}(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("${classNameLower}", ${classNameLower}Manager.getById(id));
		}
	}
	
	@RequiresPermissions("${appModule}:${classNameLower}:view")
	@RequestMapping(value = { "list", "" })
	public String list(${className}Query ${classNameLower}Query, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		PageList<${className}> pageList = ${classNameLower}Manager.findPage(${classNameLower}Query);
		model.addAttribute("pageList", pageList);
		model.addAttribute("pageQuery", ${classNameLower}Query);
		return "modules/${appModule}/${className}List";
	}
	
	@RequiresPermissions("${appModule}:${classNameLower}:view")
	@RequestMapping(value = "form")
	public String form(${className} ${classNameLower}, Model model) {
		model.addAttribute("${classNameLower}", ${classNameLower});
		return "modules/${appModule}/${className}Form";
	}
	
	@RequiresPermissions("${appModule}:${classNameLower}:edit")
	@RequestMapping(value = "save")
	public String save(${className} ${classNameLower}, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ${classNameLower})) {
			return form(${classNameLower}, model);
		}
		${classNameLower}Manager.saveOrUpdate(${classNameLower});
		addMessage(redirectAttributes, "保存成功");
		return "redirect:" + Global.getAdminPath()
				+ "/${appModule}/${classNameLower}/?repage";
	}

	@RequiresPermissions("${appModule}:${classNameLower}:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		${classNameLower}Manager.deleteById(id);
		addMessage(redirectAttributes, "删除成功");
		return "redirect:" + Global.getAdminPath()
				+ "/${appModule}/${classNameLower}/?repage";
	}
}