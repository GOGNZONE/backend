package com.gongzone.repository.storage;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongzone.entity.storage.Storage;

/**
 * 창고 Repositroy
 * @author kangdonghyeon
 * @version 1.0
 */
@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
	public Optional<Storage> findByStorageId(Long storageId);
	public Optional<Storage> deleteByStorageId(Long storageId);

}
