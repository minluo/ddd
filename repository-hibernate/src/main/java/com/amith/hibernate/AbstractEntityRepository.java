package com.amith.hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amith.domain.Entity;
import com.amith.domain.EntityRepository;
import com.amith.hibernate.query.internal.QueryTranslator;
import com.amith.query.QueryObject;

/**
 * domain层仓储接口的Hibernate实现
 * 
 * @author amith
 * 
 */
@SuppressWarnings("unchecked")
public abstract class AbstractEntityRepository implements EntityRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntityRepository.class);

	protected abstract Session getSession();

	@Override
	public <T extends Entity> T save(T entity) {
		getSession().save(entity);
		LOGGER.info("create a entity: " + entity.getClass() + "/" + entity.getId() + ".");
		return entity;
	}

	@Override
	public void remove(Entity entity) {
		getSession().delete(entity);
		LOGGER.info("remove a entity: " + entity.getClass() + "/" + entity.getId() + ".");
	}
	
	@Override
	public void update(Entity entity) {
		getSession().update(entity);
		LOGGER.info("update a entity: " + entity.getClass() + "/" + entity.getId() + ".");
	}
	
	@Override
	public <T extends Entity> T get(Class<T> clazz, Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	@Override
	public <T extends Entity> List<T> findAll(Class<T> clazz) {
		return getSession().createCriteria(clazz).list();
	}

	@Override
	public <T extends Entity> List<T> findByNameQuery(String queryName, Object[] params, Class<T> resultClass) {
		Query query = getSession().getNamedQuery(queryName);
		for (int i = 0; i < params.length; i++) {
			query = query.setParameter(i, params[i]);
		}
		return query.list();
	}

	@Override
	public <T extends Entity> List<T> findByNameQuery(String queryName, Map<String, Object> params, Class<T> resultClass) {
		Query query = getSession().getNamedQuery(queryName);
		for (String key : params.keySet()) {
			query = query.setParameter(key, params.get(key));
		}
		return query.list();
	}
	
	@Override
	public <T  extends Entity> List<T> find(QueryObject queryObject) {
		QueryTranslator translator = new QueryTranslator(queryObject);
		String queryString = translator.getQueryString();
		List<Object> params = translator.getParams();
		Query query = getSession().createQuery(queryString);
		for (int i = 0, paramLength = params.size(); i < paramLength; i++) {
			query.setParameter(i, params.get(i));
		}
		query.setFirstResult(queryObject.getFirstResult());
		if (queryObject.getMaxResults() > 0) {
			query.setMaxResults(queryObject.getMaxResults());
		}
		return query.list();
	}

	@Override
	public <T extends Entity> T getSingleResult(QueryObject queryObject) {
		List<T> list = find(queryObject);
		return list.isEmpty() ? null : list.get(0);
	}
	
	@Override
	public <T extends Entity> List<T> find(String queryString, Object[] params, Class<T> resultClass) {
		Query query = getSession().createQuery(queryString);
		for (int i = 0; i < params.length; i++) {
			query = query.setParameter(i, params[i]);
		}
		return query.list();
	}
	
	@Override
	public <T extends Entity> List<T> find(String queryString, Map<String, Object> params, Class<T> resultClass) {
		Query query = getSession().createQuery(queryString);
		for (String key : params.keySet()) {
			query = query.setParameter(key, params.get(key));
		}
		return query.list();
	}
}
