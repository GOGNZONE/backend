package com.gongzone.storage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.storage.dto.StorageDTO;
import com.gongzone.storage.entity.Storage;
import com.gongzone.storage.repository.StorageRepository;


/**
 * 창고 서비스 인터페이스 구현체
 * @author kangdonghyeon
 * @version 1.0
 * */
@Service
public class StorageServiceImpl implements StorageService {

	@Autowired
	public StorageRepository storageRepo;
	
	/**
	 *  전체 창고 조회
	 *  @return  List<Storage>
	 */
	@Override
	public List<Storage> findStorage() {
		return storageRepo.findAll();
	}

	/**
	 * 창고 코드(storageId)로 조회
	 * @param { storageId }
	 * @return StorageDTO
	 * */
	@Override
	public StorageDTO findStorageByStorageId(Long storageId) {
		return storageRepo.findByStorageId(storageId).toDTO(storageRepo.findByStorageId(storageId));
	}

	
	/**
	 * 창고 등록
	 * @param { storageDTO }
	 * @return void
	 * */
	@Override
	public void insertStorage(StorageDTO storageDTO) {
		Storage storageEntity = storageDTO.toEntity(storageDTO);
		storageRepo.save(storageEntity);
		
	}

	/**
	 * 창고 수정(StorageId)로 생산 품목 수정
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
	 * 창고 코드(storageId)로 생산 품목 삭제
	 * @param { storageId }
	 * @return void
	 * */
	@Override
	public void deleteStorage(Long storageId) {
		storageRepo.deleteByStorageId(storageId);
		
	}

}
