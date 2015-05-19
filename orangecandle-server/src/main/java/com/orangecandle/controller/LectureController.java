package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Department;
import com.orangecandle.domain.Lecture;
import com.orangecandle.service.JsonService;

@Controller
@RequestMapping("/lecture")
public class LectureController {
	private @Autowired com.orangecandle.repository.Lecture repo;
	private @Autowired com.orangecandle.repository.Department departmentRepo;
	private @Autowired JsonService json;

	@RequestMapping(value = "/add")
	public void add(@RequestParam String lectureCode,
			@RequestParam String name, @RequestParam String description,
			@RequestParam String department, HttpServletResponse response)
			throws IOException {
		try (Writer w = response.getWriter()) {
			if ("[]".equals(department)) {
				json.toExtJSON(w, false, "You need to select a department");
			} else if (null == repo.findByCode(lectureCode)) {
				Lecture lecture = new Lecture(lectureCode, name, description);
				Department dept = departmentRepo.findOne(json.fromJson(
						department, Long[].class)[0]);
				dept.addLecture(lecture);
				departmentRepo.save(dept);
				repo.save(lecture);
				json.toExtJSON(w, true, "Lecture with code " + lectureCode
						+ " and name " + name + " is added");
			} else {
				json.toExtJSON(w, false, "Lecture with code " + lectureCode
						+ " already exists");
			}
		}
	}

	@RequestMapping(value = "/findAll")
	public void findAll(@RequestParam(required = false) String username,
			HttpServletResponse response) throws IOException {
		List<Lecture> all = repo.findAll();
		if (username == null) {
			json.toExtJSON(response.getWriter(), true, "", all);
		} else {
			json.toExtJSON(response.getWriter(), true, "",
					repo.findTakenLecturesOf(username));
		}
	}
}
