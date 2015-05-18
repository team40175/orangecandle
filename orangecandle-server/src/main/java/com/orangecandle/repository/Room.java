package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Room extends JpaRepository<com.orangecandle.domain.Room, Long> {
	public com.orangecandle.domain.Room findByName(String name);
}
