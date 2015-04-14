package com.orangecandle.service;

import java.util.List;

import com.orangecandle.domain.User;

public interface UserService {
	public void addUser(User p);
    public void updateUser(User p);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);
}
