package com.orangecandle.server.repository;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
@CustomTestAnnotation

public class ConstraintRepositoryTest {
	@Mock private EntityManager em;
	@InjectMocks private com.orangecandle.repository.Constraint repository;
	
	@Before
	public void setup(){
		em=Mockito.mock(EntityManager.class);
		repository=Mockito.mock(com.orangecandle.repository.Constraint.class);
	}
	private void flushTestConstraint() {
		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
