package com.gongzone.release.dto;

import com.gongzone.dto.client.ReleaseClientDto;
import com.gongzone.production.dto.ReleaseProductionDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 출고 상세 조회 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReleaseDto {
	
	private Long releaseId;
	
	private String releaseDate;
	
	private String releaseDescription;
	
	private int releaseQuantity;
	
	private Long releaseTotalPrice;
	
	private String releaseType;
	
	private Byte releaseConfirmed;
	
	// Client Info
	private ReleaseClientDto client;
	
	// Production Info
	private ReleaseProductionDto production;
	
	// Delivery Info
	private DeliveryDto delivery;
	
}
