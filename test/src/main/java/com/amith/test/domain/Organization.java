package com.amith.test.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@NamedQuery(name = "findByRightValueGreaterThan", query = "SELECT o FROM Organization o WHERE o.rightValue > ?"),
	@NamedQuery(name = "findElementParent", query = "SELECT o FROM Organization o WHERE o.leftValue < ? AND o.rightValue > ? AND o.level = ?"),
	@NamedQuery(name = "findElementAllParent", query = "SELECT o FROM Organization o WHERE o.leftValue < ? AND o.rightValue > ? "),
	@NamedQuery(name = "findElementChildRen", query = "SELECT o FROM Organization o WHERE o.leftValue > ? AND o.rightValue < ? AND o.level = ?"),
	@NamedQuery(name = "findElementAllChildRen", query = "SELECT o FROM Organization o WHERE o.leftValue > ? AND o.rightValue < ? ")
})
public class Organization extends AggregateRootEntity {

	private static final long serialVersionUID = 1L;

	private String name;

	private int level;

	@Column(name = "left_value")
	private Integer leftValue;

	@Column(name = "right_value")
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

	public void createChild2(Organization child) {
		int right = getRightValue() - 1;
		List<Organization> organizations = getRepository().find(QueryObject.create(Organization.class).gt("rightValue", right));
		for (Organization each : organizations) {
			each.setRightValue(each.getRightValue() + 2);
			each.save();
		}
		organizations = getRepository().find(QueryObject.create(Organization.class).gt("leftValue", right));
		for (Organization each : organizations) {
			each.setLeftValue(each.getLeftValue() + 2);
			each.save();
		}
		child.setLeftValue(right + 1);
		child.setRightValue(right + 2);
		child.setLevel(getLevel() + 1);
		child.save();
	}
	
	public boolean haveChildren() {
		return getRightValue() - getLeftValue() > 1;
	}
	
	@Transient
	public Organization getParent() {
		List<Organization> list = getRepository().findByNameQuery("findElementParent", new Object[] { getLeftValue(), getRightValue(), getLevel() - 1 }, Organization.class);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Transient
	public Organization getParent2() {
		List<Organization> list = getRepository().find(QueryObject.create(Organization.class).lt("leftValue", getLeftValue()).gt("rightValue", getRightValue()).eq("level", getLevel() - 1));
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Transient
	public List<Organization> getAllParent() {
		return getRepository().findByNameQuery("findElementAllParent", new Object[] { getLeftValue(), getRightValue() }, Organization.class);
	}
	
	@Transient
	public List<Organization> getAllParent2() {
		return getRepository().find(QueryObject.create(Organization.class).lt("leftValue", getLeftValue()).gt("rightValue", getRightValue()));
	}
	
	@Transient
	public List<Organization> getChildRen() {
		return getRepository().findByNameQuery("findElementChildRen", new Object[] { getLeftValue(), getRightValue(), getLevel() + 1 }, Organization.class);
	}
	
	@Transient
	public List<Organization> getChildRen2() {
		return getRepository().find(QueryObject.create(Organization.class).lt("rightValue", getRightValue()).gt("leftValue", getLeftValue()).eq("level", getLevel() + 1));
	}
	
	@Transient
	public List<Organization> getAllChildRen() {
		return getRepository().findByNameQuery("findElementAllChildRen", new Object[] { getLeftValue(), getRightValue() }, Organization.class);
	}
	
	@Transient
	public List<Organization> getAllChildRen2() {
		return getRepository().find(QueryObject.create(Organization.class).lt("rightValue", getRightValue()).gt("leftValue", getLeftValue()));
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

	public Integer getLeftValue() {
		return leftValue;
	}

	public void setLeftValue(Integer leftValue) {
		this.leftValue = leftValue;
	}

	public Integer getRightValue() {
		return rightValue;
	}

	public void setRightValue(Integer rightValue) {
		this.rightValue = rightValue;
	}

}
