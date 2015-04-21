package com.orangecandle.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class User {
	
	private @Id int id;
	
	private String userName;
	
	private @ManyToMany List<Group> groups;

	public List<Group> getGroups() {
		return groups;
	}
}
