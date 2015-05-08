package com.orangecandle.domain;

import java.util.ArrayList;
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
	private @ManyToMany(fetch = FetchType.LAZY) List<Group> groups = new ArrayList<Group>();;
	private @ManyToMany List<Constraint> constraints;

	public User() {
	}

	public User(String userName) {
		this.userName = userName;
	}
	public void addConstraint(Constraint c) {
		if(constraints==null) constraints=new ArrayList<Constraint>();
		constraints.add(c);
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}

	public void addGroup(Group g) {
		if(groups==null) groups=new ArrayList<Group>();
		groups.add(g);
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getUserName() {
		return this.userName;
	}

	@Override
	public String toString() {
		return "{\"name\":\"" + userName + "\"}";
	}
}
