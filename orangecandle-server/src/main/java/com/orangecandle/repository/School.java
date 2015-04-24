package com.orangecandle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface School extends
	JpaRepository<com.orangecandle.domain.School, String>  {

}
