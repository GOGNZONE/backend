package com.gongzone.bom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * BOM리스트 DTO
 * @author kangdonghyeon
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BOMListDTO {
	private Long bomId;
	private String bomName;
	private int bomQuantity;
	private String bomDescription;
	private Long bomPrice;
	
}
