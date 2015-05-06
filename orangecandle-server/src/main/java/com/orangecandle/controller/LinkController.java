package com.orangecandle.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.orangecandle.service.JsonService;

@Controller
public class LinkController {

	private @Autowired com.orangecandle.repository.Group groupRep;
	private @Autowired com.orangecandle.repository.User userRep;
	private @Autowired com.orangecandle.repository.Lecture lectureRep;
	private @Autowired com.orangecandle.repository.Room roomRep;
	private @Autowired com.orangecandle.repository.School schoolRep;
	private @Autowired com.orangecandle.repository.Faculty facultyRep;
	private @Autowired com.orangecandle.repository.Department departmentRep;
	private @Autowired com.orangecandle.repository.Building buildingRep;
	private @Autowired com.orangecandle.repository.Constraint constraintRep;

	@RequestMapping(value = "/login")
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setStatus(200);
		// response.addCookie(new Cookie("Authorization", request
		// .getHeader("Authorization")));
		response.getWriter().write(
				JsonService.toExtJSON(true, "Logged in successfully", "[]"));
	}

	// @RequestMapping(value = "{type}/findAll")
	public void findAll(@PathVariable String type, HttpServletResponse response)
			throws IOException {
		JpaRepository repo = null;
		switch (type) {
		case "room":
			repo = roomRep;
		case "group":
			repo = groupRep;
		case "user":
			repo = userRep;
		}
		response.getWriter().write(
				JsonService.toExtJSON(true, "", repo.findAll()));
	}
}
