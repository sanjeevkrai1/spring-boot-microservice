package com.test.rest.webservices.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.webservices.exception.UserNotFoundException;
import com.test.rest.webservices.model.User;
import com.test.rest.webservices.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Integer userId) throws Exception {
		return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not found"));
	}

	@Override
	public User createUser(User user) {
		User userObj = userRepository.findByUserId(user.getUserId());
		Predicate<User> userPredicate = (usr) -> usr != null;
		if (userPredicate.test(userObj)) {
			return null;
		} else {
			user.setCreatedAt(new Date());
			user.setUpdatedAt(new Date());
			return userRepository.save(user);

		}

	}

	@Override
	public User updateUser(Integer userId, User user) {

		User usr = userRepository.findById(userId).orElse(null);

		usr.setfName(user.getfName());
		usr.setlName(user.getlName());
		usr.setmName(user.getmName());
		usr.setfName(user.getfName());
		usr.setEmail(user.getEmail());
		usr.setPassword(user.getPassword());

		return userRepository.save(usr);
	}

	@Override
	public void deleteUser(Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent())
			userRepository.delete(user.get());
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
		;
	}

}
