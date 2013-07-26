package com.amith.query;

import java.lang.reflect.Field;
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

	private int firstResult;
	private int maxResults;

	public static <T extends Entity> QueryObject create(Class<T> entityClass) {
		return new QueryObject(entityClass).initCommonQuery();
	}

	private QueryObject(Class entityClass) {
		this.entityClass = entityClass;
	}

	public QueryObject eq(String propName, Object value) {
		addCriterion(CriterionFactory.eq(propName, value));
		return this;
	}

	public QueryObject gt(String propName, Comparable<?> value) {
		addCriterion(CriterionFactory.gt(propName, value));
		return this;
	}

	public QueryObject lt(String propName, Comparable<?> value) {
		addCriterion(CriterionFactory.lt(propName, value));
		return this;
	}

	public QueryObject isNull(String propName) {
		addCriterion(CriterionFactory.isNull(propName));
		return this;
	}

	public QueryObject isNotNull(String propName) {
		addCriterion(CriterionFactory.isNotNull(propName));
		return this;
	}

	// 为公共查询条件留入口
	private QueryObject initCommonQuery() {
		QueryCriterion criterion = QueryObjectExtend.getCriterion();
		if (isNeedAddQueryCriterion(criterion)) {
			addCriterion(criterion);
			QueryObjectExtend.cleanCriterion();
		}
		return this;
	}

	private boolean isNeedAddQueryCriterion(QueryCriterion criterion) {
		if (criterion != null) {
			for (Field each : entityClass.getSuperclass().getDeclaredFields()) {
				if (criterion.getPropName().equals(getFieldName(each.toGenericString()))) {
					return true;
				}
			}
		}
		return false;
	}

	private String getFieldName(String fieldName) {
		return fieldName.substring(fieldName.lastIndexOf(".") + 1);
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

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

}
