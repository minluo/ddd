package com.amith.query.criterion;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.amith.query.QueryCriterion;
import com.amith.query.QueryException;

/**
 * 空条件
 * 
 * @author amith
 * 
 */
public class IsNullCriterion implements QueryCriterion {

	private String propName;

	public IsNullCriterion(String propName) {
		if (StringUtils.isEmpty(propName)) {
			throw new QueryException("IsNullCriterion propName is null!");
		}
		this.propName = propName;
	}

	public String getPropName() {
		return propName;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EqCriterion)) {
			return false;
		}
		EqCriterion castOther = (EqCriterion) obj;
		return new EqualsBuilder().append(this.getPropName(), castOther.getPropName()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getPropName()).toHashCode();
	}

	@Override
	public String toString() {
		return getPropName();
	}
	
}
