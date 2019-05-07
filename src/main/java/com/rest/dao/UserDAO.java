package com.rest.dao;

import java.util.List;


import com.rest.model.User;

public interface UserDAO {
	public void addUser(User p);
	public void updateUser(User p);
	public List<User> listUsers();
	public User getUserById(long id);
	public void removeUser(long id);
}
