package com.orangecandle.generationdata;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.orangecandle.domain.Lecture;
import com.orangecandle.domain.User;
import com.orangecandle.generation.GenerationConstants;

public class StudentData {
	private @Autowired LectureData lData;
	private @Autowired GenerationConstants cons;
	static int size = 50;
	static int sinir2 = 3;

	static ArrayList<User> ogrenciler = new ArrayList<User>();
	static ArrayList<Lecture> lecture;

	public void generate() {
		for (int i = 0; i < size; i++) {
			lecture = new ArrayList<Lecture>();
			for (int j = 0; j < sinir2; j++) {
				lecture.add(lData.all.get(cons.randomYear()).get(
						cons.randomTimeSlot()));
			}
			String name = "student" + i;
			User std = new User(name);
			ogrenciler.add(i, std);
		}

	}
}
