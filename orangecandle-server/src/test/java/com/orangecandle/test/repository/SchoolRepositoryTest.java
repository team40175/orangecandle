package com.orangecandle.test.repository;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.orangecandle.domain.Faculty;

public class SchoolRepositoryTest {
	@PersistenceContext private EntityManager em;
	@Autowired private com.orangecandle.repository.School repository;
	@Autowired
	private Faculty[] fac;

	@Before
	public void setup(){

	}
	private void flushTestSchool() {
		
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
