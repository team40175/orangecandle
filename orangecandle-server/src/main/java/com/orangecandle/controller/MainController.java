package com.orangecandle.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.service.JsonService;
import com.orangecandle.service.RepositoryService;

@Controller
public class MainController implements ErrorController {

	private @Autowired RepositoryService repos;
	private @Autowired JsonService json;

	@RequestMapping(value = "/login")
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		json.toExtJSON(response.getWriter(), true, "Logged in successfully");
	}

	@RequestMapping(value = "/error")
	public void error(HttpServletResponse response) throws IOException {
		json.toExtJSON(response.getWriter(), false,
				"There is an error processing your request");
	}

	@RequestMapping(value = "{type}/findAll")
	public void findAll(@RequestParam(required = false) Long id,
			@PathVariable String type, HttpServletResponse response)
			throws IOException {
		if (id == null) {
			json.toExtJSON(response.getWriter(), true, "", repos.get(type)
					.findAll());
		} else {
			json.toExtJSON(response.getWriter(), true, "", repos.get(type)
					.findOne(id));
		}
	}

	@RequestMapping(value = "{type}/remove")
	public void remove(@RequestParam Long id, @PathVariable String type,
			HttpServletResponse response) throws IOException {
		repos.get(type).delete(id);
		json.toExtJSON(response.getWriter(), true, "Entry successfully removed");
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
