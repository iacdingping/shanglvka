package com.slk.wap.controller.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slk.hibernate.core.entity.MerchantBrand;
import com.slk.hibernate.core.entity.MerchantMap;
import com.slk.hibernate.core.service.MerchantBrandService;
import com.slk.hibernate.core.service.MerchantMapService;
import com.slk.hibernate.core.service.MerchantTypeService;
import com.thinkgem.jeesite.modules.sys.service.AreaService;

/**
 * 商旅
 */
@Controller
@RequestMapping("/sl")
public class SLController {
	@Autowired
	private MerchantMapService merchantMapService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private MerchantBrandService merchantBrandService;
	@Autowired
	private MerchantTypeService merchantTypeService;

	/**
	 * 品牌刷选列表
	 * 
	 * @return
	 */
	@RequestMapping("/brandlist")
	public String brandlist(Model model, String areaId, Long typeId) {
		model.addAttribute("areaList",
				areaService.findAllByPid("3e9ab3f7ea4a43e79e3e067d2835d303"));
		model.addAttribute("typeList", merchantTypeService.findAllByPid(1L));
		model.addAttribute("merchantBrands",
				merchantBrandService.findAllByTypeAndArea(typeId, areaId));
		return "/info/sl/brandlist";
	}

	@RequestMapping("/getBrands")
	@ResponseBody
	public List<MerchantBrand> getBrands(Model model, String areaId, Long typeId) {
		return merchantBrandService.findAllByTypeAndArea(typeId, areaId);
	}

	/**
	 * 地址列表
	 * 
	 * @return
	 */
	@RequestMapping("/addressList")
	public String list(Model model, Long brandId) {
		model.addAttribute("merchantMaps",
				merchantMapService.listByBrand(brandId));
		return "/info/sl/list";
	}

	/**
	 * 详情
	 * 
	 * @return
	 */
	@RequestMapping("/detail/{slID}")
	public String detail(Model model, @PathVariable Long slID) {
		MerchantMap merchantMap = merchantMapService.get(slID);
		model.addAttribute("merchantMap", merchantMap);
		return "/info/sl/detail";
	}
}
