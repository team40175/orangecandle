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
@Table(name = "school")
public class School implements Serializable {

	private static final long serialVersionUID = 2003514288583381509L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id @Column(name = "id") Long id;
	private @Column(name = "schoolname") String schoolName;
	private transient @OneToMany List<Faculty> faculties;

	public School() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public School(String name) {
		schoolName = name;
	}

	public String getName() {
		return schoolName;
	}

	public void setName(String name) {
		this.schoolName = name;
	}

	public void addFaculty(Faculty fac) {
		if (faculties == null)
			faculties = new ArrayList<Faculty>();
		this.faculties.add(fac);
	}

	public List<Faculty> listFaculty() {
		return this.faculties;
	}
}
