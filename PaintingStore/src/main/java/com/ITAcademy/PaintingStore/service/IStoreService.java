package com.ITAcademy.PaintingStore.service;

import java.util.List;

import com.ITAcademy.PaintingStore.dto.Store;

public interface IStoreService {

	// CRUD METHODS

	// Create store
	public Store createStore(Store store);

	// Get all store
	public List<Store> listStores();

	// Get store by id
	public Store getStore(Long id);

	// Update store
	public Store updateStore(Store store);

	// Delete store
	public void deleteStore(Long id);

}
