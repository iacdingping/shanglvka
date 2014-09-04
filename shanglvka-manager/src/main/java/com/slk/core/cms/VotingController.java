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
import com.thinkgem.jeesite.modules.cms.entity.Voting;
import com.thinkgem.jeesite.modules.cms.service.VotingService;

/**
 * 投票Controller
 * @author 禹波
 * @version 2014-09-04
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/voting")
public class VotingController extends BaseController {

	@Autowired
	private VotingService votingService;
	
	@ModelAttribute
	public Voting get(@RequestParam(required=false) Long id) {
		if (id != null){
			return votingService.get(id);
		}else{
			return new Voting("","");
		}
	}
	
	@RequiresPermissions("cms:voting:view")
	@RequestMapping(value = {"list", ""})
	public String list(Voting voting, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (!user.isAdmin()){
			voting.setCreateBy(user);
		}
        Page<Voting> page = votingService.find(new Page<Voting>(request, response), voting); 
        model.addAttribute("page", page);
		return "modules/cms/votingList";
	}

	@RequiresPermissions("cms:voting:view")
	@RequestMapping(value = "form")
	public String form(Voting voting, Model model) {
		model.addAttribute("voting", voting);
		return "modules/cms/votingForm";
	}

	@RequiresPermissions("cms:voting:edit")
	@RequestMapping(value = "save")
	public String save(Voting voting, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, voting)){
			return form(voting, model);
		}
		votingService.save(voting);
		addMessage(redirectAttributes, "保存投票成功");
		return "redirect:"+Global.getAdminPath()+"/modules/cms/voting/?repage";
	}
	
	@RequiresPermissions("cms:voting:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		votingService.delete(id);
		addMessage(redirectAttributes, "删除投票成功");
		return "redirect:"+Global.getAdminPath()+"/modules/cms/voting/?repage";
	}

}
