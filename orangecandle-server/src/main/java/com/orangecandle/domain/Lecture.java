package com.orangecandle.domain;

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
	private @Id @Column(name = "code") String lectureCode;
	private @Column(name = "name") String name;
	private @ManyToMany List<User> lecturers;
	private @OneToMany List<Constraint> constraints;

	public Lecture() {
	}

	public Lecture(String code) {
		lectureCode = code;
	}
}
