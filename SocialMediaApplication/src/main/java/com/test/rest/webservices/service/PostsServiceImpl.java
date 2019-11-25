package com.test.rest.webservices.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.rest.webservices.exception.PostsNotFoundException;
import com.test.rest.webservices.exception.UserNotFoundException;
import com.test.rest.webservices.model.Posts;
import com.test.rest.webservices.model.User;
import com.test.rest.webservices.repository.PostRepository;
import com.test.rest.webservices.repository.UserRepository;

@Service
public class PostsServiceImpl implements PostsService {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<Posts> getAllPosts() {
		return postRepository.findAll();
	}

	@Override
	public Posts getPosts(Integer postId) throws PostsNotFoundException {
		return postRepository.findById(postId).orElseThrow(()-> new PostsNotFoundException("Post not found"));
	}

	@Override
	public Posts createPosts(@Valid Posts post , Integer userid) throws UserNotFoundException {
		User user = userRepository.findById(userid).orElseThrow(()-> new UserNotFoundException("User is missing.. Please create user first for saving posts."));
		post.setUser(user);
		
		return postRepository.save(post);
	}

	@Override
	public void delete() {
		postRepository.deleteAll();
	}

	@Override
	public void delete(Integer postId) throws PostsNotFoundException {
		Posts posts = postRepository.findById(postId).orElseThrow(()-> new PostsNotFoundException("Post not found"));
	
		postRepository.deleteById(posts.getId());
	}

}
