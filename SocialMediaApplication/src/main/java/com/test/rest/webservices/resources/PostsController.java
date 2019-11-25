package com.test.rest.webservices.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.rest.webservices.exception.PostsNotFoundException;
import com.test.rest.webservices.exception.UserNotFoundException;
import com.test.rest.webservices.model.Posts;
import com.test.rest.webservices.service.PostsService;

@RestController
@RequestMapping("/rest")
public class PostsController {
	
	@Autowired
	private PostsService postsService;
	
	@GetMapping("/posts")
	public List<Posts> getAllPosts(){
		return postsService.getAllPosts();
	}
	
	@GetMapping("/posts/{postId}")
	public Posts getPosts(@PathVariable("postId") Integer postId) throws PostsNotFoundException{
		return postsService.getPosts(postId);
	}

	@PostMapping("/{userId}/posts")
	public ResponseEntity<Object> createPost(@PathVariable("userId")Integer userId, @Valid @RequestBody Posts post) throws UserNotFoundException {
		Posts savedUser = postsService.createPosts(post , userId);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").build(savedUser.getId());
		return  ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/posts")
	public void delete() {
		postsService.delete();
	}
	
	@DeleteMapping("/posts/{post_id}")
	public void deletePosts(@PathVariable("post_id") Integer postId) throws PostsNotFoundException {
		postsService.delete(postId);
	}
}
