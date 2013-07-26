package com.amith.query;

/**
 * 查询规范接口
 * 
 * @author amith
 * 
 */
public interface QueryCriterion {

	/**
	 * 获取查询条件名称
	 * @return 查询条件名称
	 */
	String getPropName();
	
}
