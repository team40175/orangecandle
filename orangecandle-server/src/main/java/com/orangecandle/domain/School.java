package com.orangecandle.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="school")
public class School {
	private @Column(name="schoolname") String schoolName;
	private @OneToMany List<Faculty> faculties;
	
	public String getName() {
		return schoolName;
	}
	public void setName(String name) {
		this.schoolName=name;
	}
	public void addFaculty(Faculty fac) {
		if(faculties.isEmpty()) faculties=new ArrayList<Faculty>();
		this.faculties.add(fac);
	}
	public List<Faculty> listFaculty() {
		return this.faculties;
	}
}
