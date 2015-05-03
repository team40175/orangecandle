package com.orangecandle.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.orangecandle.domain.Constraint;

@Controller
@RequestMapping("/constraint")
public class ConstraintController {

	@Autowired
	private com.orangecandle.repository.Constraint repo;
	@Autowired
	private com.orangecandle.repository.Room rRepo;
	@Autowired
	private com.orangecandle.repository.User uRepo;
	@Autowired
	private com.orangecandle.repository.Lecture lRepo;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void addingUser(@RequestParam String roomName,
			@RequestParam String userName, @RequestParam String lectureCode,
			@RequestParam String text, HttpServletResponse response)
			throws IOException {
		Constraint c = new Constraint(text);
		if (!"".equals(lectureCode)) {
			c.setLecture(lRepo.findOne(lectureCode));
		}
		if (!"".equals(roomName)) {
			c.addRoom(rRepo.findOne(roomName));
		}
		if (!"".equals(userName)) {
			c.addUser(uRepo.findOne(userName));
		}
		repo.saveAndFlush(c);
	}

	@RequestMapping(value = "/add", method = RequestMethod.OPTIONS)
	public void add(HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
	}

	@RequestMapping(value = "/findAll")
	public void findAll(HttpServletResponse response) throws IOException {
		response.getWriter().write(new Gson().toJson(repo.findAll()));
	}

}
