package com.orangecandle.domain;

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
public class Constraint {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private @ManyToOne Lecture lecture;
	private @ManyToMany List<User> users;
	private @ManyToMany List<Room> rooms;
	private @Column(name = "eval") String evaluationString;
	
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer i){
		this.id=i;
	}
	public String getEvaluationString(){
		return this.evaluationString;
	}
	public void setEvaluationString(String ide){
		this.evaluationString=ide;
	}
	public Lecture getLectures(){
		return this.lecture;
	}
	public void setLecture(Lecture lec){
		this.lecture=lec;;
	}
	public void addRoom(Room r){
		if(rooms.isEmpty()) rooms=new ArrayList<Room>();
		rooms.add(r);
	}
	public List<Room> getRooms(){
		return this.rooms;
	}
	public List<User> getUsers(){
		return this.users;
	}
	public void addUser(User user){
		if(this.users.isEmpty()) this.users= new ArrayList<User>();
		this.users.add(user);
	}
}
