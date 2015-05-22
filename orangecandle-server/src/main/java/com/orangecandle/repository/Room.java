package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangecandle.domain.Building;

public interface Room extends JpaRepository<com.orangecandle.domain.Room, Long> {
	public com.orangecandle.domain.Room findByName(String name);

	public com.orangecandle.domain.Room findByNameAndBuilding(String name,
			Building building);
}
