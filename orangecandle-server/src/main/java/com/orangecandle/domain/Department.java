package com.orangecandle.domain;

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
@Table(name="department")
public class Department {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private @Column(name="departmentName") String name;
	private @ManyToMany List<User> users;
	private @ManyToMany List<Lecture> lectures;
	private @ManyToMany List<Group> groups;
	private @OneToMany List<Room> rooms;
	
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer i){
		this.id=i;
	}
	public String getDepartmentName(){
		return this.name;
	}
	public void setDepartmentName(String name){
		this.name=name;
	}
	public List<Lecture> getLectures(){
		return this.lectures;
	}
	public void addLecture(Lecture lec){
		if(this.lectures.isEmpty()) this.lectures= new ArrayList<Lecture>();
		this.lectures.add(lec);
	}
	
	public List<User> getUsers(){
		return this.users;
	}
	public void addUser(User user){
		if(this.users==null) this.users= new ArrayList<User>();
		this.users.add(user);
	}
	public List<Group> getGroup(){
		return this.groups;
	}
	public void addGroup(Group lec){
		if(this.groups==null) this.groups= new ArrayList<Group>();
		this.groups.add(lec);
	}
	
	public List<Room> getRoom(){
		return this.rooms;
	}
	public void addRoom(Room lec){
		if(this.rooms==null) this.rooms= new ArrayList<Room>();
		this.rooms.add(lec);
	}
	
	
	
}
