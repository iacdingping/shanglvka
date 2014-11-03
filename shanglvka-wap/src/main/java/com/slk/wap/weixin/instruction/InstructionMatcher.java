package com.slk.wap.weixin.instruction;

import java.util.ArrayList;
import java.util.List;

import com.slk.core.SpringContextUtil;
import com.slk.wap.controller.weixin.WeixinRequest;
import com.slk.wap.weixin.process.Processor;
import com.slk.wap.weixin.process.impl.CancelAttentionProcessor;
import com.slk.wap.weixin.process.impl.KeyWordsProcessor;
import com.slk.wap.weixin.process.impl.LocationProcessor;
import com.slk.wap.weixin.process.impl.PictureProcessor;
import com.slk.wap.weixin.process.impl.UnknowRequestTypeProcessor;
import com.slk.wap.weixin.process.impl.VoiceProcessor;
import com.slk.wap.weixin.process.impl.WelcomeProcessor;

/**
 * 指令匹配器
 * @author "iacdp"
 *
 */
public class InstructionMatcher {
	
	public static List<Instruction<WeixinRequest>> instructionSets = new ArrayList<Instruction<WeixinRequest>>();

	static {
//		instructionSets.add(SpringContextUtil.getBean(WelcomeInstruction.class));
	}
	/**
	* @Description: 匹配输出的内容的类型（类型=request.getMsgType()）,根据类型来执行对应的匹配代码，如：type为'text'执行textMatch（）方法
	* @param io
	* @return Processor<InstructionObject>
	 */
	public static Processor<WeixinRequest> match(WeixinRequest request) {
		if("subscribe".equals(request.getEvent())) {
			return SpringContextUtil.getBean(WelcomeProcessor.class);
		} else if("unsubscribe".equals(request.getEvent())) {
			return SpringContextUtil.getBean(CancelAttentionProcessor.class);
		} else {
			switch (RequestType.getByValue(request.getMsgType())) {
			case TEXT:
				return textMatch(request.getContent());
			case EVENT:
				//后续的event都根据content去匹配
				request.setContent(request.getEventKey());
				return textMatch(request.getEventKey());
			case VOICE:
				return SpringContextUtil.getBean(VoiceProcessor.class);
			case IMAGE:
				return SpringContextUtil.getBean(PictureProcessor.class);
			case LOCATION:
				return SpringContextUtil.getBean(LocationProcessor.class);
			default:
				return SpringContextUtil.getBean(UnknowRequestTypeProcessor.class);
			}
		}
	}
	/**
	* @Description:  用request的Content内容去匹配instructionSets集合中某一个Instruction<InstructionObject>的匹配内容
	* @param  instructionStr
	* @param  io
	* @return Processor<InstructionObject>
	 */
	private static Processor<WeixinRequest> textMatch(String instructionStr) {
		for(Instruction<WeixinRequest> i : instructionSets) {
			if(i.matches(instructionStr)) {
				return i.getProcessor();
			}
		}
		//不在匹配接口类集合中，则执行以下匹配
		return SpringContextUtil.getBean(KeyWordsProcessor.class);
	}
}
