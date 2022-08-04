package com.gongzone.storage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.storage.dto.StorageDTO;
import com.gongzone.storage.entity.Storage;
import com.gongzone.storage.repository.StorageRepository;


/**
 * â�� ���� �������̽� ����ü
 * @author kangdonghyeon
 * @version 1.0
 * */
@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	public StorageRepository storageRepo;
	
	/**
	 *  ��ü â�� ��ȸ
	 *  @return  List<Storage>
	 */
	@Override
	public List<Storage> findStorage() {
		return storageRepo.findAll();
	}

	/**
	 * â�� �ڵ�(storageId)�� ��ȸ
	 * @param { storageId }
	 * @return StorageDTO
	 * */
	@Override
	public StorageDTO findStorageByStorageId(Long storageId) {
		return storageRepo.findByStorageId(storageId).toDTO(storageRepo.findByStorageId(storageId));
	}

	
	/**
	 * â�� ���
	 * @param { storageDTO }
	 * @return void
	 * */
	@Override
	public void insertStorage(StorageDTO storageDTO) {
		Storage storageEntity = storageDTO.toEntity(storageDTO);
		storageRepo.save(storageEntity);
		
	}

	
	/**
	 * â�� ����(StorageId)�� ���� ǰ�� ����
	 * @param { storageDTO }
	 * @return void
	 * */
	@Override
	public void updateStorage(StorageDTO storageDTO) {
		Storage storage = findStorageByStorageId(storageDTO.getStorageId()).toEntity(findStorageByStorageId(storageDTO.getStorageId()));
		storage.updateStorage(storageDTO.getStorageAddress(), storageDTO.getStorageCategory(), storageDTO.getStorageDescription());
		storageRepo.save(storage);
		
	}

	/**
	 * â�� �ڵ�(storageId)�� ���� ǰ�� ����
	 * @param { storageId }
	 * @return void
	 * */
	@Override
	public void deleteStorage(Long storageId) {
		storageRepo.deleteByStorageId(storageId);
		
	}

}
