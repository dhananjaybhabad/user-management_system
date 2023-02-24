package com.codewithdb.ums.payload;

import lombok.Data;

@Data
public class UserDto {

	private int userId;

	private String fName;

	private String lName;

    private String password;

	private String email;

	private Double phoneNo;

	private String dob;

	private String gender;

	private String country;

	private String state;

	private String city;
}
