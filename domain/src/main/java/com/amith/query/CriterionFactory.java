package com.amith.query;

import com.amith.query.criterion.EqCriterion;

/**
 * 获取查询条件的工厂
 * 
 * @author amith
 * 
 */
public class CriterionFactory {

	private CriterionFactory() {}
	
	public static QueryCriterion eq(String propName, Object value) {
		return new EqCriterion(propName, value);
	}
	
}
