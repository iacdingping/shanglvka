package com.slk.wap.controller.about;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.slk.hibernate.core.entity.Questions;
import com.slk.hibernate.core.service.QuestionsService;
import com.thinkgem.jeesite.common.web.BaseController;

/**
 * 通用的
 */
@Controller
@RequestMapping("/about")
public class AboutController extends BaseController {
	@Autowired
	private QuestionsService questionsService;

	/**
	 * 暂用， WAP页面中的相关元素获取
	 * 
	 * @return
	 */
	@RequestMapping(value = "ui")
	public String ui() {
		return "/ui";
	}

	/**
	 * 关于我们界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/come")
	public String come(Model model) {
		Questions questions = new Questions();
		questions.setType("0");
		List<Questions> commonQuestions = questionsService
				.findAllByType(questions);
		questions.setType("1");
		// 保存微信用户code
		questions.setPlatformCode("");
		List<Questions> myQuestions = questionsService.findAllByType(questions);
		// 常见问题
		model.addAttribute("commonQuestions", commonQuestions);
		// 我的问题
		model.addAttribute("myQuestions", myQuestions);
		return "/about/come";
	}

	/**
	 * 保存用户问题
	 * 
	 * @param questions
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "questionSave")
	public String save(Questions questions, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, questions)) {
			return "redirect:/about/come/";
		}
		if (questions.getId() != null) {
			addMessage(redirectAttributes, "数据不对");
			return "redirect:/about/come/";
		}
		// 保存微信用户code
		questions.setCreateTime(new Date());
		questions.setPlatformCode("");
		questionsService.save(questions);
		addMessage(redirectAttributes, "保存常见问题成功");
		return "redirect:/about/come/";
	}
}
