package com.gongzone.dto.production;

import java.util.List;

import com.gongzone.entity.production.Production;
import com.gongzone.entity.release.Release;

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
public class ProductionListDto {
	
	private Long productionId;
	
	private String productionName;
	
	private String productionBrandName;
	
	private Long productionPrice;
	
	private int productionQuantity;
	
	private String productionDescription;
	
	private Byte productionProgress;
	
	private String productionReleasedDate;
	
	private String productionEndDate;
	
	private List<Release> releases;
	
	/* Entity -> DTO */
	public ProductionListDto(Production production) {
		this.productionId = production.getProductionId();
		this.productionName = production.getProductionName();
		this.productionBrandName = production.getProductionBrandName();
		this.productionPrice = production.getProductionPrice();
		this.productionQuantity = production.getProductionQuantity();
		this.productionDescription = production.getProductionDescription();
		this.productionProgress = production.getProductionProgress();
		this.productionReleasedDate = production.getProductionReleasedDate();
		this.productionEndDate = production.getProductionEndDate();
		this.releases = production.getReleases();
	}
	
}
