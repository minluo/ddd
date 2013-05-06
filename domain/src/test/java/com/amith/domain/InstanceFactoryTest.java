package com.amith.domain;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@SuppressWarnings("serial")
public class InstanceFactoryTest {
	
	private InstanceProvider instanceProvider;

	@Before
	public void setUp() throws Exception {
		instanceProvider = mock(InstanceProvider.class);
		InstanceFactory.registerInstanceProvider(instanceProvider);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		Entity entity = new AbstractEntity() {
			
			@Override
			public String toString() {
				return null;
			}
			
			@Override
			public int hashCode() {
				return 0;
			}
			
			@Override
			public boolean equals(Object other) {
				return this == other;
			}
		};
		stub(instanceProvider.getInstance(Entity.class)).toReturn(entity);
		assertEquals(entity, InstanceFactory.getInstance(Entity.class));
		assertNotNull(entity.getId());
	}
}
