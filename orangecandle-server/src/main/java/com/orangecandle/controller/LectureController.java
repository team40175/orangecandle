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
			HttpServletResponse response) throws IOException {
		try (Writer w = response.getWriter()) {
			boolean success = false;
			try {
				repo.save(new Lecture(lectureCode));
				success = true;
			} catch (DataIntegrityViolationException e) {
				e.printStackTrace();
				w.write("Lecture with code " + lectureCode
						+ " cannot be added because");
				if (e.getMessage().contains("pkey")) {
					w.write(" such user exists");
				} else {
					w.write("of an unknown cause");
				}
			} finally {
				if (success) {
					w.write("Lecture with code " + lectureCode + " is added");
				}
			}
		}
	}
}
