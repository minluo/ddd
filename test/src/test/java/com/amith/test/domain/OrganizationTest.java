package com.amith.test.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amith.test.AbstractIntegrationTest;

public class OrganizationTest extends AbstractIntegrationTest {

	@Test
	public void testFindAll() {
		Organization organization = instanceOrganization();
		assertEquals(1, Organization.findAll().size());
		removeOrganization(organization);
	}
	
	@Test
	public void testFindByName() {
		Organization organization = instanceOrganization();
		assertEquals(1, Organization.findByName(ORGANIZATION_NAME).size());
		removeOrganization(organization);
	}
	
	@Test
	public void testFindByName2() {
		Organization organization = instanceOrganization();
		assertEquals(1, Organization.findByName2(ORGANIZATION_NAME).size());
		removeOrganization(organization);
	}
	
	@Test
	public void testCreateChild() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertEquals(2, getOrganizationDataQuantity());
		removeOrganization(organization);
		removeOrganization(child);
	}
	
}
