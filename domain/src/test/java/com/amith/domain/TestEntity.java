package com.amith.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 测试实体
 * 
 * @author amith
 * 
 */
public class TestEntity extends AbstractEntity {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public TestEntity(String text) {
		this.text = text;
	}
	
	public TestEntity() {
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TestEntity)) {
			return false;
		}
		TestEntity that = (TestEntity) other;
		return new EqualsBuilder().append(getText(), that.getText()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getText()).hashCode();
	}
}
