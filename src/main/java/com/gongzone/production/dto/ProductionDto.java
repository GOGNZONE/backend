package com.gongzone.production.dto;

import com.gongzone.client.entity.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 생산 품목 상세 조회, 생산 품목 등록 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
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
	
	private Client client;
	
}
