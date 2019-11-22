package com.geo.test.task.service.impl;

import java.util.List;

import com.geo.test.task.model.Publication;

public interface PublicationService {

	Publication getPublication(Integer id);

	List<Publication> getPublications();

	Publication updatePublication(Integer id, Publication publication);

	Publication savePublication(Integer authorId ,Publication publication);

	void removePublications();

	void removePublication(Integer pubId);

	List<Publication> searchPublicaitons(String authorName, Integer year);
	List<Publication> getPublicaitons(String authorName, String arbitaryValue);

}
