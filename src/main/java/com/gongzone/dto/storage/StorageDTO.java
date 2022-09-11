package com.gongzone.dto.storage;

import com.gongzone.entity.storage.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * 창고 DTO
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
	
	public static class StorageRequest {
		private String storageAddress;
		private String storageCategory;
		private String storageDescription;
		
		/* DTO -> Entity */
		public Storage toEntity() {
			Storage storage = Storage.builder()
					.storageAddress(storageAddress)
					.storageCategory(storageCategory)
					.storageDescription(storageDescription)
					.build();
			
			return storage;
		}
	}
	
	@Getter
	public static class StorageResponse {
		private Long storageId;
		private String storageAddress;
		private String storageCategory;
		private String storageDescription;
		
		/* Entity -> DTO */
		public StorageResponse(Storage storage) {
			this.storageId = storage.getStorageId();
			this.storageAddress = storage.getStorageAddress();
			this.storageCategory = storage.getStorageCategory();
			this.storageDescription = storage.getStorageDescription();
		}
	}
}
