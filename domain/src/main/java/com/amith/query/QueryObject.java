package com.amith.query;

import java.util.HashSet;
import java.util.Set;

import com.amith.domain.Entity;


/**
 * 查询对象,用于组装条件
 * 
 * @author amith
 * 
 */
@SuppressWarnings("rawtypes")
public class QueryObject {

	private Class entityClass;
	
	private Set<QueryCriterion> criterions = new HashSet<QueryCriterion>();
	
	public static <T extends Entity> QueryObject create(Class<T> entityClass) {
		return new QueryObject(entityClass);
	}
	
	private QueryObject(Class entityClass) {
		this.entityClass = entityClass;
	}

	public QueryObject eq(String propName, Object value) {
		addCriterion(CriterionFactory.eq(propName, value));
		return this;
	}
	
	public Class getEntityClass() {
		return entityClass;
	}

	public Set<QueryCriterion> getCriterions() {
		return criterions;
	}

	private void addCriterion(QueryCriterion criterion) {
		criterions.add(criterion);
	}
	
}
