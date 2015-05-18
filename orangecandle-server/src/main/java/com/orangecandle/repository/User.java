package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User extends JpaRepository<com.orangecandle.domain.User, Long> {
	public com.orangecandle.domain.User findByUsername(String username);
}