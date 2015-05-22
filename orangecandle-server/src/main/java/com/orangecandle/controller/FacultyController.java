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
	public void add(@RequestParam Long id, @RequestParam String name,
			@RequestParam String schools, HttpServletResponse response)
			throws IOException {
		Writer w = response.getWriter();
		if ("[]".equals(schools)) {
			json.toExtJSON(w, false, "You need to select a school");
			return;
		}
		School school = schoolRepo
				.findOne(json.fromJson(schools, Long[].class)[0]);
		Faculty xFaculty = repo.findByName(name);
		if (null != xFaculty && (id == null || !id.equals(xFaculty.getId()))) {
			json.toExtJSON(w, false, "There is already a faculty with name "
					+ name + " in " + school.getName());
		} else if (id == null) {
			Faculty faculty = new Faculty(name);
			faculty.setSchool(school);
			repo.save(faculty);
			json.toExtJSON(w, true, "Succesfully added a faculty with name "
					+ name + " to " + school.getName());
		} else {
			Faculty faculty = repo.findOne(id);
			faculty.setSchool(school);
			repo.save(faculty);
			json.toExtJSON(w, true, "Faculty successfully edited.");
		}
	}
}
