package com.gongzone.dto.production;

import java.util.List;
import java.util.stream.Collectors;

import com.gongzone.dto.client.ReleaseClientDto;
import com.gongzone.dto.release.ReleaseDto;
import com.gongzone.entity.production.Production;
import com.gongzone.entity.stock.Stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 생산 상세 조회 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductionDetailsDto {
	
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
	private ReleaseClientDto client;
	private List<ReleaseDto> releases;
	private Stock stock;
	private List<ProductionHistoryListDto> productionHistory;
	
	/** Entity -> DTO */
	public ProductionDetailsDto(Production production) {
		this.productionId = production.getProductionId();
		this.productionName = production.getProductionName();
		this.productionBrandName = production.getProductionBrandName();
		this.productionPrice = production.getProductionPrice();
		this.productionQuantity = production.getProductionQuantity();
		this.productionFile = production.getProductionFile();
		this.productionStandard = production.getProductionStandard();
		this.productionUnit = production.getProductionUnit();
		this.productionDescription = production.getProductionDescription();
		this.productionReleasedDate = production.getProductionReleasedDate();
		this.productionStartDate = production.getProductionStartDate();
		this.productionEndDate = production.getProductionEndDate();
		this.productionProgress = production.getProductionProgress();
		this.client = new ReleaseClientDto(production.getClient());
		this.releases = production.getReleases().stream().map(ReleaseDto::new).collect(Collectors.toList());
		this.stock = production.getStock();
		this.productionHistory = production.getProductionHistory().stream().map(ProductionHistoryListDto::new).collect(Collectors.toList());
	}

}
