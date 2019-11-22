package com.geo.test.task.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geo.test.task.model.Author;
import com.geo.test.task.service.impl.AuthorService;

@RestController
@RequestMapping("/rest/")
public class AuthorResource {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/authors")
	public List<Author> getAuthors() {
		return authorService.getAuthors();
	}

	@GetMapping("/authors/{id}")
	public Author getAuthor(@PathVariable("id") Integer autherId) {
		return authorService.getAuthor(autherId);
	}

	@PostMapping("/authors")
	public Author createAuthor(@RequestBody Author author) {
		return authorService.saveAuthor(author);
	}

	@PutMapping("/authors/{id}")
	public void updateAuthor(@PathVariable("id") Integer authorId, @RequestBody Author authorDto) {
		authorService.updateAuthor(authorId, authorDto);
	}

	@DeleteMapping("/authors/{id}")
	private ResponseEntity<?> removeAuthor(@PathVariable("id") Integer authorId) {
		authorService.removeAuthor(authorId);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/authors")
	private ResponseEntity<?> removeAllAuthors() {
		authorService.removeAuthors();

		return ResponseEntity.ok().build();
	}

}
