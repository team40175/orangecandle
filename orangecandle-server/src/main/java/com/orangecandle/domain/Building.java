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
@Table(name="xbuilding")
public class Building implements Serializable{
	
	private static final long serialVersionUID = -5374885970668422346L;
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id") Long id;
	private @Column(name="buildingname") String buildingName;
	private @ManyToMany List<Department> departments;
	private @ManyToMany List<Lecture> lectures;
	private @OneToMany List<Room> rooms;
	
	public Long getId(){
		return this.id;
	}
	public void setId(Long i){
		this.id=i;
	}
	public String getBuildingName(){
		return this.buildingName;
	}
	public void setBuildingName(String i){
		this.buildingName=i;
	}
	
	public List<Department> getDepartment(){
		return this.departments;
	}
	public void addDepartment(Department name){
		if(departments==null) departments=new ArrayList<Department>();
		this.departments.add(name);
	}
	public List<Lecture> getLectures(){
		return this.lectures;
	}
	public void addLecture(Lecture lec){
		if(this.lectures==null) this.lectures= new ArrayList<Lecture>();
		this.lectures.add(lec);
	}
	
	public List<Room> getRoom(){
		return this.rooms;
	}
	public void addRoom(Room lec){
		if(this.rooms==null) this.rooms= new ArrayList<Room>();
		this.rooms.add(lec);
	}
	
}
