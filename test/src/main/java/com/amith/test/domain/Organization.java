package com.amith.test.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.amith.domain.AggregateRootEntity;
import com.amith.query.QueryObject;

/**
 * 组织机构实体
 * 
 * @author amith
 * 
 */
@Entity
@Table(name = "organizations")
@NamedQueries({ 
	@NamedQuery(name = "findAll", query = "SELECT o FROM Organization o"),
	@NamedQuery(name = "findByName", query = "SELECT o FROM Organization o WHERE o.name = ?"),
	@NamedQuery(name = "findByLeftValueGreaterThan", query = "SELECT o FROM Organization o WHERE o.leftValue > ?"),
	@NamedQuery(name = "findByRightValueGreaterThan", query = "SELECT o FROM Organization o WHERE o.rightValue > ?")
})
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

	public static List<Organization> findAll() {
		return getRepository().findByNameQuery("findAll", new Object[] {}, Organization.class);
	}

	public static List<Organization> findByName(String name) {
		return getRepository().findByNameQuery("findByName", new Object[] { name }, Organization.class);
	}

	public static List<Organization> findByName2(String name) {
		return getRepository().find(QueryObject.create(Organization.class).eq("name", name));
	}
	
	public void createChild(Organization child) {
		int right = getRightValue() - 1;
		List<Organization> organizations = getRepository().findByNameQuery("findByRightValueGreaterThan", new Object[] { right }, Organization.class);
		for (Organization each : organizations) {
			each.setRightValue(each.getRightValue() + 2);
			each.save();
		}
		organizations = getRepository().findByNameQuery("findByLeftValueGreaterThan", new Object[] { right }, Organization.class);
		for (Organization each : organizations) {
			each.setLeftValue(each.getLeftValue() + 2);
			each.save();
		}
		child.setLeftValue(right + 1);
		child.setRightValue(right + 2);
		child.setLevel(getLevel() + 1);
		child.save();
	}

	public Organization getParent() {
		
		return null;
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
