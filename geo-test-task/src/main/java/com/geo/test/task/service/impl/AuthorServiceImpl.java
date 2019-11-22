package com.geo.test.task.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.test.task.exception.AuthorException;
import com.geo.test.task.model.Author;
import com.geo.test.task.repository.AuthorRepository;
import com.geo.test.task.repository.PublicationRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PublicationRepository publicationRepository;
	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public Author getAuthor(Integer id) {
		Optional<Author> authorObject = authorRepository.findById(id);
		try {
			return authorObject.orElseThrow(() -> new AuthorException("Author is not exists ", "405"));
		} catch (AuthorException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void removeAuthor(Integer id) {
		authorRepository.deleteById(id);
	}

	@Override
	public void removeAuthors() {
		publicationRepository.deleteAll();
		authorRepository.deleteAll();
	}

	@Override
	public Author saveAuthor(Author author) {
		Author aut1 = authorRepository.save(author);
		return aut1;
	}

	
	@Override
	public Author updateAuthor(Integer id, Author author) {
		try {
			Author authorObj = authorRepository.findById(id)
					.orElseThrow(() -> new AuthorException("Author is not exists ", "405"));

			authorObj.setName(author.getName());
			authorObj.setPublishers(author.getPublishers());
			return authorRepository.save(authorObj);
		} catch (AuthorException e) {
			e.printStackTrace();
		}

		return null;
	}

}
