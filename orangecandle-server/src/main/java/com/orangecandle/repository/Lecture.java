package com.orangecandle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Lecture extends
		JpaRepository<com.orangecandle.domain.Lecture, Long> {
	public com.orangecandle.domain.Lecture findByCode(String code);

	@Query("select u.takenLectures from User u where u.username = :username")
	public List<com.orangecandle.domain.Lecture> findTakenLecturesOf(
			@Param("username") String username);
}
