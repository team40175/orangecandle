package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Department extends
		JpaRepository<com.orangecandle.domain.Department, Long> {

}
