package com.gongzone.storage.service;

import java.util.List;

import javax.transaction.Transactional;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.gongzone.storage.dto.StorageDTO;
import com.gongzone.storage.entity.Storage;
import com.gongzone.storage.mapper.StorageMapper;
import com.gongzone.storage.repository.StorageRepository;

import lombok.RequiredArgsConstructor;


/**
 * 창고 서비스 인터페이스 구현체
 * @author kangdonghyeon
 * @version 1.0
 * */
@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

	
	private final StorageRepository storageRepo;
	private final StorageMapper storageMapper = Mappers.getMapper(StorageMapper.class);
	
	
	/**
	 *  전체 창고 조회
	 *  @return  List<Storage>
	 */
	@Override
	@Transactional
	public List<StorageDTO> findStorage() {
		List<Storage> storage =  storageRepo.findAll();
		return storageMapper.toDtoList(storage);
	}

	
	/**
	 * 창고 코드(storageId)로 조회
	 * @param { storageId }
	 * @return StorageDTO
	 * */
	@Override
	public StorageDTO findStorageByStorageId(Long storageId) {
		return storageMapper.toDto(storageRepo.findByStorageId(storageId));
	}

	
	/**
	 * 창고 등록
	 * @param { storageDTO }
	 * @return void
	 * */
	@Override
	public void insertStorage(StorageDTO storageDTO) {
		Storage storageEntity = storageMapper.toEntity(storageDTO);
		storageRepo.save(storageEntity);
	}

	/**
	 * 창고 수정(StorageId)로 생산 품목 수정
	 * @param { storageDTO }
	 * @return void
	 * */
	@Override
	public void updateStorage(StorageDTO storageDTO) {
		Storage storage = storageMapper.toEntity(findStorageByStorageId(storageDTO.getStorageId()));
		storage.updateStorage(storageDTO.getStorageAddress(), storageDTO.getStorageCategory(), storageDTO.getStorageDescription());
		storageRepo.save(storage);
	}

	/**
	 * 창고 코드(storageId)로 생산 품목 삭제
	 * @param { storageId }
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteStorage(Long storageId) {
		storageRepo.deleteByStorageId(storageId);
		
	}

}
