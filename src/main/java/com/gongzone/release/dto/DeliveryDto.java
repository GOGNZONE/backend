package com.gongzone.release.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 택배 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DeliveryDto {
	
	private Long deliveryId;
	
	private String deliveryCompanyName;
	
	private String deliveryTrackingNumber;
	
}
