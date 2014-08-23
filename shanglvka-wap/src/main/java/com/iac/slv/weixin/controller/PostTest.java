package com.iac.slv.weixin.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostTest {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/weixin");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			// 设置为POST请求
			connection.setRequestMethod("POST");
			// 设置doOutput属性为true表示将使用此urlConnection写入数据
			connection.setDoOutput(true);
			// 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
			connection.setRequestProperty("content-type",
					"application/x-www-form-urlencoded");
			OutputStreamWriter out = new OutputStreamWriter(
					connection.getOutputStream());

//			StringBuffer imagesbstr = new StringBuffer();
//			imagesbstr.append("");
//			imagesbstr.append("inMcar");
//			imagesbstr.append("lyLiuyou");
//			imagesbstr.append("1348831860");
//			imagesbstr.append("image");
//			imagesbstr
//					.append("http://ww3.sinaimg.cn/large/468bee0bjw1e1t8jiyyn5j.jpg");
//			imagesbstr.append("1234567890123456");
//			imagesbstr.append("");
//
//			StringBuffer musicsbstr = new StringBuffer();
//			musicsbstr.append("");
//			musicsbstr.append("inMcar");
//			musicsbstr.append("lyLiuyou");
//			musicsbstr.append("1348831860");
//			musicsbstr.append("text");
//			musicsbstr.append("看图片");
//			musicsbstr.append("1234567890123456");
//			musicsbstr.append("");
			// 把数据写入请求的Body
			out.write("a");
			out.flush();
			out.close();

			// 从服务器读取响应
			InputStream inputStream = connection.getInputStream();
			String encoding = connection.getContentEncoding();
			//String body = IOUtils.toString(inputStream, encoding);
			System.out.println(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}