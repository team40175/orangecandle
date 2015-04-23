package com.orangecandle.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Room {
	private @Id Integer id;
	private @Column(name = "ide") String identifier;
	private @ManyToMany List<Lecture> lecture;
}
