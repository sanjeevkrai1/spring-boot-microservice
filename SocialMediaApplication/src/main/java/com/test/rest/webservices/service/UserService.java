package com.test.rest.webservices.service;

import java.util.List;

import com.test.rest.webservices.model.User;

public interface UserService {

	List<User> getUsers();

	User getUser(Integer userId) throws Exception;
	User createUser(User user);
	User updateUser(Integer userId, User user);
	void deleteUser(Integer userId);

	void deleteAll();

}
