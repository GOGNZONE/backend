package com.gongzone.production.dto;

import java.util.List;

import com.gongzone.client.dto.ReleaseClientDto;
import com.gongzone.release.entity.Release;
import com.gongzone.stock.entity.Stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 생산 상세 조회 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
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

	private List<Release> releases;
	
	private Stock stock;
	
}
