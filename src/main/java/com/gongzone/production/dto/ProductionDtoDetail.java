package com.gongzone.production.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 전체 생산 품목 조회 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductionDtoDetail {
	
	private Long productionId;
	
	private String productionName;
	
	private String productionBrandName;
	
	private Long productionPrice;
	
	private int productionQuantity;
	
	private String productionDescription;
	
}
