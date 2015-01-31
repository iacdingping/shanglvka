package com.slk.wap.controller.activity;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 刷卡达人
 *
 */
@Controller
@RequestMapping("/act/pos")
public class POSCardController {
	@RequestMapping("/index")
	public String index() {
		return "/act/pos/index";
	}

	@RequestMapping("/upLoadPic")
	@ResponseBody
	public String upLoadPic(ModelMap model, HttpServletRequest request,
			@RequestParam(value = "file") MultipartFile file) {
		try {
			String pic = uploadIconPic(file, request.getSession().getServletContext().getRealPath("/")
					+ "/upload/" + file.getOriginalFilename()); // 上传并处理图片
			if ("1".equals(pic)) {
				return "1";
			}
			// PicInfoDTO picInfo = new PicInfoDTO();
			// picInfo.setPicUrl(pic);
			// picInfo.setBusinessType(2);
			// wsqService.addPic(picInfo);
			return "{success:true,picid:" + 0 + ",picUrl:\"" + pic + "\"}";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "2";
		}

	}

	/**
	 * 上传图片
	 * 
	 * @Title: uploadIconPic
	 * @Description:
	 * @param @param file
	 * @param @param fileNames
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 */
	public String uploadIconPic(MultipartFile file, String path)
			throws Exception {
		String _iconUrl = "";
		String fileName = "";
		String tag = null;
		if (file != null && file.getSize() > 0) {
			String fileTail = getFileExt(file.getOriginalFilename());

			if (!fileTail.toLowerCase().equals("png")
					&& !fileTail.toLowerCase().equals("jpg")
					&& !fileTail.toLowerCase().equals("jpeg")) {
				return "1";
			}

			fileName = System.currentTimeMillis() + "." + fileTail;
			// 判断文件是否为空
			if (!file.isEmpty()) {
				try {
					// 文件保存路径
					// 转存文件
					file.transferTo(new File(path));
					return path;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return null;

	}

	public String upLoadPic() {
		return "";
	}

	public static String getFileExt(String fileName) {
		if (fileName == null || fileName.equals("")) {
			return "";
		}
		String[] ext = fileName.trim().split("\\.");
		return ext[ext.length - 1];
	}
}
