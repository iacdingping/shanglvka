/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.core.cms;

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

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.cms.entity.VotingLog;
import com.thinkgem.jeesite.modules.cms.service.VotingLogService;
import com.thinkgem.jeesite.modules.cms.service.VotingService;

/**
 * 投票记录Controller
 * 
 * @author 禹波
 * @version 2014-09-04
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/votingLog")
public class VotingLogController extends BaseController {

	@Autowired
	private VotingLogService votingLogService;
	@Autowired
	private VotingService votingService;

	@ModelAttribute
	public VotingLog get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return votingLogService.get(id);
		} else {
			return new VotingLog();
		}
	}

	@RequiresPermissions("cms:votingLog:view")
	@RequestMapping(value = { "list", "" })
	public String list(VotingLog votingLog, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<VotingLog> page = votingLogService.find(new Page<VotingLog>(
				request, response), votingLog);
		model.addAttribute("page", page);
		model.addAttribute("voting",votingService.get(votingLog.getVoting()));
		return "modules/cms/votingLogList";
	}

	@RequiresPermissions("cms:votingLog:view")
	@RequestMapping(value = "form")
	public String form(VotingLog votingLog, Model model) {
		model.addAttribute("votingLog", votingLog);
		return "modules/cms/votingLogForm";
	}

	@RequiresPermissions("cms:votingLog:edit")
	@RequestMapping(value = "save")
	public String save(VotingLog votingLog, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, votingLog)) {
			return form(votingLog, model);
		}
		votingLogService.save(votingLog);
		addMessage(redirectAttributes, "保存投票记录成功");
		return "redirect:" + Global.getAdminPath()
				+ "/modules/cms/votingLog/?repage";
	}

	@RequiresPermissions("cms:votingLog:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		votingLogService.delete(id);
		addMessage(redirectAttributes, "删除投票记录成功");
		return "redirect:" + Global.getAdminPath()
				+ "/modules/cms/votingLog/?repage";
	}

}
