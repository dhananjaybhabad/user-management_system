package com.codewithdb.ums.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdb.ums.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
