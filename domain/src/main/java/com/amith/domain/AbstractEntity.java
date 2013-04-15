package com.amith.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

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

	public String getId() {
		return id;
	}

	@Id
	@Column(name = "ID")
	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	@Version
	@Column(name = "VERSION")
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
	public abstract int hashCode();
	
	@Override
	public abstract boolean equals(Object other);
	
	@Override
	public abstract String toString();
	
}
