package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.School;
import com.orangecandle.service.JsonService;

@Controller
@RequestMapping("/school")
public class SchoolController {
	private @Autowired com.orangecandle.repository.School repo;
	private @Autowired JsonService json;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void add(@RequestParam String name, HttpServletResponse response)
			throws IOException {
		Writer w = response.getWriter();
		if (repo.findByName(name) == null) {
			repo.save(new School(name));
			json.toExtJSON(w, true, "School with name " + name + " is added");
		} else {
			json.toExtJSON(w, false, "School with name " + name
					+ " already exists");
		}
	}
}