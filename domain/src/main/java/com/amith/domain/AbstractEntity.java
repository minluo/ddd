package com.amith.domain;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 抽象实体类，提供ID和乐观锁版本属性。
 * 
 * @author amith
 * 
 */
@MappedSuperclass
public abstract class AbstractEntity implements Entity {

	private static final long serialVersionUID = 1L;

	private String id = createUUID();

	private int version;
	
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		if ("".equals(id)) {
			this.id = createUUID();
		} else {
			this.id = id;
		}
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	private String createUUID() {
		return UUID.randomUUID().toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).hashCode();
	}

	@Override
	public  boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AbstractEntity)) {
			return false;
		}
		AbstractEntity that = (AbstractEntity) other;
		return new EqualsBuilder().append(getId(), that.getId()).isEquals();
	}

	@Override
	public String toString() {
		return getId();
	}

}
