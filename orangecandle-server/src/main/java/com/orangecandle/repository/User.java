package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface User extends JpaRepository<com.orangecandle.domain.User, Long> {
}