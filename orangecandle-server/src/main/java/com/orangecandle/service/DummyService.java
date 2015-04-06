package com.orangecandle.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DummyService {
	@RequestMapping(value = "dummy")
	public void doDummyStuff(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		response.getWriter().write("Hi, i'm a dummy servlet!");
	}
}
