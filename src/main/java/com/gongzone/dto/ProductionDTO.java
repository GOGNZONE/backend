package com.gongzone.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 생산 DTO
 * @author Hanju Park
 * @version 1.0
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductionDTO {
	
	private Long productionId;
	
	private String productionName;
	
	private String productionBrandName;
	
	private Long productionPrice;
	
	private int productionQuantity;
	
	private String productionStandard;
	
	private String productionUnit;
	
	private String productionDescription;
	
	private LocalDate productionReleaseDate;
	
	private LocalDate productionDate;
}
