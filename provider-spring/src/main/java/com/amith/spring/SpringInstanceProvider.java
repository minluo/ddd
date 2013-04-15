package com.amith.spring;

import org.springframework.context.ApplicationContext;

import com.amith.domain.InstanceProvider;

/**
 * 实例提供者接口的Spring实现
 * @author amith
 *
 */
@SuppressWarnings("unchecked")
public class SpringInstanceProvider implements InstanceProvider {

	private ApplicationContext applicationContext;
	
	public SpringInstanceProvider(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	public <T> T getInstance(Class<T> beanClass) {
		String[] beanNames = applicationContext.getBeanNamesForType(beanClass);
		if (beanNames.length == 0) {
			return null;
		}
		return (T) applicationContext.getBean(beanNames[0]);
	}

	public <T> T getInstance(Class<T> beanClass, String beanName) {
		return applicationContext.getBean(beanName, beanClass);
	}

}
