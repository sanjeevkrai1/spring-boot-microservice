package com.test.rest.webservices.service;

import java.util.List;

import javax.validation.Valid;

import com.test.rest.webservices.exception.PostsNotFoundException;
import com.test.rest.webservices.exception.UserNotFoundException;
import com.test.rest.webservices.model.Posts;

public interface PostsService {

	List<Posts> getAllPosts();

	Posts getPosts(Integer postId) throws PostsNotFoundException;

	Posts createPosts(@Valid Posts post , Integer userId) throws UserNotFoundException;

	void delete();

	void delete(Integer postId) throws PostsNotFoundException;
	

}
