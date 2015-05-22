package com.orangecandle.generation;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orangecandle.domain.Building;
import com.orangecandle.domain.Department;
import com.orangecandle.domain.Lecture;
import com.orangecandle.domain.Room;
import com.orangecandle.domain.User;

public class Gene {

	private static final Logger log = LoggerFactory.getLogger(Gene.class);

	Department department;
	Building build;
	Lecture lecture;
	User lecturer;
	Room room;
	ArrayList<User> students;

	public Gene() {
		log.info("Gene function");
		// TODO: something random should be there
		this.lecture = new Lecture();
		this.lecturer = new User();
		this.room = new Room();
		this.students = new ArrayList<User>();
		this.department = new Department();
	}

	public Gene(Lecture lec, User lecr, Room room, ArrayList<User> students) {
		log.info("Gene(Lecture lec,...) function");

		this.lecture = lec;
		this.lecturer = lecr;
		this.room = room;
		this.students = students;
	}

}
