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

public class FacultyRepositoryTest {
	@Mock private EntityManager em;
	@InjectMocks private com.orangecandle.repository.Faculty repository;
	
	@Before
	public void setup(){
		em=Mockito.mock(EntityManager.class);
		repository=Mockito.mock(com.orangecandle.repository.Faculty.class);
	}
	private void flushTestFaculty() {
		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
