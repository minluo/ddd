package com.amith.jdbc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.amith.domain.Entity;
import com.amith.domain.EntityRepository;
import com.amith.query.QueryObject;

public class AbstractEntityRepository implements EntityRepository {

	@Override
	public <T extends Entity> T save(T entity) {
		return null;
	}

	@Override
	public void remove(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends Entity> T get(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> List<T> findAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> List<T> findByNameQuery(String queryName, Object[] params, Class<T> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> List<T> findByNameQuery(String queryName, Map<String, Object> params, Class<T> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> List<T> find(QueryObject queryObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> T getSingleResult(QueryObject queryObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> List<T> find(String queryString, Object[] params, Class<T> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> List<T> find(String queryString, Map<String, Object> params, Class<T> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
