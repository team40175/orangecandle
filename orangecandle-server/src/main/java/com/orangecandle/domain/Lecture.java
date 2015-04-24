package com.orangecandle.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lecture")
public class Lecture {
	private @Id @Column(name = "code") String code;
	private @Column(name = "name") String name;
	private @ManyToMany List<User> lecturers;
	private @OneToMany List<Constraint> constraints;

	public Lecture() {
	}

	public Lecture(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getLectureName() {
		return name;
	}

	public void setLectureName(String name) {
		this.name = name;
	}

	public String getLectureCode() {
		return code;
	}

	public void addLecturer(User lecturer) {
		if (lecturers.isEmpty())
			lecturers = new ArrayList<User>();
		lecturers.add(lecturer);
	}

	public List<User> getLecturers() {
		return lecturers;
	}
}
