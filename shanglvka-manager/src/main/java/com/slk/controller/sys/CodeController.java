package com.slk.controller.sys;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slk.core.PageList;
import com.slk.core.entity.sys.Code;
import com.slk.core.manager.sys.CodeManager;
import com.slk.core.query.sys.CodeQuery;


/**
 *
 * @author dingp email:dingp@51box.cn
 * @version 1.0
 * @since 1.0
 * */
@Controller
public class CodeController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	private CodeManager codeManager;
	
	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2 Preparable二次部分绑定的效果,
	 * 先根据form的id从数据库查出User对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("user", codeManager.getById(id));
		}
	}
	
	/**
	 * ExtGrid使用
	 * 列表
	 * @throws IOException
	 */
	@ResponseBody
	public PageList<Code> extlist(HttpServletRequest request,
			HttpServletResponse response, CodeQuery query) throws IOException {
		PageList<Code> pageList = codeManager.findPage(query);
		return pageList;
	}
	
	/**
	 * extGrid保存
	 * @throws IOException
	 */
	@ResponseBody
	public Map<String, Object> extsave(Code code) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			codeManager.save(code);
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
	public Map<String, Object> extupdate(Code code) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			codeManager.update(code);
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
				codeManager.deleteById(id);
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