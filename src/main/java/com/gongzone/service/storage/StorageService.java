package com.gongzone.service.storage;

import java.util.List;

import com.gongzone.dto.storage.StorageDTO.StorageRequest;
import com.gongzone.dto.storage.StorageDTO.StorageResponse;
import com.gongzone.dto.storage.StorageUpdateDTO;

/**
 * 창고 서비스 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
public interface StorageService {
	/**
	 *  전체 창고 조회
	 *  @return  List<StorageDTO>
	 */
	public List<StorageResponse> findStorage();
	
	/**
	 * 창고 코드(storageId)로 조회
	 * @param { storageId }
	 * @return StorageDTO
	 * */
	public StorageResponse findStorageByStorageId(Long storageId);
	
	/**
	 * 창고 등록
	 * @param { storageDTO }
	 * @return void
	 * */
	public void insertStorage(StorageRequest request);
	
	/**
	 * 창고 수정(production_id)로 생산 품목 수정
	 * @param { stockId, storageDTO } 
	 * @return void
	 * */
	public void updateStorage(Long stockId, StorageUpdateDTO updateDTO);
	
	/**
	 * 창고 코드(storageId)로 생산 품목 삭제
	 * @param { storageId }
	 * @return void
	 * */
	public void deleteStorage(Long storageId);
}
