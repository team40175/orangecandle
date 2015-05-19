package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Faculty;
import com.orangecandle.domain.School;
import com.orangecandle.service.JsonService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
	private @Autowired com.orangecandle.repository.Faculty repo;
	private @Autowired com.orangecandle.repository.School schoolRepo;
	private @Autowired JsonService json;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void add(@RequestParam String name, @RequestParam String schools,
			HttpServletResponse response) throws IOException {
		Writer w = response.getWriter();
		if ("[]".equals(schools)) {
			json.toExtJSON(w, false, "You need to select a school");
		} else {
			Faculty faculty = new Faculty(name);
			School school = schoolRepo.findOne(json.fromJson(schools,
					Long[].class)[0]);
			school.addFaculty(faculty);
			repo.save(faculty);
			schoolRepo.save(school);
			json.toExtJSON(w, true, "Succesfully added a department with name "
					+ name + " to " + school.getName());
		}
	}
}
