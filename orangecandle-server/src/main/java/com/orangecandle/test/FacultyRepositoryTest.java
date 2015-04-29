package com.orangecandle.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FacultyRepositoryTest {
	@PersistenceContext private EntityManager em;
	@Autowired private com.orangecandle.repository.Faculty repository;
	
	@Before
	public void setup(){
		
	}
	private void flushTestFaculty() {
		
	}

}
