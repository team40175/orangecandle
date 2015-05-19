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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = -8249245680207093049L;
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @Column(name = "name") String name;
	private transient @ManyToMany List<User> users;
	private transient @ManyToMany List<Lecture> lectures;
	private transient @ManyToMany List<Group> groups;
	private transient @OneToMany List<Room> rooms;

	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long i) {
		this.id = i;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Lecture> getLectures() {
		return this.lectures;
	}

	public void addLecture(Lecture lec) {
		if (this.lectures.isEmpty())
			this.lectures = new ArrayList<Lecture>();
		this.lectures.add(lec);
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void addUser(User user) {
		if (this.users == null)
			this.users = new ArrayList<User>();
		this.users.add(user);
	}

	public List<Group> getGroup() {
		return this.groups;
	}

	public void addGroup(Group lec) {
		if (this.groups == null)
			this.groups = new ArrayList<Group>();
		this.groups.add(lec);
	}

	public List<Room> getRoom() {
		return this.rooms;
	}

	public void addRoom(Room lec) {
		if (this.rooms == null)
			this.rooms = new ArrayList<Room>();
		this.rooms.add(lec);
	}

}
