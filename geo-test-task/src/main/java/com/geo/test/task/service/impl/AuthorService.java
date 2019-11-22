package com.geo.test.task.service.impl;

import java.util.List;

import com.geo.test.task.model.Author;

public interface AuthorService {

	List<Author> getAuthors();
	void removeAuthor(Integer authorId);
	void removeAuthors();
	Author getAuthor(Integer authorId);
	Author saveAuthor(Author author);
	Author updateAuthor(Integer authorId, Author author);

}
