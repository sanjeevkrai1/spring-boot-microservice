package com.test.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.rest.webservices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserId(String userId);

}
