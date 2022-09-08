package com.gongzone.dto.storage;

import com.gongzone.entity.storage.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 창고 수정 DTO
 * @author kangdonghyeon
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class StorageUpdateDTO {
	private String storageAddress;
	private String storageCategory;
	private String storageDescription;
	
	/* Entity -> DTO */
	public StorageUpdateDTO(Storage storage) {
		this.storageAddress = storage.getStorageAddress();
		this.storageCategory = storage.getStorageCategory();
		this.storageDescription = storage.getStorageDescription();
	}

}
