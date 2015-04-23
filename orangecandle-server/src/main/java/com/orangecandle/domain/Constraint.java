package com.orangecandle.domain;

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
}
