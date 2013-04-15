package com.amith.domain;

import com.amith.InstanceProviderNotRegisterException;
import com.amith.IocException;
import com.amith.IocInstanceNotFoundException;

/**
 * 实例工厂类。通过它可以获得其管理的类的实例。 InstanceFactory向客户代码隐藏了IoC工厂的具体实现。在后台，它通过
 * InstanceProvider策略接口，允许选择不同的IoC工厂，例如Spring， Google Guice和TapestryIoC等等。
 * IoC工厂应该在应用程序启动时装配好，也就是把初始化好的InstanceProvider
 * 实现类提供给InstanceFactory。对于web应用来说，最佳的初始化方式是创
 * 建一个Servlet过滤器或监听器，并部署到web.xml里面；对普通java应用程
 * 序来说，最佳的初始化位置是在main()函数里面；对于单元测试，最佳的初始 化位置是setUp()方法内部。
 * 
 * @author amith
 * 
 */
public class InstanceFactory {

	private static InstanceProvider instanceProvider;

	/**
	 * 注册实例提供者
	 * @param externalInstanceProvider 外部实现InstanceProvider接口的实例
	 */
	public static void registerInstanceProvider(InstanceProvider externalInstanceProvider) {
		instanceProvider = externalInstanceProvider;
	}

	/**
	 * 获取指定类型对象的实例。如果IoC容器没配置好或者IoC容器中找不到该类型的实例则抛出异常。
	 * @param <T> 对象的类型
	 * @param beanClass 对象的类
	 * @return 类型为T的对象实例
	 */
	public static <T> T getInstance(Class<T> beanClass) {
		return getInstance(beanClass, null);
	}
	
	/**
	 * 获取指定类型的对象实例。如果IoC容器没配置好或者IoC容器中找不到该实例则抛出异常。
	 * @param <T> 对象的类型
	 * @param beanClass 对象的类
	 * @param beanName 实现类在容器中配置的名字
	 * @return 类型为T的对象实例
	 */
	public static <T> T getInstance(Class<T> beanClass, String beanName) {
		T result = null;
		checkInstanceProviderExistence();
		try {
			if (beanName == null || ("").equals(beanName)) {
				result = getInstanceProvider().getInstance(beanClass);
			} else {
				result = getInstanceProvider().getInstance(beanClass, beanName);
			}
		} catch (Exception e) {
			throw new IocException("The Ioc instance abnormal", e);
		}
		if (result == null) {
			throw new IocInstanceNotFoundException("There's not bean of type '" + beanClass + "' exists in IoC container!");
		}
		return result;
	}

	private static void checkInstanceProviderExistence() {
		if (instanceProvider == null) {
			throw new InstanceProviderNotRegisterException("IOC instance provider is not registered");
		}
	}

	/**
	 * 获取实例提供者
	 * @return 实例提供者的实现类
	 */
	public static InstanceProvider getInstanceProvider() {
		return instanceProvider;
	}
	
}
