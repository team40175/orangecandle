package com.orangecandle.generation;

import com.orangecandle.domain.Lecture;
import com.orangecandle.domain.User;

public class Gene {
	Lecture lecture;
	User lecturer;

	public Gene(Lecture lec, User user) {
		this.lecture = lec;
		this.lecturer = user;
	}

}
