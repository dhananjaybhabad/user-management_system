package com.codewithdb.ums.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "user_details")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(name = "first_name", nullable = false, length = 100)
	private String fName;

	@Column(name = "last_name", nullable = false, length = 100)
	private String lName;

	@Column(name = "password", nullable = false, length = 100)
	private String password;

	@Column(name = "email_id", nullable = false, length = 100)
	private String email;

	@Column(name = "phone_number", nullable = false, length = 100)
	private Double phoneNo;

	@Column(name = "date_of_birth", nullable = false, length = 100)
	private String dob;

	@Column(name = "gender", nullable = false, length = 100)
	private String gender;

	@Column(name = "country_name", nullable = false, length = 100)
	private String country;

	@Column(name = "state_name", nullable = false, length = 100)
	private String state;

	@Column(name = "city_name", nullable = false, length = 100)
	private String city;

	@Column(name = "created_date", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;

	@Column(name = "updated_date", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;

	@Column(name = "is_active_switch")
	private String isActive;
}
