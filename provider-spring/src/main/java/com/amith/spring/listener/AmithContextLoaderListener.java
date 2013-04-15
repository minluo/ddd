package com.amith.spring.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.amith.domain.InstanceFactory;
import com.amith.spring.SpringInstanceProvider;

/**
 * 重写ContextLoaderListener,添加上ddd的实例提供者。注册到web.xml
 * @author amith
 *
 */
public class AmithContextLoaderListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		SpringInstanceProvider springInstanceProvider = new SpringInstanceProvider(getCurrentWebApplicationContext());
		InstanceFactory.registerInstanceProvider(springInstanceProvider);
	}

	
}
