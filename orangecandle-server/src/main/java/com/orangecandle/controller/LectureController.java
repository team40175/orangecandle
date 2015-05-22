package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

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
	private @Autowired MainController mainController;

	@RequestMapping(value = "/add")
	public void add(@RequestParam(required = false) Long id,
			@RequestParam String code, @RequestParam String name,
			@RequestParam String description, @RequestParam String department,
			HttpServletResponse response) throws IOException {
		try (Writer w = response.getWriter()) {
			if ("[]".equals(department)) {
				json.toExtJSON(w, false, "You need to select a department");
				return;
			}
			Department dept = departmentRepo.findOne(json.fromJson(department,
					Long[].class)[0]);
			Lecture xLecture = repo.findByCodeAndDepartment(code, dept);
			if (xLecture != null
					&& (id == null || !id.equals(xLecture.getId()))) {
				json.toExtJSON(w, false, "Lecture with code " + code
						+ " already exists in department " + dept.getName());
			} else if (id == null) {
				Lecture lecture = new Lecture(code, name, description);
				lecture.setDepartment(dept);
				repo.save(lecture);
				json.toExtJSON(w, true, "Lecture with code " + code
						+ " and name " + name + " is added");
			} else {
				Lecture lecture = repo.findOne(id);
				lecture.setDepartment(dept);
				repo.save(lecture);
				json.toExtJSON(w, true, "Lecture edited successfully");
			}
		}
	}

	@RequestMapping(value = "/findAll")
	public void findAll(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String username,
			HttpServletResponse response) throws IOException {
		if (username == null) {
			mainController.findAll(id, "lecture", response);
		} else {
			json.toExtJSON(response.getWriter(), true, "",
					repo.findTakenLecturesOf(username));
		}
	}
}
