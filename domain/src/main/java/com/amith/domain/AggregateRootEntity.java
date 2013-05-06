package com.amith.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.MappedSuperclass;

/**
 * 聚合根实体,具有持久化能力。
 * @author amith
 *
 */
@MappedSuperclass
public abstract class AggregateRootEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private static EntityRepository repository;

	public static EntityRepository getRepository() {
		if (repository == null) {
			repository = InstanceFactory.getInstance(EntityRepository.class);
		}
		return repository;
	}

	public static void setRepository(EntityRepository repository) {
		AggregateRootEntity.repository = repository;
	}

	public void save() {
		getRepository().save(this);
	}

	public void remove() {
		getRepository().remove(this);
	}
	
	public void update() {
		getRepository().update(this);
	}

	public static <T extends Entity> T get(Class<T> clazz, Serializable id) {
		return getRepository().get(clazz, id);
	}

	public static <T extends Entity> List<T> findAll(Class<T> clazz) {
		return getRepository().findAll(clazz);
	}

}
