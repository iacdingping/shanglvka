package com.slv.wap.controller.weixin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "xml")
public class WeixinRequest {
	@XmlElement(name = "ToUserName")
	private String toUserName;
	@XmlElement(name = "FromUserName")
	private String fromUserName;
	@XmlElement(name = "CreateTime")
	private String createTime;
	@XmlElement(name = "MsgType")
	private String msgType;
	// 事件推送
	@XmlElement(name = "Event", required = false)
	private String event;
	@XmlElement(name = "EventKey", required = false)
	private String eventKey;

	// 文本内容
	@XmlElement(name = "Content", required = false)
	private String content;

	//图片
	@XmlElement(name = "PicUrl", required = false)
	private String picUrl;
	
	// 地理位置
	@XmlElement(name = "Location_X", required = false)
	private Float location_X;
	@XmlElement(name = "Location_Y", required = false)
	private Float location_Y;
	@XmlElement(name = "Scale", required = false)
	private Integer scale;
	@XmlElement(name = "Label", required = false)
	private String label;

	// 链接消息
	@XmlElement(name = "Title", required = false)
	private String title;
	@XmlElement(name = "Description", required = false)
	private String description;
	@XmlElement(name = "Url", required = false)
	private String url;
	@XmlElement(name = "MsgId", required = false)
	private Long msgId;

	// 语音消息 多媒体ID 用来下载文件
	@XmlElement(name = "MediaId", required = false)
	private String mediaId;
	@XmlElement(name = "Format", required = false)
	private String format;

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
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public Float getLocation_X() {
		return location_X;
	}

	public void setLocation_X(Float location_X) {
		this.location_X = location_X;
	}

	public Float getLocation_Y() {
		return location_Y;
	}

	public void setLocation_Y(Float location_Y) {
		this.location_Y = location_Y;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
