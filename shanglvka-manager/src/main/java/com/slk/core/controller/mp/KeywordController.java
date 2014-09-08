/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
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
import com.slk.core.entity.mp.Keyword;
import com.slk.core.manager.mp.KeywordManager;
import com.slk.core.query.mp.KeywordQuery;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 关键字Controller
 * @author yewenqu
 * @version 2014-09-05
 */
@Controller
@RequestMapping(value = "${adminPath}/mp/keyword")
public class KeywordController extends BaseController {

	@Autowired
	private KeywordManager keywordManager;
	
	@ModelAttribute
	public Keyword get(@RequestParam(required=false) Long id) {
		if (id != null) {
			return keywordManager.getById(id);
		} else {
			return new Keyword();
		}
	}
	
	@RequiresPermissions("mp:keyword:view")
	@RequestMapping(value = {"list", ""})
	public String list(KeywordQuery keywordQuery, HttpServletRequest request, HttpServletResponse response, Model model) {
        PageList<Keyword> pageList = keywordManager.findPage(keywordQuery);
        model.addAttribute("page", pageList);
        model.addAttribute("pageQuery", keywordQuery);
		return "modules/mp/keywordList";
	}

	@RequiresPermissions("mp:keyword:view")
	@RequestMapping(value = "form")
	public String form(Keyword keyword, Model model) {
		model.addAttribute("keyword", keyword);
		return "modules/mp/keywordForm";
	}

	@RequiresPermissions("mp:keyword:edit")
	@RequestMapping(value = "save")
	public String save(Keyword keyword, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, keyword)){
			return form(keyword, model);
		}
		keyword.setResponseType("TEXT");
		keywordManager.saveOrUpdate(keyword);
		addMessage(redirectAttributes, "保存关键字'" + keyword.getKey() + "'成功");
		return "redirect:"+Global.getAdminPath()+"/mp/keyword/?repage";
	}
	
	@RequiresPermissions("mp:keyword:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		keywordManager.deleteById(id);
		addMessage(redirectAttributes, "删除关键字成功");
		return "redirect:"+Global.getAdminPath()+"/mp/keyword/?repage";
	}

}
