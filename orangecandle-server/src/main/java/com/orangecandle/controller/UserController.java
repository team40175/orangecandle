package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonObject;
import com.orangecandle.domain.Group;
import com.orangecandle.domain.Role;
import com.orangecandle.domain.User;
import com.orangecandle.service.JsonService;

@Controller
@Transactional
@RequestMapping("/user")
public class UserController {
	private @Autowired com.orangecandle.repository.User repo;
	private @Autowired com.orangecandle.repository.Group groupRepo;
	private @Autowired JsonService json;

	@PostConstruct
	public void createDefaults() {
		if (groupRepo.findByName("admins") == null) {
			Group g = new Group("admins");
			g.setRoles(Role.Administrator);
			groupRepo.save(g);
			if (repo.findByUsername("admin") == null) {
				User u = new User("admin");
				u.addGroup(g);
				repo.save(u);
			}
		}
	}

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
			if ("[]".equals(groups)) {
				json.toExtJSON(w, false,
						"You need to select at least one group");
			}
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

	@RequestMapping(value = "/findRoles", method = RequestMethod.GET)
	public void getRoles(@RequestParam String username,
			HttpServletResponse response) throws IOException {
		List<JsonObject> result = new ArrayList<JsonObject>();
		List<Group> groups = repo.findGroupsByUsername(username);
		Set<Role> roles = new TreeSet<Role>();
		for (Group group : groups) {
			List<Role> gRoles = group.getRoles();
			if (gRoles != null) {
				roles.addAll(gRoles);
			}
		}
		for (Role role : roles) {
			JsonObject joe = new JsonObject();
			joe.addProperty("id", role.toString());
			joe.addProperty("name", role.toString());
			result.add(joe);
		}
		json.toExtJSON(response.getWriter(), false,
				"Fetching of roles is successful", result);
	}

	@RequestMapping(value = "/add", method = RequestMethod.OPTIONS)
	public void add(HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
	}
}