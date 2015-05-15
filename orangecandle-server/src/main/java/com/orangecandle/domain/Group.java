package com.orangecandle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "xgroup")
public class Group implements Serializable {
	private static final long serialVersionUID = -7552509806260167080L;
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id") Long id;
	private @Column(name = "name") String name;

	private @ManyToMany(fetch = FetchType.LAZY) List<User> users;

	@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
	private @Enumerated(EnumType.STRING) List<Role> roles;

	public Group() {
	}
	public Long getId(){
		return this.id;
	}
	public void setId(Long id){
		this.id=id;
	}
	public Group(String groupName) {
		this.name = groupName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setGroupName(String name) {
		this.name = name;
	}

	public String getGroupName() {
		return this.name;
	}

	public void addUser(User user) {
		if(users==null) users= new ArrayList<User>();
		users.add(user);
	}

	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\"}";
	}
}
