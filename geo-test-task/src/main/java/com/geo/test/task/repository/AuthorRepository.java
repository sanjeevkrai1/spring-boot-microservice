package com.geo.test.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geo.test.task.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

	List<Author> findByName(String authorName);

}
