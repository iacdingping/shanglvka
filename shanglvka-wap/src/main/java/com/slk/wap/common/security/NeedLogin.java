package com.slk.wap.common.security;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要登陆的controller类
 * 可以标注在整个类上
 * 也可以标注到单个方法
 * @author "iacdp"
 * 
 */
@Target({ElementType.METHOD, ElementType.TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface NeedLogin {
	ResultType value() default ResultType.page;
	String message() default "无效登陆";
	String loginUrl() default "/uc/login";
	String noLloginUrl() default "";
	String redirectKey() default "redirectUrl";
}
