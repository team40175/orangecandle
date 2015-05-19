package com.orangecandle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty implements Serializable {

	private static final long serialVersionUID = 1020155658386277074L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id @Column(name = "id") Long id;
	private @Column(name = "name") String name;
	private transient @OneToMany List<Department> departments;

	public Faculty() {
	}

	public Faculty(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addDepartment(Department dep) {
		if (departments == null)
			departments = new ArrayList<Department>();
		departments.add(dep);
	}

	public List<Department> getDepartments() {
		return departments;
	}
}
