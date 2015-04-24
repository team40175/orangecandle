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
import com.orangecandle.domain.Group;
import com.orangecandle.domain.Role;
import com.orangecandle.domain.User;

@RequestMapping(GroupController.URL)
@Controller
public class GroupController {
	static final String URL = "/group";
	private @Autowired com.orangecandle.repository.Group groupRep;
	private @Autowired com.orangecandle.repository.User userRep;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void addGroup(@RequestParam String groupName,
			HttpServletResponse response) throws IOException {
		try (Writer w = response.getWriter()) {
			if (null == groupRep.findOne(groupName)) {
				groupRep.saveAndFlush(new Group(groupName));
				w.write("Group with name " + groupName + " is added");
			} else {
				w.write("Group already exists");
			}
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.OPTIONS)
	public void add(HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public void addUser(@RequestParam String userName,
			@RequestParam String groupName, HttpServletResponse response)
			throws IOException {
		Group g = groupRep.findOne(groupName);
		User u = userRep.findOne(userName);
		g.addUser(u);
		groupRep.save(g);
		response.getWriter().write("something");
	}

	@RequestMapping(value = "/findAll", method = { RequestMethod.GET,
			RequestMethod.OPTIONS })
	public void findAllUsers(HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
		response.getWriter().write(new Gson().toJson(groupRep.findAll()));
	}

	@RequestMapping(value = "/getRoles")
	public void getRoles(HttpServletResponse response) throws IOException {
		response.getWriter().write(new Gson().toJson(Role.values()));
	}
}
