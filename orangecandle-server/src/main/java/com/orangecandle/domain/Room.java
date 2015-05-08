package com.orangecandle.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {
	private @Id String identifier;
	private @Column(name = "sizeof") Integer size;
	private @ManyToMany List<Lecture> lecture;

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getSize() {
		return size;
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
