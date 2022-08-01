package com.gongzone.production.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 생산 품목 코드(production_id)로 생산 품목 조회 DTO
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductionDTO {
	
	private Long productionId;
	
	private String productionName;
	
	private String productionBrandName;
	
	private Long productionPrice;
	
	private int productionQuantity;
	
	private String productionFile;
	
	private String productionStandard;
	
	private String productionUnit;
	
	private String productionDescription;
	
	private String productionReleasedDate;
	
	private String productionDate;
	
}
