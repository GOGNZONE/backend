package com.gongzone.bom.dto;

import com.gongzone.bom.entity.BOM;
import com.gongzone.storage.entity.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * BOM업데이트 DTO
 * @author kangdonghyeon
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BOMUpdateDTO {
	private String bomName;
	private int bomQuantity;
	private Long bomPrice;
	private String bomStandard;
	private String bomUnit;
	private String bomDescription;
	private String bomFile;
	private int bomRequiredQuntity;
	private Storage storage;
	private BOM bomParent;
}