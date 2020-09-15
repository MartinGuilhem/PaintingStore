package com.ITAcademy.PaintingStore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ITAcademy.PaintingStore.dto.Store;


public interface IStoreDAO extends JpaRepository<Store, Long> {

}
