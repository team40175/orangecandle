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
		Writer w = response.getWriter();
		Long room = json.fromJson(rooms, Long[].class)[0];
		Long lecture = json.fromJson(lectures, Long[].class)[0];
		Long user = json.fromJson(users, Long[].class)[0];
		if (id == null) {
			c.setName(name);
			c.setLecture(lRepo.findOne(lecture));
			c.setRoom(rRepo.findOne(room));
			c.setUser(uRepo.findOne(user));
			repo.saveAndFlush(c);
			json.toExtJSON(w, true, "Constraint added with name " + name);
		} else {
			Constraint constraint = repo.getOne(id);
			constraint.setName(name);
			constraint.setLecture(lRepo.findOne(lecture));
			constraint.setEvaluationString(text);
			constraint.setUser(uRepo.findOne(user));
			constraint.setRoom(rRepo.findOne(user));
			repo.save(constraint);
			json.toExtJSON(w, true, "Constraint edited successfully.");

		}
	}

}
