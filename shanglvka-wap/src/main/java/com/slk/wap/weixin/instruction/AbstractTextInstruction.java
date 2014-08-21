package com.slk.wap.weixin.instruction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public abstract class AbstractTextInstruction implements Instruction<HttpServletRequest> {
	
	protected Pattern pattern;
	
	@Override
	public boolean isStrictMatch() {
		return true;
	}
	
	@Override
	public Pattern getPattern() {
		if(pattern == null) {
			pattern = Pattern.compile(getRegular(), Pattern.CASE_INSENSITIVE);
		}
		return pattern;
	}
	
	public boolean matches(String instructionStr) {
		if(isStrictMatch()) {
			String upperInstruction = instructionStr.toUpperCase();
			String regular = ".*[\\||\\(]" + upperInstruction + "[\\||\\)].*";
			return getRegular().matches(regular);
		}
		
		Matcher matcher = this.getPattern().matcher(instructionStr);
		return matcher.find();
	}
	
}
