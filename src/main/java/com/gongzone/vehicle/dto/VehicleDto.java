package com.gongzone.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 배송 차량 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VehicleDto {
	
	private Long vehicleId;
	
	private String vehicleNumber;
	
	private String vehicleType;
	
}
