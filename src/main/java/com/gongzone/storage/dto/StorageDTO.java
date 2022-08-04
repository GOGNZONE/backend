package com.gongzone.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
}
