package com.orangecandle.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "xgroup")
public class Group {

	private @Id long id;

	String name;

	private @ManyToMany List<User> users;
	@ElementCollection(targetClass = Role.class)
	private @Enumerated(EnumType.STRING) List<Role> roles;

	public List<User> getUsers() {
		return users;
	}
}
