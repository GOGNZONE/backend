package com.gongzone.dto.production;

import com.gongzone.entity.production.Production;

//import com.gongzone.stock.entity.Stock;

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
	
	private int productionQuantity;
	
//	private Stock stock;
	
	public ReleaseProductionDto(Production production) {
		this.productionName = production.getProductionName();
		this.productionBrandName = production.getProductionBrandName();
		this.productionPrice = production.getProductionPrice();
		this.productionQuantity = production.getProductionQuantity();
	}
	
}
