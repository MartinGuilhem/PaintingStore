package com.ITAcademy.PaintingStore.controller;

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

import com.ITAcademy.PaintingStore.dto.Store;
import com.ITAcademy.PaintingStore.service.StoreService;


@RestController
@RequestMapping("/api")
public class StoreController {

//	// Use of methods from Service
	@Autowired
	StoreService storeService;

	// Create store
	@PostMapping("/stores")
	public Store createStore(@RequestBody Store store) {
		return storeService.createStore(store);
	}

	// Get all stores
	@GetMapping("/stores")
	public List<Store> listStores() {
		return storeService.listStores();
	}

	// Get store by id
	@GetMapping("/stores/{id}")
	public Store getStore(@PathVariable(name = "id") Long id) {
		return storeService.getStore(id);
	}

	// Update store
	@PutMapping("/stores/{id}")
	public Store updateStore(@PathVariable(name = "id") Long id, @RequestBody Store store) {

		Store storeToUpdate = storeService.getStore(id);
		storeToUpdate.setName(store.getName());
		storeToUpdate.setCapacity(store.getCapacity());
		return storeService.updateStore(storeToUpdate);
	}

	// Delete store
	@DeleteMapping("/stores/{id}")
	public void deleteStore(@PathVariable(name = "id")Long id) {
		storeService.deleteStore(id);
		// TODO - burn all books from shop???
	}

	
}
