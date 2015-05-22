package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Department;
import com.orangecandle.domain.Faculty;
import com.orangecandle.service.JsonService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	private @Autowired com.orangecandle.repository.Department repo;
	private @Autowired com.orangecandle.repository.Faculty facultyRepo;
	private @Autowired JsonService json;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void add(@RequestParam(required = false) Long id,
			@RequestParam String name, @RequestParam String faculties,
			HttpServletResponse response) throws IOException {
		Writer w = response.getWriter();
		if ("[]".equals(faculties)) {
			json.toExtJSON(w, false, "You need to select a faculty");
			return;
		}
		Faculty faculty = facultyRepo.findOne(json.fromJson(faculties,
				Long[].class)[0]);
		Department xDepartment = repo.findByNameAndFaculty(name, faculty);
		if (null != xDepartment
				&& (id == null || !id.equals(xDepartment.getId()))) {
			json.toExtJSON(w, false, "Department with name " + name
					+ " already exists in " + faculty.getName());
		} else if (id == null) {
			Department department = new Department(name);
			department.setFaculty(faculty);
			repo.save(department);
			json.toExtJSON(w, true, "Succesfully added a department with name "
					+ name + " to " + faculty.getName());
		} else {
			Department department = repo.findOne(id);
			department.setName(name);
			department.setFaculty(faculty);
			repo.save(department);
			json.toExtJSON(w, true, "Department successfully edited.");
		}
	}
}
