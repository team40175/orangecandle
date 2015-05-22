package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Constraint;
import com.orangecandle.domain.Group;
import com.orangecandle.domain.User;
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
	public void add(@RequestParam(required = false) Long id,
			@RequestParam String name, @RequestParam String rooms,
			@RequestParam String users, @RequestParam String lectures,
			@RequestParam String text, HttpServletResponse response)
			throws IOException {
		Constraint c = new Constraint(text);
		Constraint xconstraint = repo.findOne(id);
		Writer w = response.getWriter();
		Long room = json.fromJson(rooms, Long.class);
		Long lecture = json.fromJson(lectures, Long.class);
		Long user = json.fromJson(users, Long.class);
		if (null != xconstraint
				&& (id == null || !id.equals(xconstraint.getId()))) {
			json.toExtJSON(w, false, "Constraint already exists");
		} else if (id == null) {
			if (!"".equals(name)) {
				c.addName(name);
			}
			if (!"".equals(lectures)) {
				c.setLecture(lRepo.findOne(lecture));
			}
			if (!"".equals(rooms)) {
				c.addRoom(rRepo.findOne(room));
			}
			if (!"".equals(user)) {
				c.addUser(uRepo.findOne(user));
			}
			repo.saveAndFlush(c);
			json.toExtJSON(w, true, ".");
		} else {
			Constraint constraint = repo.getOne(id);
			constraint.addName(name);
			constraint.setLecture(lRepo.findOne(lecture));
			constraint.setEvaluationString(text);
			constraint.setUser(uRepo.findOne(user));
			constraint.setRoom(rRepo.findOne(user));
			repo.save(constraint);
			json.toExtJSON(w, true, "User edited successfully.");

		}
	}

}
