package com.slk.wap.controller.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slk.core.entity.mp.WapHome;
import com.slk.core.manager.mp.WapHomeManager;

@Controller
@RequestMapping
public class WelcomeController {

	@Autowired
	private WapHomeManager wapHomeManager;
	
	@RequestMapping(value={"index", ""})
	public String welcome(ModelMap model) {
		Map<String, List<WapHome>> wapHomes = wapHomeManager.listSortedIndexShow();
		model.put("wapHomes1", wapHomes.get("1"));
		model.put("wapHomes2", wapHomes.get("2"));
		model.put("wapHomes3", wapHomes.get("3"));
		return "index";
	}
}
