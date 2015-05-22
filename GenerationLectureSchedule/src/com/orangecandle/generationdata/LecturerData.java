package com.orangecandle.generationdata;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.orangecandle.domain.Lecture;
import com.orangecandle.domain.User;

@Component
public class LecturerData {
	private LectureData lData;
	public ArrayList<User> teachers = new ArrayList<User>();

	public void generate() {
		ArrayList<Lecture> lec = new ArrayList<Lecture>();
		lec.add(lData.lessons0.get(1));
		lec.add(lData.lessons2.get(2));
		teachers.add(new User("T1", lec, true));

		lec = new ArrayList<Lecture>();
		lec.add(lData.lessons0.get(0));
		lec.add(lData.lessons2.get(1));
		teachers.add(new User("T2", lec, true));

		lec = new ArrayList<Lecture>();
		lec.add(lData.lessons0.get(2));
		lec.add(lData.lessons2.get(0));
		lec.add(lData.lessons3.get(1));
		teachers.add(new User("T3", lec, false));

		lec = new ArrayList<Lecture>();
		lec.add(lData.lessons1.get(2));
		lec.add(lData.lessons3.get(2));
		lec.add(lData.lessons1.get(0));
		teachers.add(new User("T4", lec, false));

		lec = new ArrayList<Lecture>();
		lec.add(lData.lessons1.get(1));
		lec.add(lData.lessons3.get(0));
		teachers.add(new User("T5", lec, false));
	}

}
