package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangecandle.domain.Faculty;

public interface Department extends
		JpaRepository<com.orangecandle.domain.Department, Long> {

	public com.orangecandle.domain.Department findByNameAndFaculty(String name,
			Faculty faculty);

}
