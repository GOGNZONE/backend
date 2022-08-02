package com.gongzone.storage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.storage.entity.Storage;


@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
	public List<Storage> findAll();
	public Storage findByStorageId(Long storageId);
	
	@Transactional
	public void deleteByStorageId(Long storageId);

}
