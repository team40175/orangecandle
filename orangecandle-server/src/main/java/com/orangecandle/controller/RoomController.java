package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Room;
import com.orangecandle.service.JsonService;

@Controller
@RequestMapping("/room")
public class RoomController {

	private @Autowired com.orangecandle.repository.Room repo;
	private @Autowired JsonService json;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void addingUser(@RequestParam String name,
			@RequestParam String buildings, HttpServletResponse response)
			throws IOException {
		Writer w = response.getWriter();
		if ("[]".equals(buildings)) {
			json.toExtJSON(w, false, "You need to select a building.");
		} else if (null == repo.findByName(name)) {
			Room room = new Room(name);
			repo.saveAndFlush(room);
			json.toExtJSON(w, false, "Room with name " + name + " is added");
		} else {
			json.toExtJSON(w, false, "Room already exists");
		}
	}
}
