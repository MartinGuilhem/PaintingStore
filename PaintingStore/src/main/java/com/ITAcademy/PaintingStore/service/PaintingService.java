package com.ITAcademy.PaintingStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.PaintingStore.dao.IPaintingDAO;
import com.ITAcademy.PaintingStore.dto.Painting;
import com.ITAcademy.PaintingStore.dto.Store;


@Service
public class PaintingService implements IPaintingService {

	
	// Use of methods from repository DAO
		@Autowired
		IPaintingDAO iPaintingDAO;

		// Create painting
		@Override
		public Painting addPainting(Painting painting) {
			return iPaintingDAO.save(painting);
		}

		// Get all Paintings
		@Override
		public List<Painting> listAllPaintings() {
			return iPaintingDAO.findAll();
		}

		// Get Paintings from store
		@Override
		public List<Painting> listPaintings(Store store) {
			return iPaintingDAO.findAllByStore(store);
		}

		// Get Painting by id
		@Override
		public Painting getPainting(Long id) {
			return iPaintingDAO.findById(id).get();
		}

		// Update Painting
		@Override
		public Painting updatePainting(Painting painting) {
			return iPaintingDAO.save(painting);
		}

		// Delete Painting
		@Override
		public void deletePainting(Long id) {
			iPaintingDAO.deleteById(id);
		}

}
