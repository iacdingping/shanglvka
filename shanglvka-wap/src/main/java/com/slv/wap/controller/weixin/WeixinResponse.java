package com.slv.wap.controller.weixin;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class WeixinResponse {
	@XmlElement(name = "ToUserName")
	private String toUserName;
	@XmlElement(name = "FromUserName")
	private String fromUserName;
	@XmlElement(name = "CreateTime")
	private String createTime;
	@XmlElement(name = "MsgType")
	private String msgType;
	@XmlElement(name = "Content",required=false)
	private String content;
	@XmlElement(name = "FuncFlag",required=false)
	private Integer funcFlag;
	@XmlElement(name = "ArticleCount",required=false)
	private Integer articleCount;
	@XmlElementWrapper(name="Articles")@XmlElements(@XmlElement(name="item",required=false))
	private List<ArticleItem> items;
	public WeixinResponse(){
		
	}
	/**
	* <p>Title:构造函数 </p> 
	* <p>Description:初始化  toUserName,fromUserName,createTime</p> 
	* @param toUserName
	* @param fromUserName
	* @param createTime
	 */
	public WeixinResponse(String toUserName,String fromUserName,String createTime){
		this.toUserName=toUserName;
		this.fromUserName=fromUserName;
		this.createTime=createTime;
	}
	/**
	* <p>Title: 构造函数</p> 
	* <p>Description: 接收request如下3个值，FromUserName，ToUserName，CreateTime到当前类</p> 
	* @param request
	 */
	public WeixinResponse(WeixinRequest request){
		this(request.getFromUserName(), request.getToUserName(), request.getCreateTime());
	}
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		this.setFuncFlag(0);
		this.setMsgType("text");
	}
	public Integer getFuncFlag() {
		return funcFlag;
	}
	public void setFuncFlag(Integer funcFlag) {
		this.funcFlag = funcFlag;
	}

	public Integer getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
	public List<ArticleItem> getItems() {
		return items;
	}
	public void setItems(List<ArticleItem> items) {
		this.items = items;
		this.setArticleCount(items.size());
		this.setFuncFlag(1);
		this.setMsgType("news");
	}
	@Override
	public String toString() {
		if(this.getContent()!=null && !this.getContent().equals("")){
			return "WeixinResponse [toUserName=" + toUserName
					+ ", fromUserName=" + fromUserName + ", createTime="
					+ createTime + ", msgType=" + msgType + ", content=" + content
					+ ", funcFlag=" + funcFlag + "]";
		}else{
			ArticleItem item=new ArticleItem();
			return "WeixinResponse [toUserName=" + toUserName
			+ ", fromUserName=" + fromUserName + ", createTime="
			+ createTime + ", msgType=" + msgType + ", articleCount=" + articleCount + ", items=" + item.toString()
			+ ", funcFlag=" + funcFlag + "]";
		}
	}
	
}
