package com.orangecandle.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	private @Id int id;
	private String userName;
	private @ManyToMany List<Group> groups;

	public List<Group> getGroups() {
		return groups;
	}
}
