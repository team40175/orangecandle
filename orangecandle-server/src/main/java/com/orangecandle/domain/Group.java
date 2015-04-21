package com.orangecandle.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Group {
	
	private @Id long id;
	
	String name;
	
	private @ManyToMany List<User> users;
	private List<Role> roles;

	public List<User> getUsers() {
		return users;
	}
}
