package com.gongzone.dto.production;

import com.gongzone.entity.production.ProductionHistory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 생산 이력 조회 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductionHistoryListDto {
	
	private Long productionHistoryId;
	
	private int productionHistoryType;
	
	private String productionHistoryCorrectionDate;
	
	private String productionHistoryDescription;
	
	/* Entity -> DTO */
	public ProductionHistoryListDto(ProductionHistory productionHistory) {
		this.productionHistoryId = productionHistory.getProductionHistoryId();
		this.productionHistoryType = productionHistory.getProductionHistoryType();
		this.productionHistoryCorrectionDate = productionHistory.getProductionHistoryCorrectionDate();
		this.productionHistoryDescription = productionHistory.getProductionHistoryDescription();
	}
}
