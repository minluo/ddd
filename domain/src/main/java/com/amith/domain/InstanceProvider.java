package com.amith.domain;

/**
 * 实例提供者接口。具有Ioc工厂的基本能力：提供某种指定类型(接口/类)的一个实例
 * @author amith
 *
 */
public interface InstanceProvider {

	/**
	 * 获取指定接口的实现类
	 * @param <T> 类型参数
	 * @param beanClass 实例类型
	 * @return 指定类型的实例
	 */
	<T> T getInstance(Class<T> beanClass);
	
	/**
	 * 根据beanName获取指定接口的实现类
	 * @param <T> 类型参数
	 * @param beanClass 实例类型
	 * @param beanName 指定类型的实例
	 * @return
	 */
	<T> T getInstance(Class<T> beanClass, String beanName);
}
