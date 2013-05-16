package com.amith.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

import com.amith.domain.InstanceFactory;
import com.amith.spring.SpringInstanceProvider;
import com.amith.test.domain.Organization;


@SpringApplicationContext("/applicationContext.xml")
public abstract class AbstractIntegrationTest extends UnitilsJUnit4 {

	protected static final String ORGANIZATION_NAME = "amith";
	protected static final String ORGANIZATION_NAME2 = "amith2";
	
	@SpringApplicationContext
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() throws Exception {
		SpringInstanceProvider provider = new SpringInstanceProvider(applicationContext);
		InstanceFactory.registerInstanceProvider(provider);
	}
	
	@After
	public void tearDown() throws Exception {
		InstanceFactory.registerInstanceProvider(null);
	}

	private Organization createOrganization() {
		return new Organization(ORGANIZATION_NAME);
	}
	
	protected Organization instanceOrganization() {
		Organization organization = createOrganization();
		organization.setLeftValue(1);
		organization.setRightValue(2);
		organization.setLevel(0);
		organization.save();
		return organization;
	}
	
	protected void removeOrganization(Organization organization) {
		organization.remove();
	}
	
	protected int getOrganizationDataQuantity() {
		return Organization.findAll(Organization.class).size();
	}

}
