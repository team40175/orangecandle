package com.orangecandle.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Constraint;
import com.orangecandle.service.JsonService;

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
	private @Autowired JsonService json;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void add(@RequestParam String roomName,
			@RequestParam String userName, @RequestParam String lectureCode,
			@RequestParam String text, HttpServletResponse response)
			throws IOException {
		Constraint c = new Constraint(text);
		if (!"".equals(lectureCode)) {
			c.setLecture(lRepo.findByCode(lectureCode));
		}
		if (!"".equals(roomName)) {
			c.addRoom(rRepo.findByName(roomName));
		}
		if (!"".equals(userName)) {
			c.addUser(uRepo.findByUsername(userName));
		}
		repo.saveAndFlush(c);
	}
}
