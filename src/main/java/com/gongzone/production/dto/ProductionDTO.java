package com.gongzone.production.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 생산 관련 요청/응답에 대한 Dto (전체 생산 품목 조회 제외)
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductionDto {
	
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
