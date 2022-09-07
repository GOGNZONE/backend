package com.gongzone.production.dto;

import com.gongzone.entity.client.Client;
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
	
}
