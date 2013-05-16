package com.amith.test.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amith.test.AbstractIntegrationTest;
import com.amith.test.domain.Organization;

public class HibernateRepositoryTest extends AbstractIntegrationTest {

	@Test
	public void testSave() {
		Organization organization = instanceOrganization();
		assertEquals(1, getOrganizationDataQuantity());
		removeOrganization(organization);
		assertEquals(0, getOrganizationDataQuantity());
	}

	@Test
	public void testRemove() {
		Organization organization = instanceOrganization();
		assertEquals(1, getOrganizationDataQuantity());
		organization.remove();
		assertEquals(0, getOrganizationDataQuantity());
	}
	
	@Test
	public void testUpdate() {
		Organization organization = instanceOrganization();
		assertEquals(1, getOrganizationDataQuantity());
		organization.setName(ORGANIZATION_NAME2);
		organization.update();
		assertEquals(1, getOrganizationDataQuantity());
		Organization updateOrganization = Organization.findAll(Organization.class).get(0);
		assertEquals(ORGANIZATION_NAME2, updateOrganization.getName());
		assertEquals(ORGANIZATION_NAME2, organization.getName());
		removeOrganization(organization);
	}

	@Test
	public void testUpdate2() {
		Organization organization = instanceOrganization();
		assertEquals(1, getOrganizationDataQuantity());
		organization.setName(ORGANIZATION_NAME2);
		organization.save();
		assertEquals(1, getOrganizationDataQuantity());
		Organization updateOrganization = Organization.findAll(Organization.class).get(0);
		assertEquals(ORGANIZATION_NAME2, updateOrganization.getName());
		assertEquals(ORGANIZATION_NAME2, organization.getName());
		removeOrganization(organization);
	}
	
	@Test
	public void testGet() {
		Organization organization = instanceOrganization();
		Organization organization2 = Organization.get(Organization.class, organization.getId());
		assertEquals(organization, organization2);
		removeOrganization(organization);
	}

	@Test
	public void testFindAll() {
		Organization organization = instanceOrganization();
		assertEquals(1, getOrganizationDataQuantity());
		Organization organization2 = instanceOrganization();
		assertEquals(2, getOrganizationDataQuantity());
		removeOrganization(organization);
		removeOrganization(organization2);
	}

	@Test
	public void testFindByNameQueryConditionParamIsList() {
		Organization organization = instanceOrganization();
		assertEquals(1, Organization.findAll().size());
		assertEquals(1, Organization.findByName(ORGANIZATION_NAME).size());
		removeOrganization(organization);
	}

	@Test
	public void testFindByNameQueryConditionParamIsMap() {
		
	}

}
