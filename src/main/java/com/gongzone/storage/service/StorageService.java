package com.gongzone.storage.service;

import java.util.List;

import com.gongzone.storage.dto.StorageDTO;
import com.gongzone.storage.entity.Storage;

public interface StorageService {
	public List<Storage> findStorage();
	public StorageDTO findStorageByStorageId(Long storageId);
	public void insertStorage(StorageDTO storageDTO);
	public void updateStorage(StorageDTO storageDTO);
	public void deleteStorage(Long storageId);
}
