package com.geo.test.task.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.test.task.exception.PublicationException;
import com.geo.test.task.model.Author;
import com.geo.test.task.model.Book;
import com.geo.test.task.model.Comics;
import com.geo.test.task.model.Magazine;
import com.geo.test.task.model.Publication;
import com.geo.test.task.repository.AuthorRepository;
import com.geo.test.task.repository.PublicationRepository;

@Service
public class PublicationServiceImpl implements PublicationService {

	@Autowired
	private PublicationRepository publicationRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public Publication getPublication(Integer id) {

		Optional<Publication> pubObj = publicationRepository.findById(id);
		try {
			return pubObj.orElseThrow(() -> new PublicationException("Publication is not exists ", "405"));
		} catch (PublicationException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Publication> getPublications() {
		return publicationRepository.findAll();
	}

	@Override
	public Publication updatePublication(Integer id, Publication publication) {
		Optional<Publication> pubObj = publicationRepository.findById(id);
		try {
			Publication pub = pubObj.orElseThrow(() -> new PublicationException("Publication is not exists ", "405"));
			pub.setName(publication.getName());
			return publicationRepository.save(pub);

		} catch (PublicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Publication savePublication(Integer authroId, Publication publication) {
		Book book = new Book();
		Magazine magazine = new Magazine();
		Comics comics = new Comics();

		Optional<Author> author = authorRepository.findById(authroId);

		if (publication.getGenre() != null && !publication.getGenre().equals("")) {
			book.setAuthor(publication.getAuthor());
			book.setGenre(publication.getGenre());
			book.setName(publication.getName());
			book.setTitle(publication.getTitle());
			book.setYear(publication.getYear());
			book.setAuthor(author.orElse(null));
			return publicationRepository.save(book);
		} else if (publication.getType() != null && !publication.getType().equals("")) {
			comics.setAuthor(publication.getAuthor());
			comics.setType(publication.getType());
			comics.setName(publication.getName());
			comics.setTitle(publication.getTitle());
			comics.setYear(publication.getYear());
			comics.setAuthor(author.orElse(null));
			return publicationRepository.save(comics);
		} else if (publication.getHero() != null && !publication.getHero().equals("")) {
			magazine.setAuthor(publication.getAuthor());
			magazine.setHero(publication.getHero());
			magazine.setName(publication.getName());
			magazine.setTitle(publication.getTitle());
			magazine.setYear(publication.getYear());
			magazine.setAuthor(author.orElse(null));
			return publicationRepository.save(magazine);
		}

		return null;
	}

	@Override
	public void removePublications() {
		publicationRepository.deleteAll();
		authorRepository.deleteAll();
	}

	@Override
	public void removePublication(Integer pubId) {
		publicationRepository.deleteById(pubId);
	}

	@Override
	public List<Publication> searchPublicaitons(String authorName, Integer year) {
		List<Author> authList = authorRepository.findByName(authorName);
		List<Publication> list = new ArrayList<>();
		for (Author author : authList) {
			List<Publication> pubList = publicationRepository.findByAuthorAndYear(author, year);
			list.addAll(pubList);
		}
		return list;
	}

	@Override
	public List<Publication> getPublicaitons(String authorName, String arbitaryValue) {

		List<Author> authList = authorRepository.findByName(authorName);
		List<Publication> list = new ArrayList<>();
		for (Author author : authList) {

//			Optional<Author> authOptional = authorRepository.findById(author.getId());
//			Author author2 = authOptional.orElse(null);
//			if(author2 != null )
//					list.addAll(author2.getPublishers());

			List<Publication> list1 = publicationRepository.findByAuthor(author);

			list.addAll(list1);

		}

		// List<Publication> list = publicationRepository.findByAuthors(new
		// HashSet<Author>(authList));

		return list.stream()
				.filter(e -> (e.getHero() != null && e.getHero().equals(arbitaryValue))
						|| (e.getType() != null && e.getType().equals(arbitaryValue))
						|| (e.getGenre() != null && e.getGenre().equals(arbitaryValue)))
				.collect(Collectors.toList());
	}

}
