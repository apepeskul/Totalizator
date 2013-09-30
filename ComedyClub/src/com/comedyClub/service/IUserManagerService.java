package com.comedyClub.service;

import com.comedyClub.dto.UserDto;

import java.util.List;

public interface IUserManagerService {
	UserDto registerNewUser(UserDto userDto);
	void updateUser(UserDto userDto);
	void deleteUser(Long userId);
	UserDto getUserByNameAndPassword(String name, String password);
	UserDto getUserById(Long userId);
	void addFriend(Long userId, Long friendId);
	void deleteFriend(Long userId, Long friendId);
	
	List<UserDto> getAllUsers();
	List<UserDto> getUsersByName(String name);    
    List<UserDto> getAllFriends(Long userId);
}
