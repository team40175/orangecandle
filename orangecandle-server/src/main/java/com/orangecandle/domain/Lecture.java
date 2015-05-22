package com.orangecandle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lecture")
public class Lecture implements Serializable {

	private static final long serialVersionUID = 1490293234368020771L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id @Column(name = "id") Long id;
	private @Column(name = "code") String code;
	private @Column(name = "name") String name;
	private @Column String description;
	private @ManyToOne Department department;
	private @Column Boolean mandatory;
	private @Column Integer year;
	private @Column Integer credit;
	private transient @ManyToMany List<User> lecturers;
	private transient @OneToMany List<Constraint> constraints;

	public Lecture() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lecture(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Lecture(String code, String name, String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public Lecture(String code, String name, boolean mandatory, int year,
			int credit) {
		this.code = code;
		this.name = name;
		this.mandatory = mandatory;
		this.year = year;
		this.credit = credit;
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
		if (lecturers == null)
			lecturers = new ArrayList<User>();
		lecturers.add(lecturer);
	}

	public List<User> getLecturers() {
		return lecturers;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
