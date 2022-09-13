package com.gongzone.service.implement.storage;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gongzone.dto.storage.StorageDTO.StorageRequest;
import com.gongzone.dto.storage.StorageDTO.StorageResponse;
import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;
import com.gongzone.dto.storage.StorageUpdateDTO;
import com.gongzone.entity.storage.Storage;
import com.gongzone.repository.storage.StorageRepository;
import com.gongzone.service.storage.StorageService;

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
	
	/**
	 *  전체 창고 조회
	 *  @return  List<StorageDTOStorageResponse
	 */
	@Override
	@Transactional
	public List<StorageResponse> findStorage() {
		List<StorageResponse> storage =  storageRepo.findAll()
				.stream()
				.map(StorageResponse::new)
				.collect(Collectors.toList());
		
		return storage;
				
	}

	
	/**
	 * 창고 코드(storageId)로 조회
	 * @param { storageId }
	 * @return StorageDTO
	 * */
	@Override
	public StorageResponse findStorageByStorageId(Long storageId) {
		Storage storage = storageRepo.findByStorageId(storageId)
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		
		return new StorageResponse(storage);
	}

	
	/**
	 * 창고 등록
	 * @param { StorageRequest }
	 * @return void
	 * */
	@Override
	public void insertStorage(StorageRequest request) {
		storageRepo.save(request.toEntity());
	}

	/**
	 * 창고 수정(StorageId)로 생산 품목 수정
	 * @param { storageId, StorageUpdateDTO }
	 * @return void
	 * */
	@Override
	public void updateStorage(Long storageId, StorageUpdateDTO updateDTO) {
		Storage storage = storageRepo.findByStorageId(storageId)
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		
		storage.updateStorage(updateDTO.getStorageAddress(), updateDTO.getStorageCategory(), updateDTO.getStorageDescription());
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
		storageRepo.deleteByStorageId(storageId).orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		
	}

}
