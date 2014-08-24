package com.slk.core;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy(false)
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext context;

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	}

	public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
 
	public static <T> T getBean(Class<T> requiredType){
        return context.getBean(requiredType);
    }
     
    public static String getMessage(String key){
        return context.getMessage(key, null, Locale.getDefault());
    }
}
