package com.comedyClub.dao;

import com.comedyClub.domain.User;

import java.util.List;

public interface IUserDao {
	void save(User user);
	void update(User user);
	User getById(Long userId);
	User getByNameAndPassword(String name, String password);	
	void delete(User user);
	void deleteById(Long userId);
	
	List<User> getAllUsers();
    List<User> getUsersByName(String name);
}
