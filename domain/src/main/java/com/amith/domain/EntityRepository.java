package com.amith.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 仓储访问接口。用于存取和查询数据库的实体。
 * @author amith
 *
 */
public interface EntityRepository {

	/**
	 * 将实体保存到仓储
	 * @param entity 要存储的实体
	 * @return
	 */
	<T extends Entity> T save(T entity);
	
	/**
	 * 将实体从仓储中删除
	 * @param entity 要删除的实体
	 */
	void remove(Entity entity);
	
	/**
	 * 将实体更新到仓储
	 * @param entity
	 */
	void update(Entity entity);
	
	/**
	 * 从仓储获取指定类型、指定ID的实体
	 * @param <T> 实体类型
	 * @param entity 实体的类
	 * @param id 实体标识
	 * @return 一个实体实例
	 */
	<T extends Entity> T get(Class<T> clazz, Serializable id);
	
	/**
	 * 查找指定类型的所以实体
	 * @param <T> 实体类型
	 * @param clazz 实体的类
	 * @return 符合条件的实体集合
	 */
	<T extends Entity> List<T> findAll(Class<T> clazz);
	
	/**
	 * 根据命名查询和指定参数从仓储查询符合条件的结果
	 * @param <T> 元素类型
	 * @param queryName 命名查询的名字
	 * @param params 查询参数
	 * @param resultClass 目标对象类
	 * @return 符合查询条件的实体集合
	 */
	<T> List<T> findByNameQuery(String queryName, Object[] params, Class<T> resultClass);

	/**
	 * 根据命名查询和指定参数从仓储查询符合条件的结果
	 * @param <T> 元素类型
	 * @param queryName 命名查询的名字
	 * @param params 查询参数
	 * @param resultClass 目标对象类
	 * @return 符合查询条件的实体集合
	 */
	<T> List<T> findByNameQuery(String queryName, Map<String, Object> params, Class<T> resultClass);
	
}
