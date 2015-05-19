package com.orangecandle.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class RepositoryService {
	private @Autowired com.orangecandle.repository.Group groupRep;
	private @Autowired com.orangecandle.repository.User userRep;
	private @Autowired com.orangecandle.repository.Lecture lectureRep;
	private @Autowired com.orangecandle.repository.Room roomRep;
	private @Autowired com.orangecandle.repository.School schoolRep;
	private @Autowired com.orangecandle.repository.Faculty facultyRep;
	private @Autowired com.orangecandle.repository.Department departmentRep;
	private @Autowired com.orangecandle.repository.Building buildingRep;
	private @Autowired com.orangecandle.repository.Constraint constraintRep;

	public JpaRepository<?, Long> get(String name) {
		switch (name.toLowerCase(Locale.ENGLISH)) {
		case "group":				return groupRep;
		case "user": case "xuser":	return userRep;
		case "lecture":				return lectureRep;
		case "room":				return roomRep;
		case "school":				return schoolRep;
		case "faculty":				return facultyRep;
		case "department":			return departmentRep;
		case "building":			return buildingRep;
		case "constraint":			return constraintRep;
		default:					return null;
		}
	}
	public JpaRepository<?, Long> get(Class<?> cls){
		return get(cls.getName());
	}
}
