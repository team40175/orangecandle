package com.orangecandle.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ConstraintRepositoryTest {
	@PersistenceContext private EntityManager em;
	@Autowired private com.orangecandle.repository.Constraint repository;
	
	@Before
	public void setup(){
		
	}
	private void flushTestConstraint() {
		
	}
}