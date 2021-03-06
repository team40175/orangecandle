package com.orangecandle.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orangecandle.domain.Building;
import com.orangecandle.domain.Room;
import com.orangecandle.service.JsonService;

@Controller
@RequestMapping("/room")
public class RoomController {

	private @Autowired com.orangecandle.repository.Room repo;
	private @Autowired com.orangecandle.repository.Building buildingRepo;
	private @Autowired JsonService json;

	@RequestMapping(value = "/add", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void addingUser(@RequestParam(required = false) Long id,
			@RequestParam String name, @RequestParam String buildings,
			HttpServletResponse response) throws IOException {
		Writer w = response.getWriter();
		if ("[]".equals(buildings)) {
			json.toExtJSON(w, false, "You need to select a building.");
			return;
		}
		Building building = buildingRepo.findOne(json.fromJson(buildings,
				Long[].class)[0]);
		Room xRoom = repo.findByNameAndBuilding(name, building);
		if (null != xRoom && (id == null || !id.equals(xRoom.getId()))) {
			json.toExtJSON(w, false, "Room already exists");
		} else if (id == null) {
			Room room = new Room(name);
			room.setBuilding(building);
			repo.saveAndFlush(room);
			json.toExtJSON(w, true, "Room with name " + name + " is added");
		} else {
			Room room = new Room(name);
			repo.saveAndFlush(room);
			json.toExtJSON(w, true, "Room edited successfully");
		}
	}
}
