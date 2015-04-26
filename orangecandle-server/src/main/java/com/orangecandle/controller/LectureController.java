package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Lecture;

@Controller
@RequestMapping(LectureController.URL)
public class LectureController {
	static final String URL = "/lecture";
	@Autowired
	private com.orangecandle.repository.Lecture repo;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void add(@RequestParam String lectureCode,
			@RequestParam String name, HttpServletResponse response)
			throws IOException {
		try (Writer w = response.getWriter()) {
			if (null == repo.findOne(lectureCode)) {
				repo.save(new Lecture(lectureCode, name));
				w.write("Lecture with code " + lectureCode + " and name "
						+ name + " is added");
			} else {
				w.write("Lecture with code " + lectureCode + " already exists");
			}
		}
	}
}
