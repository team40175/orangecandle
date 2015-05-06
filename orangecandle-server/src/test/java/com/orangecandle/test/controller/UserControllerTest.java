package com.orangecandle.test.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.orangecandle.controller.UserController;
import com.orangecandle.domain.User;

public class UserControllerTest {

	@Autowired
	com.orangecandle.repository.User repository;
	@Autowired
	HttpServletResponse res;
	@Autowired
	UserController controller;
	private User user, userTwo, userThree, userFour;

	@Before
	public void before() {
//		WebMvcTestConfig.initMocks();
		repository =  Mockito.mock(com.orangecandle.repository.User.class);
		user=new User();
		userTwo=new User();
		userThree=new User();
		userFour=new User();
		
		user.setUserName("ay");
		userTwo.setUserName("ay");
		userThree.setUserName("aydın");
		userFour.setUserName("serenay");

//	    when(repository.getById(0)).thenReturn(user);

	}

	@Test
	public void testAddingUser() throws IOException {

		
	}

	@Test
	public void testFindAllUsers() throws IOException {
		//
	}
	

}
