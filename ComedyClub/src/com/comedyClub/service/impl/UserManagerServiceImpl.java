package com.comedyClub.service.impl;

import com.comedyClub.dao.IUserDao;
import com.comedyClub.domain.User;
import com.comedyClub.dto.UserDto;
import com.comedyClub.service.IUserManagerService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserManagerServiceImpl implements IUserManagerService {
	
	IUserDao userDao;
	
	public UserManagerServiceImpl() {
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	private UserDto makeUserDto(User user) {
		UserDto userDto = new UserDto();
		
		userDto.setId(user.getId());
		userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());

        return userDto;
	}

	private List<UserDto> makeUserDtoSet(List<User> users) {
		List<UserDto> usersDto = new ArrayList<UserDto>();

        for (Object user1 : users) {
            User user = (User) user1;

            usersDto.add(makeUserDto(user));
        }
		
		return usersDto;
	}

	public UserDto registerNewUser(UserDto userDto) {
		User user = new User();
		
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());        
        userDao.save(user);
		return makeUserDto(user);
	}

	public void updateUser(UserDto userDto) {
		User user = userDao.getById(userDto.getId());
		
		user.setName(userDto.getName());
		userDao.update(user);	
	}

	public void deleteUser(Long userId) {
		userDao.deleteById(userId);
	}

	public UserDto getUserByNameAndPassword(String name, String password) {
		User user = userDao.getByNameAndPassword(name, password);
		
		return makeUserDto(user);
	}

	public UserDto getUserById(Long userId) {
		User user = userDao.getById(userId);
		
		return makeUserDto(user);
	}

	public void addFriend(Long userId, Long friendId) {
		User user = userDao.getById(userId);
		User friend = userDao.getById(friendId);
		
		user.addFriend(friend);
		userDao.update(user);
	}

	public void deleteFriend(Long userId, Long friendId) {
		User user = userDao.getById(userId);
		User friend = userDao.getById(friendId);
		
		user.getFriends().remove(friend);
		
		userDao.update(user);
	}
	
	public List<UserDto> getAllUsers() {
		return makeUserDtoSet(userDao.getAllUsers());
	}

    public List<UserDto> getUsersByName(String name) {
        return makeUserDtoSet(userDao.getUsersByName(name));
    }

    public List<UserDto> getAllFriends(Long userId) {
		User user = userDao.getById(userId);
        List<User> friends = new ArrayList<User>();
        friends.addAll(user.getFriends());
        return makeUserDtoSet(friends);
	}

}
