package com.gongzone.production.dto;

import java.util.List;

import com.gongzone.release.entity.Release;

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
	
}
