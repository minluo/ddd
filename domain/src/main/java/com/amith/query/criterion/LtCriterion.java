package com.amith.query.criterion;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.amith.query.QueryCriterion;
import com.amith.query.QueryException;

/**
 * 小于条件
 * 
 * @author amith
 * 
 */
public class LtCriterion implements QueryCriterion {

	private String propName;

	private Comparable<?> value;

	public LtCriterion(String propName, Comparable<?> value) {
		if (StringUtils.isEmpty(propName)) {
			throw new QueryException("GtCriterion propName is null!");
		}
		this.propName = propName;
		this.value = value;
	}

	public String getPropName() {
		return propName;
	}

	public Comparable<?> getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getPropName()).append(getValue()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof LtCriterion)) {
			return false;
		}
		LtCriterion castOther = (LtCriterion) obj;
		return new EqualsBuilder().append(getPropName(), castOther.getPropName()).append(getValue(), castOther.getValue()).isEquals();
	}

	@Override
	public String toString() {
		return getPropName() + " = " + getValue();
	}

}
