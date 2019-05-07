package com.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.dao.UserDAO;
import com.rest.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
	private UserDAO userDAO;
    
    public List<User> findAllUsers() {
    	List<User> listUsers = userDAO.listUsers();
    	return listUsers;
    }
     
    public User findById(long id) {
    	List<User> listUsers = userDAO.listUsers();
        for(User user : listUsers){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
     
    public User findByName(String name) {
    	List<User> listUsers = userDAO.listUsers();
        for(User user : listUsers){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }
     
    public void saveUser(User user) {
       userDAO.addUser(user);
    }
 
    public void updateUser(User user) {
      userDAO.updateUser(user);
    }
 
    public void deleteUserById(long id) {
         
       userDAO.removeUser(id);
    }
 
    public boolean isUserExist(User user) {
        return findByName(user.getName())!=null;
    }

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
 
   
 
//    public void deleteAllUsers() {
//        users.clear();
//    }
 
}
