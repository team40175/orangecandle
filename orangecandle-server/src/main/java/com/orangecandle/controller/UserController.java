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
	@Autowired
	private com.orangecandle.repository.User repo;
	@Autowired
	private com.orangecandle.repository.Group groupRepo;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void add(@RequestParam String userName, @RequestParam String groups,
			HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");

		Writer w = response.getWriter();
		if (null == repo.findOne(userName)) {
			User user = new User(userName);
			for (String groupName : JsonService
					.fromJson(groups, String[].class)) {
				Group group = groupRepo.findOne(groupName);
				group.addUser(user);
				user.addGroup(group);
			}
			repo.saveAndFlush(user);

			w.write(JsonService.toExtJSON(true, "User with username "
					+ userName + " is added"));
		} else {
			w.write(JsonService.toExtJSON(false, "User already exists"));
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
		response.getWriter().write(
				JsonService.toExtJSON(true, "", repo.findAll()));
	}
}