package com.geo.test.task.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geo.test.task.model.Publication;
import com.geo.test.task.service.impl.PublicationService;

@RestController
@RequestMapping("/rest")
public class SearchResource {

	@Autowired
	PublicationService publicationService;

	@GetMapping("/search/publications/{name}/{year}")
	public List<Publication> searchPublicaitons(@PathVariable("name") String authorName,
			@PathVariable("year") Integer year) {
		return publicationService.searchPublicaitons(authorName, year);
	}
	
	@GetMapping("/publications/{name}/{arbitaryValue}")
	public List<Publication> getPublicaitons(@PathVariable("name") String authorName,
			@PathVariable("arbitaryValue") String arbitaryValue) {
		return publicationService.getPublicaitons(authorName, arbitaryValue);
	}

}
