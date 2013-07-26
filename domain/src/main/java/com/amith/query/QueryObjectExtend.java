package com.amith.query;


/**
 * 查询对象扩展,主要考虑到一些公共的查询条件
 * 
 * @author amith
 * 
 */
public class QueryObjectExtend {

	private static final ThreadLocal<QueryCriterion> queryCriterion = new ThreadLocal<QueryCriterion>();
	
	public static void setCriterion(QueryCriterion criterion) {
		queryCriterion.set(criterion);
	}
	
	public static QueryCriterion getCriterion() {
		return queryCriterion.get();
	}
	
	public static void cleanCriterion() {
		queryCriterion.remove();
	}
}
