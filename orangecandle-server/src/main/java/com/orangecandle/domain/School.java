package com.orangecandle.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
	private @Column(name = "name") String name;
	private transient @OneToMany List<Faculty> faculties;
	private @OneToMany List<Building> buildings;

	public School() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public School(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addFaculty(Faculty... faculty) {
		if (faculties == null)
			faculties = new ArrayList<Faculty>();
		this.faculties.addAll(Arrays.asList(faculty));
	}

	public List<Faculty> listFaculty() {
		return this.faculties;
	}

	public void addBuilding(Building... building) {
		if (buildings == null) {
			buildings = new LinkedList<Building>();
		}
		this.buildings.addAll(Arrays.asList(building));
	}
}
