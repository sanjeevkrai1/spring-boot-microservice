package com.test.rest.webservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.rest.webservices.bean.User;

@Component
public class UserService {

	private static List<User> list = new ArrayList<>();
	private static int id = 4;

	static {
		list.add(new User(1, "Sam", 31, new Date()));
		list.add(new User(2, "Mathu", 33, new Date()));
		list.add(new User(3, "Vikas", 32, new Date()));
		list.add(new User(4, "Shiva", 34, new Date()));
	}

	public List<User> findAll() {
		return list;
	}

	public User findById(int id) throws UserNotFoundException {
		return list.stream().filter(e -> e.getId() == id).findAny().orElseThrow(()-> new UserNotFoundException("id -> "+id));
	}

	public User createUser(User user) {
		user.setId(id++);
		list.add(user);
		return user;
	}
	
	public void deleteUser(int id) {
		list.remove(list.stream().filter(e->e.getId() == id).findAny().orElse(null));
	}
}
