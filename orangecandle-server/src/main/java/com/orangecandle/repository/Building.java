package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Building extends
		JpaRepository<com.orangecandle.domain.Building, Long> {
}
