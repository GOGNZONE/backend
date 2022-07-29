package com.gongzone.dto;

import com.gongzone.entity.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Storage DTO
 * @author kangdonghyeon
 * @version 1.0
 */



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StorageDTO {
	private Long storageId;
	private String storageAddress;
	private String storageCategory;
	private String storageDescription;


	/**
	 * StorageDTO를 StorageEntity로 변경
	 * @param {StorageDTO}
	 * @return StorageEntity를 StorageDTO로 변경한 값
	 */
	
	public Storage toEntity(StorageDTO storageDTO) {
		Storage storageEntity = Storage.builder()
				.storageId(storageDTO.getStorageId())
				.storageAddress(storageDTO.getStorageAddress())
				.storageCategory(storageDTO.getStorageCategory())
				.storageDescription(storageDTO.getStorageDescription())
				.build();
		return storageEntity;
	}

	
	
}
