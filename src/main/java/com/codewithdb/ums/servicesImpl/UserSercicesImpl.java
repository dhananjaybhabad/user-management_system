package com.codewithdb.ums.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codewithdb.ums.exception.ResourceNotFoundException;
import com.codewithdb.ums.model.User;
import com.codewithdb.ums.payload.UserDto;
import com.codewithdb.ums.repositories.UserRepository;
import com.codewithdb.ums.services.UserServices;

@Service
public class UserSercicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtoToUser(userDto);// dto to user for saving in db
		User savedUser = this.userRepository.save(user);// savedUser is a saved db variable

		return userToUserDto(savedUser);// user to dto for showing on ui
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		user.setFName(userDto.getFName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());

		User updatedUser = this.userRepository.save(user);

		UserDto userDto2 = this.userToUserDto(updatedUser);

		return userDto2;
	}

	@Override
	public UserDto getUserById(Integer userId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		return this.userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = this.userRepository.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());

		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepository.delete(user);

	}

	private User dtoToUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);

		return user;
	}

	private UserDto userToUserDto(User user) {

		UserDto userDto = this.modelMapper.map(user, UserDto.class);

		return userDto;
	}
}
