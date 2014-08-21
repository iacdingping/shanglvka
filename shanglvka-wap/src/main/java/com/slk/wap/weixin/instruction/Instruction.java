package com.slk.wap.weixin.instruction;

import java.util.regex.Pattern;

import com.slk.wap.weixin.process.Processor;

/**
 * 指令接口
 * 
 * @author "iacdp"
 * 
 */
public interface Instruction<T> {
	
	/**
	 * 是否严格匹配
	 * @return true equals ignore 
	 * 			false regular matches
	 */
	public boolean isStrictMatch();
	
	/**
	 * 是否匹配指令
	 * if isStrictMatch return true , match (abc|def|gh) to abc return true
	 * 
	 * @param instructionStr
	 * @return 
	 */
	public boolean matches(String instructionStr);
	
	/**
	 * 获取正则表达式
	 * 
	 * @return
	 */
	public String getRegular();
	
	/**
	 * 缓存匹配器
	 * 
	 * @return
	 */
	public Pattern getPattern();
	
	/**
	 * 获取指令处理器
	 * 
	 * @return
	 */
	public Processor<T> getProcessor();
}
