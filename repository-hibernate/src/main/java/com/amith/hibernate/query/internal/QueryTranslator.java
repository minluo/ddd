package com.amith.hibernate.query.internal;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.amith.query.QueryCriterion;
import com.amith.query.QueryObject;
import com.amith.query.criterion.EqCriterion;
import com.amith.query.criterion.GtCriterion;
import com.amith.query.criterion.LtCriterion;

/**
 * 查询翻译器
 * 
 * @author amith
 * 
 */
public class QueryTranslator {

	private QueryObject queryObject;

	private List<String> criterias = new ArrayList<String>();
	private List<Object> params = new ArrayList<Object>();

	private StringBuilder queryString = new StringBuilder();

	public QueryTranslator(QueryObject queryObject) {
		this.queryObject = queryObject;
		assembleQueryString();
	}

	/**
	 * 获取查询语句
	 * 
	 * @return
	 */
	public String getQueryString() {
		return queryString.toString();
	}

	/**
	 * 获取查询参数
	 * 
	 * @return
	 */
	public List<Object> getParams() {
		return params;
	}

	/**
	 * 组装查询语句
	 */
	private void assembleQueryString() {
		queryString.append("select distinct(o) from ").append(queryObject.getEntityClass().getName()).append(" as o");
		queryString.append(getWhereClause());
	}

	private String getWhereClause() {
		if (queryObject.getCriterions().isEmpty()) {
			return "";
		}
		for (QueryCriterion each : queryObject.getCriterions()) {
			criterias.add(processCriterion(each));
		}
		if (criterias.isEmpty()) {
			return "";
		}
		return " where " + StringUtils.join(criterias, " and ");
	}

	private String processCriterion(QueryCriterion queryCriterion) {

		if (queryCriterion instanceof EqCriterion) {
			EqCriterion eqCriterion = (EqCriterion) queryCriterion;
			params.add(eqCriterion.getValue());
			return "o." + eqCriterion.getPropName() + " = ?";
		} else if (queryCriterion instanceof GtCriterion) {
			GtCriterion gtCriterion = (GtCriterion) queryCriterion;
			params.add(gtCriterion.getValue());
			return "o." + gtCriterion.getPropName() + " > ?";
		} else if (queryCriterion instanceof LtCriterion) {
			LtCriterion ltCriterion = (LtCriterion) queryCriterion;
			params.add(ltCriterion.getValue());
			return "o." + ltCriterion.getPropName() + " < ?";
		} 

		throw new IllegalStateException("Not support criterion type: " + queryCriterion.getClass());
	}

}
