package com.amith.test.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;
import com.amith.domain.Entity;
import com.amith.test.AbstractIntegrationTest;
import com.amith.test.domain.Organization;

public class HibernateRepositoryTest extends AbstractIntegrationTest {

	@Test
	public void testSaveAndRemove() {
		Organization organization = instanceOrganization();
		assertEquals(1, Organization.findAll(Organization.class).size());
		organization.remove();
		assertEquals(0, Organization.findAll(Organization.class).size());
	}

	public void update(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public <T extends Entity> T get(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Entity> List<T> findAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findByNameQuery(String queryName, Object[] params, Class<T> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findByNameQuery(String queryName, Map<String, Object> params, Class<T> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	private Organization createOrganization() {
		return new Organization("amith");
	}
	
	private Organization instanceOrganization() {
		Organization organization = createOrganization();
		organization.save();
		return organization;
	}
	
}
