/*****************************************************************
 *仿佛兮若轻云之蔽月，飘飘兮若流风之回雪
 *@author 禹波
 *@copyright all rights reserved (c) wyyft@163.com
 *****************************************************************/
package com.slk.core.business;
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

import com.slk.hibernate.core.entity.Enroll;
import com.slk.hibernate.core.service.EnrollService;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 商旅活动Controller
 * @author 禹波
 * @version 2014-09-27
 */
@Controller
@RequestMapping(value = "${adminPath}/business/enroll")
public class EnrollController extends BaseController {

	@Autowired
	private EnrollService enrollService;
	
	@ModelAttribute
	public Enroll get(@RequestParam(required=false) Long id) {
		if (id != null){
			return enrollService.get(id);
		}else{
			return new Enroll();
		}
	}
	
	@RequiresPermissions("business:enroll:view")
	@RequestMapping(value = {"list", ""})
	public String list(Enroll enroll, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
//		if (!user.isAdmin()){
//			enroll.setCreateBy(user);
//		}
        Page<Enroll> page = enrollService.find(new Page<Enroll>(request, response), enroll); 
        model.addAttribute("page", page);
		return "modules/business/enrollList";
	}

	@RequiresPermissions("business:enroll:view")
	@RequestMapping(value = "form")
	public String form(Enroll enroll, Model model) {
		model.addAttribute("enroll", enroll);
		return "modules/business/enrollForm";
	}

	@RequiresPermissions("business:enroll:edit")
	@RequestMapping(value = "save")
	public String save(Enroll enroll, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, enroll)){
			return form(enroll, model);
		}
		enrollService.save(enroll);
		addMessage(redirectAttributes, "保存商旅活动成功");
		return "redirect:"+Global.getAdminPath()+"/business/enroll/?repage";
	}
	
	@RequiresPermissions("business:enroll:edit")
	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		enrollService.delete(id);
		addMessage(redirectAttributes, "删除商旅活动成功");
		return "redirect:"+Global.getAdminPath()+"/business/enroll/?repage";
	}

}
