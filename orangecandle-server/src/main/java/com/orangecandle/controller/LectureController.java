package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Lecture;
import com.orangecandle.service.JsonService;

@Controller
@RequestMapping(LectureController.URL)
public class LectureController {
	static final String URL = "/lecture";
	@Autowired
	private com.orangecandle.repository.Lecture repo;
	private @Autowired JsonService json;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void add(@RequestParam String lectureCode,
			@RequestParam String name, @RequestParam String description,
			HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
		try (Writer w = response.getWriter()) {
			if (null == repo.findByCode(lectureCode)) {
				repo.save(new Lecture(lectureCode, name, description));
				json.toExtJSON(w, true, "Lecture with code " + lectureCode
						+ " and name " + name + " is added");
			} else {
				json.toExtJSON(w, false, "Lecture with code " + lectureCode
						+ " already exists");
			}
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.OPTIONS)
	public void add(HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
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
