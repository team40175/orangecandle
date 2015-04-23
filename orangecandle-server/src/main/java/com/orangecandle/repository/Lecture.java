package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Lecture extends
		JpaRepository<com.orangecandle.domain.Lecture, String> {

}
