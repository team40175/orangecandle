package com.orangecandle.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	Administrator, Advisor, Lecturer, Student;

	@Override
	public String getAuthority() {
		return name();
	}
}