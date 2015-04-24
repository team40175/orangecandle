package com.orangecandle.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="faculty")
public class Faculty {
	private @Id @Column(name = "id") String id;
	private @Column(name = "facultyname") String name;
	private @OneToMany List<Department> departments;
	
}
