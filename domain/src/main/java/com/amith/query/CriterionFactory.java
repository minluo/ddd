package com.amith.query;

import com.amith.query.criterion.EqCriterion;
import com.amith.query.criterion.GtCriterion;
import com.amith.query.criterion.IsNotNullCriterion;
import com.amith.query.criterion.IsNullCriterion;
import com.amith.query.criterion.LtCriterion;

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
	
	public static QueryCriterion gt(String propName, Comparable<?> value) {
		return new GtCriterion(propName, value);
	}

	public static QueryCriterion lt(String propName, Comparable<?> value) {
		return new LtCriterion(propName, value);
	}
	
	public static QueryCriterion isNull(String propName) {
		return new IsNullCriterion(propName);
	}
	
	public static QueryCriterion isNotNull(String propName) {
		return new IsNotNullCriterion(propName);
	}
	
	
}
