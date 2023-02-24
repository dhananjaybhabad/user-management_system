package com.codewithdb.ums.services;

import java.util.List;

import com.codewithdb.ums.payload.UserDto;

public interface UserServices {

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

}
