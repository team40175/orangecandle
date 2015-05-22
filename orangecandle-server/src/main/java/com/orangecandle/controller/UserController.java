package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
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

@Controller
@RequestMapping("/user")
public class UserController {
	private @Autowired com.orangecandle.repository.User repo;
	private @Autowired com.orangecandle.repository.Group groupRepo;
	private @Autowired com.orangecandle.repository.Lecture lectureRepo;
	private @Autowired JsonService json;

	@PostConstruct
	public void createDefaults() {
		// can we externalize these?
		if (groupRepo.findByName("admins") == null) {
			Group g = new Group("admins");
			g.setRoles(Role.Administrator);
			groupRepo.save(g);
			if (repo.findByUsername("admin") == null) {
				User u = new User("admin");
				u.setPassword("pass");
				u.addGroup(g);
				repo.save(u);
			}
		}
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void add(@RequestParam Long id, @RequestParam String username,
			@RequestParam String groups, HttpServletResponse response)
			throws IOException {
		Writer w = response.getWriter();
		User xuser = repo.findByUsername(username);
		if (null != xuser && (id == null || !id.equals(xuser.getId()))) {
			json.toExtJSON(w, false, "User already exists");
		} else if ("[]".equals(groups)) {
			json.toExtJSON(w, false, "You need to select at least one group");
		} else if (id == null) {
			User user = new User(username);
			String randomPassword = UUID.randomUUID().toString()
					.substring(0, 8);
			user.setPassword(randomPassword);
			for (Long groupName : json.fromJson(groups, Long[].class)) {
				Group group = groupRepo.findOne(groupName);
				group.addUser(user);
				user.addGroup(group);
			}
			repo.saveAndFlush(user);
			json.toExtJSON(w, true, "User with username " + username
					+ " is created with password " + randomPassword);
		} else {
			User user = repo.getOne(id);
			user.setUserName(username);
			user.removeAllGroups();
			for (Long groupName : json.fromJson(groups, Long[].class)) {
				Group group = groupRepo.findOne(groupName);
				group.addUser(user);
				user.addGroup(group);
			}
			repo.save(user);
			json.toExtJSON(w, true, "User edited successfully.");
		}
	}

	@RequestMapping(value = "/findTeachers")
	public void findTeachers(HttpServletResponse response) throws IOException {
		List<User> users = repo.findAll();
		List<User> teachers = new LinkedList<User>();
		for (User user : users) {
			for (Group group : user.getGroups()) {
				if (group.getRoles() != null
						&& group.getRoles().contains(Role.Lecturer)) {
					teachers.add(user);
				}
			}
		}
		json.toExtJSON(response.getWriter(), true, "", teachers);
	}

	@RequestMapping(value = "/assignLectures")
	public void assignLectures(@RequestParam String teachers,
			@RequestParam String lectures, HttpServletResponse response)
			throws IOException {
		for (Long uid : json.fromJson(teachers, Long[].class)) {
			User user = repo.findOne(uid);
			for (Long lid : json.fromJson(lectures, Long[].class)) {
				user.assignLecture(lectureRepo.findOne(lid));
			}
		}
	}

	@RequestMapping(value = "/pickLectures")
	public void pickLectures(@RequestParam String lectures,
			@RequestParam String username, HttpServletResponse response)
			throws IOException {
		User user = repo.findByUsername(username);
		for (Long id : json.fromJson(lectures, Long[].class)) {
			user.pickLecture(lectureRepo.findOne(id));
		}
		repo.save(user);
		json.toExtJSON(response.getWriter(), true,
				"You have successfully picked lectures.");
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

	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public void changePassword(@RequestParam String oldPw,
			@RequestParam String newPw1, @RequestParam String newPw2,
			@RequestParam String username, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Writer w = response.getWriter();
		if (newPw1 == null || !newPw1.equals(newPw2)) {
			json.toExtJSON(w, false, "New passwords are not equal");
		} else {
			User user = repo.findByUsername(username);
			String pw = user.getPassword();
			if (!pw.equals(oldPw)) {
				json.toExtJSON(w, false, "Your password isn't correct");
			} else {
				user.setPassword(newPw1);
				repo.save(user);
				json.toExtJSON(w, true, "Your password is changed successfully");
			}
		}
	}
}