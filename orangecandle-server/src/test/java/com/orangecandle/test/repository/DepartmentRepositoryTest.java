package com.orangecandle.test.repository;

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

public class DepartmentRepositoryTest {
	@Mock private EntityManager em;
	@InjectMocks private com.orangecandle.repository.Department repository;
	
	@Before
	public void setup(){
		em=Mockito.mock(EntityManager.class);
		repository=Mockito.mock(com.orangecandle.repository.Department.class);
	}
	private void flushTestDepartment() {
		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
