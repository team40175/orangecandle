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
import javax.persistence.Table;

@Entity
@Table(name = "xconstraint")
public class Constraint implements Serializable {

	private static final long serialVersionUID = -6615851401951635459L;
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @ManyToOne Lecture lecture;
	private transient @ManyToMany List<User> users;
	private transient @ManyToMany List<Room> rooms;
	private @Column(name = "eval") String evaluationString;

	public Constraint() {
	}

	public Constraint(String text) {
		evaluationString = text;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long i) {
		this.id = i;
	}

	public String getEvaluationString() {
		return this.evaluationString;
	}

	public void setEvaluationString(String ide) {
		this.evaluationString = ide;
	}

	public Lecture getLectures() {
		return this.lecture;
	}

	public void setLecture(Lecture lec) {
		this.lecture = lec;
	}

	public void addRoom(Room r) {
		if (rooms == null)
			rooms = new ArrayList<Room>();
		rooms.add(r);
	}

	public List<Room> getRooms() {
		return this.rooms;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void addUser(User user) {
		if (this.users == null)
			this.users = new ArrayList<User>();
		this.users.add(user);
	}
}
