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

import com.geo.test.task.model.Publication;
import com.geo.test.task.service.impl.PublicationService;

@RestController
@RequestMapping("/rest")
public class PublicationResource {

	@Autowired
	private PublicationService publicationService;

	@GetMapping("/publications/{id}")
	public Publication getPublication(@PathVariable Integer id) {
		return publicationService.getPublication(id);
	}

	@GetMapping("/publications")
	public List<Publication> getAuthors() {
		return publicationService.getPublications();
	}

	@PutMapping("/publications/{id}")
	public Publication updatePublication(@PathVariable("id") Integer id, @RequestBody Publication publication) {
		return publicationService.updatePublication(id, publication);
	}

	@PostMapping("/{authorId}/publications")
	public Publication createPublication(@PathVariable("authorId") Integer authorId,
			@RequestBody Publication publication) {
		return publicationService.savePublication(authorId, publication);
	}

	@DeleteMapping("/publications/{id}")
	private ResponseEntity<?> removePublication(@PathVariable("id") Integer pubId) {
		publicationService.removePublication(pubId);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/publications")
	private ResponseEntity<?> removeAllAuthors() {
		publicationService.removePublications();

		return ResponseEntity.ok().build();
	}
}
