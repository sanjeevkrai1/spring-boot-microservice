package com.geo.test.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geo.test.task.model.Author;
import com.geo.test.task.model.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer>{
	List<Publication> findByNameAndYear(String authorName, Integer year);

	List<Publication> findByAuthorAndYear(Author author, Integer year);

	List<Publication>  findByAuthor(Author author);

	//List<Publication> findByAuthors(HashSet<Author> hashSet);
}
