package com.gongzone.release.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 전체 출고 목록 조회 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReleaseListDto {
	
	private Long releaseId;
	
	private String releaseDate;
	
	private int releaseQuantity;
	
	private String releaseType;
	
//	private Byte releaseConfirmed;
	
	private String clientName;
	
	private String productionName;
	
}
