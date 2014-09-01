package com.slk.wap.controller.weixin.menu;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/set-menu")
public class MenuController {

	private static HttpClient httpclient ;
	
	static{
		httpclient = new DefaultHttpClient();
	}
	
	/** {
	     "button":[
	     {	
	          "type":"click",
	          "name":"今日歌曲",
	          "key":"V1001_TODAY_MUSIC"
	      },
	      {
	           "type":"click",
	           "name":"歌手简介",
	           "key":"V1001_TODAY_SINGER"
	      },
	      {
	           "name":"菜单",
	           "sub_button":[
	           {	
	               "type":"view",
	               "name":"搜索",
	               "url":"http://www.soso.com/"
	            },
	            {
	               "type":"view",
	               "name":"视频",
	               "url":"http://v.qq.com/"
	            },
	            {
	               "type":"click",
	               "name":"赞一下我们",
	               "key":"V1001_GOOD"
	            }]
	       }]
	 }
	 **/
	@RequestMapping("")
	@ResponseBody
	public Map<String , Object> set(@RequestParam("appid")String appid,
			@RequestParam("secret")String secret,
			@RequestParam("menuID")String menuID) throws Exception{
		
		Map<String , Object> map = new HashMap<String , Object>();
		String result = "" ;
		String params = this.organizMenu(menuID);
		String accessToken = this.getAccessToken(appid, secret);
		String delStr = deleteMenuInfo(accessToken);
		if(delStr.equals("ok")){
			result = createMenu(params, accessToken);
		}
		map.put("result", result);
		return map;
	}
	
	@RequestMapping("/view")
	@ResponseBody
	public Map<String , Object> view(@RequestParam("appid")String appid,
			@RequestParam("secret")String secret){
		Map<String , Object> map = new HashMap<String , Object>();
		try {
			map.put("result", this.getMenuInfo(this.getAccessToken(appid, secret)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map; 
	}
	
	
	//构建菜单
	public String organizMenu(String menuID){
		String jsonStr="{"+
			     "\"button\":["+
			     "{"+
		           "\"name\":\"查询\","+
		           "\"type\":\"click\","+
		           "\"key\":\"CX\""+
		         "},"+
		           
		         "{"+
	               "\"name\":\"流量加油\","+
	               "\"type\":\"click\","+
	               "\"key\":\"lljy\""+
	             "},"+
	           

			      "{"+
						" \"name\":\"发现\","+
						"\"sub_button\":["+
						
						"{"+
						"\"type\":\"click\","+
						"\"name\":\"流量俱乐部\","+
						"\"key\":\"qiandao\""+
						"}," +
							
					"{"+
					"\"type\":\"click\","+
					"\"name\":\"活动专区\","+
					"\"key\":\"tqb\""+
					"}," +
						
						"{"+
							"\"type\":\"click\","+
							"\"name\":\"中奖纪录\","+
							"\"key\":\"ZJJL\""+
						"}," +
						
						
						"{"+
							"\"type\":\"click\","+
							"\"name\":\"管家帮助\","+
							"\"key\":\"HELP\""+
							"}" +
						"]" +
				  " }"+
		      "]"+
		" }";
		return jsonStr;
	}
	/** 
     * 获取accessToken  
     */  
    public  String getAccessToken(String appid, String secret) throws Exception {    
        HttpGet get = getGetMethod("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret=" + secret);    
        HttpResponse response = httpclient.execute(get);    
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");  
        JSONObject demoJson = new JSONObject(jsonStr);  
        return demoJson.getString("access_token");  
    }    
	
	/** 
     * 查询菜单 
     */  
    public  String getMenuInfo(String accessToken) throws Exception {    
        HttpGet get = getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + accessToken);    
        HttpResponse response = httpclient.execute(get);    
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");    
        return jsonStr;    
    }    
      
    /**  
     * 删除菜单  
     */    
    public  String deleteMenuInfo(String accessToken) throws Exception {    
        HttpGet get = getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + accessToken);    
        HttpResponse response = httpclient.execute(get);    
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");    
        JSONObject demoJson = new JSONObject(jsonStr);  
        return demoJson.getString("errmsg");    
    }  
    
    /** 
     * 创建菜单  
     */  
    public String createMenu(String params, String accessToken) throws Exception {    
        HttpPost httpost = getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken);    
        httpost.setEntity(new StringEntity(params, "UTF-8"));    
        HttpResponse response = httpclient.execute(httpost);    
        String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");    
        JSONObject demoJson = new JSONObject(jsonStr);  
        return demoJson.getString("errmsg");  
    }  
    
    /**  
     * 模拟浏览器GET提交  
     * @param url  
     * @return  
     */  
    public HttpGet getGetMethod(String url) {  
        HttpGet pmethod = new HttpGet(url);  
        // 设置响应头信息  
        pmethod.addHeader("Connection", "keep-alive");  
        pmethod.addHeader("Cache-Control", "max-age=0");  
        pmethod.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");  
        pmethod.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/;q=0.8");  
        return pmethod;  
    }
    /** 
     * 模拟浏览器post提交 
     * @param url 
     * @return 
     */  
    public HttpPost getPostMethod(String url) {  
        HttpPost pmethod = new HttpPost(url); // 设置响应头信息  
        pmethod.addHeader("Connection", "keep-alive");  
        pmethod.addHeader("Accept", "*/*");  
        pmethod.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");  
        pmethod.addHeader("Host", "mp.weixin.qq.com");  
        pmethod.addHeader("X-Requested-With", "XMLHttpRequest");  
        pmethod.addHeader("Cache-Control", "max-age=0");  
        pmethod.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");  
        return pmethod;  
    }  
}
