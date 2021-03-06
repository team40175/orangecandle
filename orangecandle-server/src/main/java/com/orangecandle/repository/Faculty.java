package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Faculty extends
		JpaRepository<com.orangecandle.domain.Faculty, Long> {

	public com.orangecandle.domain.Faculty findByName(String name);
}
