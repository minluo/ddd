package com.amith.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractEntityTest {

	@Test
	public void testEntityOverrideMethod() {
		AbstractEntity abstractEntity = new AbstractEntity() {};
		AbstractEntity abstractEntity2 = new AbstractEntity() {};
		assertFalse(abstractEntity.equals(abstractEntity2));
		
		TestEntity testEntity = new TestEntity();
		TestEntity testEntity2 = new TestEntity();
		assertTrue(testEntity.equals(testEntity2));
	}
	
}
