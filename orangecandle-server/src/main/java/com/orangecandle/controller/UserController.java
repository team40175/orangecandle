package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.orangecandle.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private com.orangecandle.repository.User repo;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void addingUser(@RequestParam String userName,
			HttpServletResponse response) throws IOException {
		try (Writer w = response.getWriter()) {
			if (null == repo.findOne(userName)) {
				repo.saveAndFlush(new User(userName));
				w.write("User with username " + userName + " is added");
			} else {
				w.write("User already exists");
			}
		}
	}

	@RequestMapping(value = "/findAll")
	public void findAllUsers(HttpServletResponse response) throws IOException {
		response.getWriter().write(new Gson().toJson(repo.findAll()));
	}
}