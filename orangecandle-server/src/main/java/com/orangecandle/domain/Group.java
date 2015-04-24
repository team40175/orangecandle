package com.orangecandle.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "xgroup")
public class Group {
	private @Id @Column(name = "name") String name;

	private @ManyToMany(fetch = FetchType.EAGER) List<User> users;

	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	private @Enumerated(EnumType.STRING) List<Role> roles;

	public Group() {
	}

	public Group(String groupName) {
		this.name = groupName;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setGroupName(String name){
		this.name=name;
	}
	public String getGroupName(){
		return this.name;
	}

	public void addUser(User user) {
		users.add(user);
	}
}
