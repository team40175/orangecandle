package com.orangecandle.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;

import com.orangecandle.domain.User;

public class UserControllerTest {

	@Autowired com.orangecandle.repository.User repository;
	
	@Before
	public void fistly(){
		
	}
 
	@Test
	public void testAddingUser() {
		final User user=new User();
		user.setUserName("abdullah");
		final User userSecond=new User();
		userSecond.setUserName("abdullah");
		
	
	}

}
