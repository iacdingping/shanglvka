<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.controller.${appModule};

import iac.dp.tourism.util.ExtJsPageHelper;
import iac.dp.tourism.util.PageList;
import iac.dp.tourism.util.PageQuery;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
@Controller
public class ${className}Controller {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	private ${className}Manager ${classNameLower}Manager;
	
	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,
	 * 先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("user", ${classNameLower}Manager.getById(id));
		}
	}
	
	/**
	 * ExtGrid使用
	 * 列表
	 * @throws IOException
	 */
	@ResponseBody
	public PageList<${className}> extlist(HttpServletRequest request,
			HttpServletResponse response, ${className}Query query) throws IOException {
		PageList<${className}> pageList = ${classNameLower}Manager.findPage(query);
		return pageList;
	}
	
	/**
	 * extGrid保存
	 * @throws IOException
	 */
	@ResponseBody
	public Map<String, Object> extsave(${className} ${classNameLower}) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			${classNameLower}Manager.save(${classNameLower});
			result.put("success", true);
			result.put("msg", "添 加 成 功!");
		} catch (Exception e) {
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * extGrid修改
	 * 
	 * @throws IOException
	 */
	@ResponseBody
	public Map<String, Object> extupdate(${className} ${classNameLower}) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			${classNameLower}Manager.update(${classNameLower});
			result.put("success", true);
			result.put("msg", "修 改 成 功!");
		} catch (Exception e) {
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * extGrid删除
	 * @throws IOException
	 */
	@ResponseBody
	public Map<String, Object> extdelete(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String ids = request.getParameter("ids");
		String[] idarray = ids.split(",");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			for (int i = 0; i < idarray.length; i++) {
				Long id = new Long((String) idarray[i]);
				${classNameLower}Manager.deleteById(id);
			}
			result.put("success", true);
			result.put("msg", "删 除 成 功");
		} catch (Exception e) {
			result.put("failure", true);
			result.put("msg", e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	
}