package com.ITAcademy.PaintingStore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ITAcademy.PaintingStore.dto.Painting;
import com.ITAcademy.PaintingStore.dto.Store;


public interface IPaintingDAO extends JpaRepository<Painting, Long> {
	
	List<Painting> findAllByStore(Store store);
}
