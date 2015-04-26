package com.orangecandle.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DepartmentRepositoryTest {
	@PersistenceContext private EntityManager em;
	@Autowired private com.orangecandle.repository.Department repository;
	
	@Before
	public void setup(){
		
	}
	private void flushTestDepartment() {
		
	}
}
