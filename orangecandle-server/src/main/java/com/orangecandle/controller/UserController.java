package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Group;
import com.orangecandle.domain.User;
import com.orangecandle.service.JsonService;

@Controller
@RequestMapping("/user")
public class UserController {
	private @Autowired com.orangecandle.repository.User repo;
	private @Autowired com.orangecandle.repository.Group groupRepo;
	private @Autowired JsonService json;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void add(@RequestParam String username, @RequestParam String groups,
			HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");

		Writer w = response.getWriter();
		if (null == repo.findByUsername(username)) {
			User user = new User(username);
			for (Long groupName : json.fromJson(groups, Long[].class)) {
				Group group = groupRepo.findOne(groupName);
				group.addUser(user);
				user.addGroup(group);
			}
			repo.saveAndFlush(user);

			json.toExtJSON(w, true, "User with username " + username
					+ " is added");
		} else {
			json.toExtJSON(w, false, "User already exists");
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.OPTIONS)
	public void add(HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
	}

	@RequestMapping(value = "/findAll")
	public void findAllUsers(HttpServletResponse response) throws IOException {
		json.toExtJSON(response.getWriter(), true, "", repo.findAll());
	}
}