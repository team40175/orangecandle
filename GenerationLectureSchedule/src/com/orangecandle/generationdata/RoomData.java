package com.orangecandle.generationdata;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.orangecandle.domain.Room;

@Component
public class RoomData {
	public ArrayList<Room> rooms = new ArrayList<Room>();
	int size = 4;

	public void generate() {
		rooms.add(new Room(20, "r1"));
		rooms.add(new Room(20, "r2d2"));
		rooms.add(new Room(20, "r3"));
		rooms.add(new Room(20, "r4"));

	}
}
