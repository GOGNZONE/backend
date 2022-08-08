package com.gongzone.production.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 출고 상세 조회 상품 정보 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReleaseProductionDto {
	
	private String productionName;
	
	private String productionBrandName;
	
	private Long productionPrice;
	
}
