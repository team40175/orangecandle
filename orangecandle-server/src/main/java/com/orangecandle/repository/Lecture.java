package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Lecture extends
		JpaRepository<com.orangecandle.domain.Lecture, Long> {
	public com.orangecandle.domain.Lecture findByCode(String code);
}
