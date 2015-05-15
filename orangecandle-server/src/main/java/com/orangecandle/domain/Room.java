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
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room implements Serializable{
	
	private static final long serialVersionUID = -8319212016466507835L;
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id") Long id;
	private @Column String identifier;
	private @Column(name = "sizeof") Long size;
	private @ManyToMany List<Lecture> lecture;

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getSize() {
		return size;
	}
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id=id;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String ide) {
		this.identifier = ide;
	}

	public List<Lecture> getLectures() {
		return this.lecture;
	}

	public void addLecture(Lecture lec) {
		if (this.lecture==null)
			this.lecture = new ArrayList<Lecture>();
		this.lecture.add(lec);
	}
}
