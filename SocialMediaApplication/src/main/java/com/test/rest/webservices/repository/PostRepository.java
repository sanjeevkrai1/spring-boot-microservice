package com.test.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.rest.webservices.model.Posts;

@Repository
public interface PostRepository extends JpaRepository<Posts, Integer> {

}
