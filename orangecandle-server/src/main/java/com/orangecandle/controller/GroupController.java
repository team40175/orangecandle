package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonObject;
import com.orangecandle.domain.Group;
import com.orangecandle.domain.Role;
import com.orangecandle.domain.User;
import com.orangecandle.service.JsonService;

@RequestMapping(GroupController.URL)
@Controller
public class GroupController {
	static final String URL = "/group";
	private @Autowired com.orangecandle.repository.Group groupRep;
	private @Autowired com.orangecandle.repository.User userRep;
	private @Autowired JsonService json;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void addGroup(@RequestParam String name, @RequestParam String roles,
			HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
		try (Writer w = response.getWriter()) {
			if (null == groupRep.findByName(name)) {
				Group group = new Group(name);
				if ("[]".equals(roles)) {
					json.toExtJSON(w, false,
							"You need to select at least one role");
				}
				group.setRoles(json.fromJson(roles, Role[].class));
				groupRep.saveAndFlush(group);
				json.toExtJSON(w, true, "Group with name " + name + " is added");
			} else {
				json.toExtJSON(w, false, "Group already exists");
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
		Group g = groupRep.findByName(groupName);
		User u = userRep.findByUsername(userName);
		g.addUser(u);
		groupRep.save(g);
	}

	@RequestMapping(value = "/getRoles")
	public void getRoles(HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
		List<JsonObject> roles = new ArrayList<JsonObject>();
		for (Role role : Role.values()) {
			JsonObject joe = new JsonObject();
			joe.addProperty("id", role.toString());
			joe.addProperty("name", role.toString());
			roles.add(joe);
		}
		json.toExtJSON(response.getWriter(), true, "", roles);
	}
}
