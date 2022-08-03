package com.gongzone.release.dto;

import com.gongzone.release.entity.ReleaseType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 출고 상세 조회 Dto (출고방식이 '차량'일 때)
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReleaseDetailsVehicleDto {
	
	private Long releaseId;
	
	private String releaseDate;
	
	private String releaseDescription;
	
	private int releaseQuantity;
	
	private Long releaseTotalPrice;
	
	private ReleaseType releaseType;
	
	private Client client;
	
}
