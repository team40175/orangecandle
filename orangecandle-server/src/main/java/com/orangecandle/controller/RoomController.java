package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.orangecandle.domain.Room;

@Controller
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private com.orangecandle.repository.Room repo;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void addingUser(@RequestParam String roomName,
			HttpServletResponse response) throws IOException {
		Writer w = response.getWriter();
		if (null == repo.findOne(roomName)) {
			Room room = new Room();
			repo.saveAndFlush(room);
			w.write("Room with name " + roomName + " is added");
		} else {
			w.write("Room already exists");
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.OPTIONS)
	public void add(HttpServletResponse response) throws IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept");
	}

	@RequestMapping(value = "/findAll")
	public void findAllUsers(HttpServletResponse response) throws IOException {
		response.getWriter().write(new Gson().toJson(repo.findAll()));
	}
}
