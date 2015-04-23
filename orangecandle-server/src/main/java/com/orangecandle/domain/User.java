package com.orangecandle.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "xuser")
public class User {
	private @Id @Column(name = "username") String userName;
	private @ManyToMany(fetch = FetchType.LAZY) List<Group> groups;
	private @ManyToMany List<Constraint> constraints;

	public User() {
	}

	public User(String userName) {
		this.userName = userName;
	}

	public List<Group> getGroups() {
		return groups;
	}
}
