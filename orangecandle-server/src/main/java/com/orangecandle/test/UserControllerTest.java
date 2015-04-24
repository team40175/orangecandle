package com.orangecandle.test;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.orangecandle.controller.UserController;
import com.orangecandle.domain.User;

public class UserControllerTest {

	@Autowired com.orangecandle.repository.User repository;
	@Autowired HttpServletResponse res;
	UserController controller;
	private User user,userTwo,userThree,userFour;
	@Before
	public void before() {
		controller=new UserController();
		user.setUserName("ay");
		userTwo.setUserName("ay");
		userThree.setUserName("aydın");
		userFour.setUserName("serenay");
		
	}
	
 
	@Test
	public void testAddingUser() throws IOException {
		UserController controller2=new UserController();
		
		controller.addingUser(user.getUserName(), res);
		controller2.addingUser(userTwo.getUserName(), res);
		assertNull(controller);
		assertEquals(controller,controller2);
	}
	@Test
	public void testFindAllUsers() throws IOException{
		//
	}

}
