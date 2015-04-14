package com.orangecandle.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orangecandle.dao.UserDAO;
import com.orangecandle.domain.User;

@Service
@Transactional
public class UserServiceImp implements UserService {
	private UserDAO user;
	
	@Override
	public void addUser(User p) {
		user.addUser(p);
	}

	@Override
	public void updateUser(User p) {
		user.updateUser(p);
	}

	@Override
	public List<User> listUsers() {
		return user.listUsers();
	}

	@Override
	public User getUserById(int id) {
		return user.getUserById(id);
	}

	@Override
	public void removeUser(int id) {
		user.removeUser(id);
	}
	
}
