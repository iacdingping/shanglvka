package com.slk.core.controller.weichat.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slk.core.Config;
import com.thinkgem.jeesite.common.utils.StringUtils;

@Controller
@RequestMapping("api/transit")
public class TransitController {

	@Autowired
	private Config config;

	private Logger log = LoggerFactory.getLogger(TransitController.class);

	@RequestMapping("")
	@ResponseBody
	public String request(HttpServletRequest request, HttpServletResponse response) throws IOException {
		printEnumeration(request.getHeaderNames(), request);
		String data = getSoapByInputStream(request.getInputStream());
		
		System.out.println(data);
		String result = "";
		if(StringUtils.isBlank(data)) {
			result = sendGetMessage(config.getUrl() + "?wsdl");
		} else {
			result = sendPostMessage(config.getUrl(), data);
		}
		System.out.println("returned:" + result);
		return result;
	}

	public void printEnumeration(Enumeration enum1, HttpServletRequest hsr) {
		log.info("http header start");
		while (enum1.hasMoreElements()) {
			String object1 = (String) enum1.nextElement();
			log.info("name=" + object1 + ",value=" + hsr.getHeader(object1));
		}

		log.info("http header end");
	}

	public static String getSoapByInputStream(InputStream is) {
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = br.readLine();
			while (line != null) {
				result = result + line;
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public String sendPostMessage(String url, String content) {
		String result = "";
		long start = System.currentTimeMillis();
		try {
			URL webUrl = new URL(url);

			HttpURLConnection huc = (HttpURLConnection) webUrl.openConnection();
			huc.setRequestMethod("POST");
			huc.setDoOutput(true);
			huc.setDoInput(true);
			huc.setRequestProperty("SOAPAction", "");

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(
					huc.getOutputStream()));
			pw.print(content);
			pw.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					huc.getInputStream()));

			String line = "";

			while ((line = br.readLine()) != null) {
				result = result + line;
			}

			log.info("[" + (System.currentTimeMillis() - start) + "'ms]" + "["
					+ result.trim() + "]" + url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			log.error("[" + (System.currentTimeMillis() - start) + "'ms]" + "["
					+ result.trim() + "]" + url + "," + content);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("[" + (System.currentTimeMillis() - start) + "'ms]" + "["
					+ result.trim() + "]" + url + "," + content);
		}

		return result;
	}

	public String sendGetMessage(String url) {
		String result = "";
		long start = System.currentTimeMillis();
		try {
			url = url.replaceAll("[ ]", "");
			URL webUrl = new URL(url);

			HttpURLConnection huc = (HttpURLConnection) webUrl.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					huc.getInputStream()));

			String line = "";

			while ((line = br.readLine()) != null) {
				result = result + line;
			}
			String url2 = "";
			try {
				url2 = URLDecoder.decode(url);
			} catch (Exception e) {
				url2 = url;
			}
			log.info("[" + (System.currentTimeMillis() - start) + "'ms]" + "["
					+ result.trim() + "]" + url2);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			log.error("[" + (System.currentTimeMillis() - start) + "'ms]" + "["
					+ result.trim() + "]" + url);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("[" + (System.currentTimeMillis() - start) + "'ms]" + "["
					+ result.trim() + "]" + url);
		}

		return result;
	}
}
