package com.amith.domain;

import java.util.HashSet;
import java.util.Set;

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
	
	@Test
	public void testEntityIdentically() {
		Set<AbstractEntity> abstractEntities = new HashSet<AbstractEntity>();
		abstractEntities.add(new AbstractEntity() {});
		abstractEntities.add(new AbstractEntity() {});
		assertEquals(2, abstractEntities.size());
		
		Set<TestEntity> entities = new HashSet<TestEntity>();
		entities.add(new TestEntity("a"));
		entities.add(new TestEntity("a"));
		assertEquals(1, entities.size());
	}
	
}
