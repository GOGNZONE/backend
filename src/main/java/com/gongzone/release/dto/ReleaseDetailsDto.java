package com.gongzone.release.dto;

import com.gongzone.client.dto.ReleaseClientDto;
import com.gongzone.delivery.dto.DeliveryDto;
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
public class ReleaseDetailsDto {
	
	private Long releaseId;
	
	private String releaseDate;
	
	private String releaseDescription;
	
	private int releaseQuantity;
	
	private Long releaseTotalPrice;
	
	private String releaseType;
	
	// Client Info
	private ReleaseClientDto releaseClientDto;
	
	// Employee Info
//	private Employee employee;
	
	// Production Info
	private ReleaseProductionDto releaseProductionDto;
	
	// Delivery Info
	private DeliveryDto deliveryDto;
	
}
