package com.slk.controller.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slk.core.entity.sys.Module;
import com.slk.core.manager.sys.ModuleManager;

@Controller
@RequestMapping("module")
public class ModuleController {
	
	@Autowired
	private ModuleManager moduleManager;

	@RequestMapping("ajaxList")
	@ResponseBody
	public List<Module> ajaxListModule() {
		return moduleManager.listAll();
	}
}
