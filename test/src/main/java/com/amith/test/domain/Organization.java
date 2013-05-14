package com.amith.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.amith.domain.AggregateRootEntity;

/**
 * 组织机构实体
 * @author amith
 *
 */
@Entity
@Table(name = "organizations")
public class Organization extends AggregateRootEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private int level;
	
	private Integer leftValue;
	
	private Integer rightValue;

	public Organization(String name) {
		this.name = name;
	}

	public Organization() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "left_value")
	public Integer getLeftValue() {
		return leftValue;
	}

	public void setLeftValue(Integer leftValue) {
		this.leftValue = leftValue;
	}

	@Column(name = "right_value")
	public Integer getRightValue() {
		return rightValue;
	}

	public void setRightValue(Integer rightValue) {
		this.rightValue = rightValue;
	}
	
	
	
}
