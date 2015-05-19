package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Group extends
		JpaRepository<com.orangecandle.domain.Group, Long> {
	public com.orangecandle.domain.Group findByName(String name);
}
