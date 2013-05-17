package com.amith.jdbc;

import java.util.List;
import java.util.Map;

import com.amith.domain.Entity;

public class EntityRepositoryJdbc extends AbstractEntityRepository {

	@Override
	public <T extends Entity> List<T> findByNameQuery(String queryName, Map<String, Object> params, Class<T> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> List<T> find(String queryString, Map<String, Object> params, Class<T> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
