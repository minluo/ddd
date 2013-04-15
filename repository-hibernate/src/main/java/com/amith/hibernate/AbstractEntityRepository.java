package com.amith.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amith.domain.Entity;
import com.amith.domain.EntityRepository;

/**
 * domain层仓储接口的Hibernate实现
 * @author amith
 *
 */
@SuppressWarnings("unchecked")
public abstract class AbstractEntityRepository implements EntityRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntityRepository.class);
	
	protected abstract Session getSession();
	
	public <T extends Entity> T save(T entity) {
		getSession().save(entity);
		LOGGER.info("create a entity: " + entity.getClass() + "/" + entity.getId() + ".");
		return entity;
	}

	public void remove(Entity entity) {
		getSession().delete(entity);
		LOGGER.info("remove a entity: " + entity.getClass() + "/" + entity.getId() + ".");
	}

	public <T extends Entity> T get(Class<T> clazz, Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	public <T extends Entity> List<T> findAll(Class<T> clazz) {
		return getSession().createCriteria(clazz).list();
	}

}
