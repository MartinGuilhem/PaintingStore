package com.ITAcademy.PaintingStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.PaintingStore.dao.IStoreDAO;
import com.ITAcademy.PaintingStore.dto.Store;

@Service
public class StoreService implements IStoreService {

	// Use of methods from repository DAO
	@Autowired
	IStoreDAO iStoreDAO;

	// Create store
	@Override
	public Store createStore(Store store) {
		return iStoreDAO.save(store);
	}

	// Get all stores
	@Override
	public List<Store> listStores() {
		return iStoreDAO.findAll();
	}

	// Get store by id
	@Override
	public Store getStore(Long id) {
		return iStoreDAO.findById(id).get();
	}

	// Update store
	@Override
	public Store updateStore(Store store) {
		return iStoreDAO.save(store);
	}

	// Delete store
	@Override
	public void deleteStore(Long id) {
		iStoreDAO.deleteById(id);
		// TODO - burn all books from shop???
	}

}
