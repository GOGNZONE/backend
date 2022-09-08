package com.gongzone.dto.production;

import com.gongzone.entity.client.Client;
import com.gongzone.entity.production.Production;
import com.gongzone.entity.stock.Stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 생산 품목 등록 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ProductionInsertUpdateDto {
	
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
	
	private String productionStartDate;
	
	private String productionEndDate;
	
	private Byte productionProgress;
	
	private Client client;
	
	private Stock stock;
	
	/* DTO -> Entity */
	public Production toEntity() {
		Production production = Production.builder()
				.productionId(productionId)
				.productionName(productionName)
				.productionBrandName(productionBrandName)
				.productionPrice(productionPrice)
				.productionQuantity(productionQuantity)
				.productionFile(productionFile)
				.productionStandard(productionStandard)
				.productionUnit(productionUnit)
				.productionDescription(productionDescription)
				.productionReleasedDate(productionReleasedDate)
				.productionStartDate(productionStartDate)
				.productionEndDate(productionEndDate)
				.productionProgress(productionProgress)
				.client(client)
				.stock(stock)
				.build();
		
		return production;
	}
	
}
