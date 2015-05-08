package com.orangecandle.test.repository;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
@CustomTestAnnotation
public class BuildingRepositoryTest {
	@PersistenceContext private EntityManager em;
	@Autowired private com.orangecandle.repository.Building repository;
	
	@Before
	public void setup(){
		
	}
	private void flushTestBuilding() {
		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
