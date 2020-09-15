package com.ITAcademy.PaintingStore.service;

import java.util.List;
import com.ITAcademy.PaintingStore.dto.Painting;
import com.ITAcademy.PaintingStore.dto.Store;


public interface IPaintingService {

	// CRUD METHODS

		// Create painting
		public Painting addPainting(Painting painting);

		// Get all paintings
		public List<Painting> listAllPaintings();

		// Get painting from store
		public List<Painting> listPaintings(Store store);

		// Get painting by id
		public Painting getPainting(Long id);

		// Update painting
		public Painting updatePainting(Painting painting);

		// Delete painting
		public void deletePainting(Long id);
	
}
