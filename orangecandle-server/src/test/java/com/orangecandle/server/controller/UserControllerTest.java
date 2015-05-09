package com.orangecandle.server.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.orangecandle.controller.UserController;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UserController.class })
@WebAppConfiguration
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;
    private MockHttpServletResponse res;
    @Mock private com.orangecandle.repository.User repository;

	private MockMvc mockMvc;

	@Before
	public void before() {
		repository=Mockito.mock(com.orangecandle.repository.User.class);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        res = new MockHttpServletResponse();
	}

	@Test
	public void testAddingUserNullRepository() throws Exception {
		repository=null;
		String name="jale";
		
		

	}

	
	

}
