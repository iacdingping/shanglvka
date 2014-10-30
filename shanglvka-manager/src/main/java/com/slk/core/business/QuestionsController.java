/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.core.business;

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

import com.slk.hibernate.core.entity.Questions;
import com.slk.hibernate.core.service.QuestionsService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 常见问题Controller
 * 
 * @author 禹波
 * @version 2014-09-27
 */
@Controller
@RequestMapping(value = "${adminPath}/business/questions")
public class QuestionsController extends BaseController {

	@Autowired
	private QuestionsService questionsService;

	@ModelAttribute
	public Questions get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return questionsService.get(id);
		} else {
			return new Questions();
		}
	}

	@RequiresPermissions("business:questions:view")
	@RequestMapping(value = { "list", "" })
	public String list(Questions questions, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		// if (!user.isAdmin()){
		// questions.setCreateBy(user);
		// }
		Page<Questions> page = questionsService.find(new Page<Questions>(
				request, response), questions);
		model.addAttribute("page", page);
		return "modules/business/questionsList";
	}

	@RequiresPermissions("business:questions:view")
	@RequestMapping(value = "form")
	public String form(Questions questions, Model model) {
		model.addAttribute("questions", questions);
		return "modules/business/questionsForm";
	}

	@RequiresPermissions("business:questions:edit")
	@RequestMapping(value = "save")
	public String save(Questions questions, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, questions)) {
			return form(questions, model);
		}
		if (questions.getId() == null) {
			questions.setType("0");
			questions.setCreateTime(new Date());
		}
		questionsService.save(questions);
		addMessage(redirectAttributes, "保存常见问题成功");
		return "redirect:" + Global.getAdminPath()
				+ "/business/questions/?repage";
	}

	@RequiresPermissions("business:questions:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		questionsService.delete(id);
		addMessage(redirectAttributes, "删除常见问题成功");
		return "redirect:" + Global.getAdminPath()
				+ "/business/questions/?repage";
	}

}
