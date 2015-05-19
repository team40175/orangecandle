package com.orangecandle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface User extends JpaRepository<com.orangecandle.domain.User, Long> {
	public com.orangecandle.domain.User findByUsername(String username);

	@Query("select u.groups from User u where u.username=:username")
	public List<com.orangecandle.domain.Group> findGroupsByUsername(
			@Param("username") String username);
}