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
		removeOrganization(organization, child);
	}
	
	@Test
	public void testCreateChild2() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild2(child);
		assertEquals(child.obtainParent(), organization);
		assertTrue(organization.obtainChildRen().contains(child));
		assertEquals(2, getOrganizationDataQuantity());
		removeOrganization(organization, child);
	}
	
	@Test
	public void testHaveChildren() {
		Organization organization = instanceOrganization();
		assertFalse(organization.haveChildren());
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertTrue(organization.haveChildren());
		removeOrganization(organization, child);
	}
	
	@Test
	public void testObtainParent() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertEquals(child.obtainParent(), organization);
		removeOrganization(organization, child);
	}
	
	@Test
	public void testObtainParent2() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertEquals(child.obtainParent2(), organization);
		removeOrganization(organization, child);
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
		removeOrganization(organization, child, child2);
	}
	
	@Test
	public void testObtainAllParent2() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertEquals(1, child.obtainAllParent2().size());
		Organization child2 = new Organization(ORGANIZATION_NAME2);
		child.createChild(child2);
		assertEquals(2, child2.obtainAllParent2().size());
		removeOrganization(organization, child, child2);
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
		removeOrganization(organization, child, child2);
	}
	
	@Test
	public void testObtainChildRen2() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertTrue(organization.obtainChildRen2().contains(child));
		assertEquals(1, organization.obtainChildRen2().size());
		Organization child2 = new Organization(ORGANIZATION_NAME2);
		child.createChild(child2);
		assertFalse(organization.obtainChildRen2().contains(child2));
		removeOrganization(organization, child, child2);
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
		removeOrganization(organization, child, child2);
	}
	
	@Test
	public void testObtainAllChildRen2() {
		Organization organization = instanceOrganization();
		Organization child = new Organization(ORGANIZATION_NAME2);
		organization.createChild(child);
		assertTrue(organization.obtainAllChildRen2().contains(child));
		assertEquals(1, organization.obtainAllChildRen2().size());
		Organization child2 = new Organization(ORGANIZATION_NAME2);
		child.createChild(child2);
		assertTrue(organization.obtainAllChildRen2().contains(child2));
		assertEquals(2, organization.obtainAllChildRen2().size());
		removeOrganization(organization, child, child2);
	}
	
}
