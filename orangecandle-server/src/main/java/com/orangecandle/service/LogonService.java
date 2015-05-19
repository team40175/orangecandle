package com.orangecandle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.orangecandle.repository.User;

@Component
public class LogonService implements UserDetailsService {
	private @Autowired User repo;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return repo.findByUsername(username);
	}

}
