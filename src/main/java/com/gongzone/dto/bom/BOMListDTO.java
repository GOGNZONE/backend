package com.gongzone.dto.bom;

import com.gongzone.entity.bom.BOM;

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
	
	public BOMListDTO(BOM bom) {
		this.bomId = bom.getBomId();
		this.bomName = bom.getBomName();
		this.bomQuantity = bom.getBomQuantity();
		this.bomDescription = bom.getBomDescription();
		this.bomPrice = bom.getBomPrice();
	}
	
}
