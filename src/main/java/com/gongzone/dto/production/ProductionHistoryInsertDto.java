package com.gongzone.dto.production;

import com.gongzone.entity.production.Production;
import com.gongzone.entity.production.ProductionHistory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 생산 이력 등록 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductionHistoryInsertDto {
	
	private Long productionHistoryId;
	
	private Byte productionHistoryType;
	
	private String productionHistoryCorrectionDate;
	
	private String productionHistoryDescription;
	
	private Production production;
	
	/* DTO -> Entity */
	public ProductionHistory toEntity() {
		ProductionHistory productionHistory = ProductionHistory.builder()
				.productionHistoryId(productionHistoryId)
				.productionHistoryType(productionHistoryType)
				.productionHistoryCorrectionDate(productionHistoryCorrectionDate)
				.productionHistoryDescription(productionHistoryDescription)
				.production(production)
				.build();
		return productionHistory;
	}
	
}
