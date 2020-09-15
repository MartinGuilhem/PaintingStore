package com.ITAcademy.PaintingStore.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.PaintingStore.dto.Painting;
import com.ITAcademy.PaintingStore.dto.Store;
import com.ITAcademy.PaintingStore.service.PaintingService;

@RestController
@RequestMapping("/api")
public class PaintingController {

	// Use of methods from Service
	@Autowired
	PaintingService paintingService;

	// Create painting
	@PostMapping("/stores/{id}/painting")
	public Painting addPainting(@PathVariable(name = "id") Store store, @RequestBody Painting painting) {
		painting.setAuthor(painting.getAuthor());
		painting.setStore(store);
		painting.setDate(new Date(System.currentTimeMillis()));
		return paintingService.addPainting(painting);
	}

	// Get all paintings
	@GetMapping("/paintings")
	public List<Painting> listAllPaintings() {
		return paintingService.listAllPaintings();
	}

	// Get paintings from store
	@GetMapping("/store/{id}/paintings")
	public List<Painting> listPaintings(@PathVariable(name = "id") Store store) {
		return paintingService.listPaintings(store);
	}

	// Get painting by id
	@GetMapping("/paintings/{id}")
	public Painting getPainting(@PathVariable(name = "id") Long id) {
		return paintingService.getPainting(id);
	}

	// Update painting
	@PutMapping("/paintings/{id}")
	public Painting updatePainting(@PathVariable(name = "id") Long id, @RequestBody Painting painting) {
		Painting paintingToUpdate = paintingService.getPainting(id);
		paintingToUpdate.setTitle(painting.getTitle());
		paintingToUpdate.setAuthor(painting.getAuthor());
		paintingToUpdate.setPrice(painting.getPrice());
		return paintingService.updatePainting(paintingToUpdate);
	}

	// Delete painting
	@DeleteMapping("/paintings/{id}")
	public void deletePainting(@PathVariable(name = "id") Long id) {
		paintingService.deletePainting(id);
	}

	// Delete all paintings from store
	@DeleteMapping("/burn/{id}")
	public void burnPaintings(@PathVariable(name = "id") Store store) {
		List<Painting> paintings = store.getPaintings();
		for (Painting p : paintings) {
			Long paintingId = p.getId();
			paintingService.deletePainting(paintingId);
		}

	}

}
