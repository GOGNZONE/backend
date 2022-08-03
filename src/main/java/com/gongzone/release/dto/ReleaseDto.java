package com.gongzone.release.dto;

import com.gongzone.release.entity.ReleaseType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 전체 출고 목록 조회, 출고 등록 Dto
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
	
	private ReleaseType releaseType;
	
}
