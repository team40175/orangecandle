package com.orangecandle.test.filter;

import static org.junit.Assert.fail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.orangecandle.Actuator;
import com.orangecandle.controller.UserController;
import com.orangecandle.filter.CorsFilter;

import static org.mockito.BDDMockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebConfig.class })
public class CorsFilterTest {
	@Autowired
	  private WebApplicationContext context;

	  @Autowired
	  private CorsFilter springSecurityFilterChain;
	  private MockMvc mvc;
	   
	  @Before
	  public void setup() {
	      mvc = MockMvcBuilders
	              .webAppContextSetup(context)
	              .addFilters(springSecurityFilterChain)
	              .build();
	      
	  }

	@Test
	public void doFilterOnHttpServletResponseTest() throws IOException, ServletException {
		MockFilterChain mockChain = new MockFilterChain();
	    MockHttpServletRequest req = new MockHttpServletRequest();
	    HttpServletResponse res = mock(HttpServletResponse.class);

		springSecurityFilterChain.doFilter(req, res, mockChain);
		
	    verify(res).addHeader("Access-Control-Allow-Origin", "*");
	}
	//@Test
	public void doFilterOnNotHttpServletResponseTest() throws IOException, ServletException{
		MockFilterChain mockChain = new MockFilterChain();
		ServletResponse res = mock(ServletResponse.class);
		ServletRequest req = mock(ServletRequest.class);
		
		springSecurityFilterChain.doFilter(req, res, mockChain);

	}
}
