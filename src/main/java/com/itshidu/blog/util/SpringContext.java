package com.itshidu.blog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringContext {
	
	private static ApplicationContext ctx;
	
	@Autowired
	public void set(ApplicationContext a) {
		ctx=a;
	}

	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
}
