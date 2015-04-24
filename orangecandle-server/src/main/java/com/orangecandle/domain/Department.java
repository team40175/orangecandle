package com.orangecandle.domain;

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
@Table(name="department")
public class Department {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private @Column(name="departmentName") String name;
	private @ManyToMany List<User> users;
	private @ManyToMany List<Lecture> lectures;
	private @ManyToMany List<Group> groups;
	private @OneToMany List<Room> rooms;
	
}
