package com.codewithdb.ums.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codewithdb.ums.payload.ApiResponse;
import com.codewithdb.ums.payload.UserDto;
import com.codewithdb.ums.services.UserServices;

@RestController
@RequestMapping("/api/ums")
public class UserController {

	@Autowired
	private UserServices userServices;

	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {

		UserDto createUserDto = this.userServices.createUser(userDto);

		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") Integer uId) {

		// @PathVariable Integer userId)
		UserDto updateUser = this.userServices.updateUser(userDto, uId);

		return ResponseEntity.ok(updateUser);

	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uId) {

		this.userServices.deleteUser(uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {

		return ResponseEntity.ok(this.userServices.getAllUsers());

	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {

		UserDto userById = this.userServices.getUserById(userId);

		return ResponseEntity.ok(userById);
	}

}
