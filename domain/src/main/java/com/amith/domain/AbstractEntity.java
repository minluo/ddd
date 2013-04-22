package com.amith.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 抽象实体类，可作为所有领域实体的基类，提供ID和乐观锁版本属性。
 * 
 * @author amith
 * 
 */
@MappedSuperclass
public abstract class AbstractEntity implements Entity {

	private String id = createUUID();

	private int version;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	private static EntityRepository repository;

	public static EntityRepository getRepository() {
		if (repository == null) {
			repository = InstanceFactory.getInstance(EntityRepository.class);
		}
		return repository;
	}

	public static void setRepository(EntityRepository repository) {
		AbstractEntity.repository = repository;
	}

	public void save() {
		getRepository().save(this);
	}

	public void remove() {
		getRepository().remove(this);
	}

	public static <T extends Entity> T get(Class<T> clazz, Serializable id) {
		return getRepository().get(clazz, id);
	}

	public static <T extends Entity> List<T> findAll(Class<T> clazz) {
		return getRepository().findAll(clazz);
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
