package com.amith.test.domain;

import static org.junit.Assert.*;

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
		assertEquals(child.obtainParent(), organization);
		assertTrue(organization.obtainChildRen().contains(child));
		assertEquals(2, getOrganizationDataQuantity());
		removeOrganization(organization);
		removeOrganization(child);
	}
	
	@Test
	public void testHaveChildren() {
		Organization organization = instanceOrganization();
		assertFalse(organization.haveChildren());
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertTrue(organization.haveChildren());
		removeOrganization(organization);
		removeOrganization(child);
	}
	
	@Test
	public void testObtainParent() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertEquals(child.obtainParent(), organization);
		removeOrganization(organization);
		removeOrganization(child);
	}
	
	@Test
	public void testObtainAllParent() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertEquals(1, child.obtainAllParent().size());
		Organization child2 = new Organization(ORGANIZATION_NAME2);
		child.createChild(child2);
		assertEquals(2, child2.obtainAllParent().size());
		removeOrganization(organization);
		removeOrganization(child);
		removeOrganization(child2);
	}
	
	@Test
	public void testObtainChildRen() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertTrue(organization.obtainChildRen().contains(child));
		assertEquals(1, organization.obtainChildRen().size());
		Organization child2 = new Organization(ORGANIZATION_NAME2);
		child.createChild(child2);
		assertFalse(organization.obtainChildRen().contains(child2));
		removeOrganization(organization);
		removeOrganization(child);
		removeOrganization(child2);
	}
	
	@Test
	public void testObtainAllChildRen() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertTrue(organization.obtainAllChildRen().contains(child));
		assertEquals(1, organization.obtainAllChildRen().size());
		Organization child2 = new Organization(ORGANIZATION_NAME2);
		child.createChild(child2);
		assertTrue(organization.obtainAllChildRen().contains(child2));
		assertEquals(2, organization.obtainAllChildRen().size());
		removeOrganization(organization);
		removeOrganization(child);
		removeOrganization(child2);
	}
	
}
