package com.gongzone.release.dto;

import com.gongzone.production.entity.Production;
import com.gongzone.release.entity.Delivery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 출고 등록, 수정 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ReleaseInsertUpdateDto {
	
	private Long releaseId;
	
	private String releaseDate;
	
	private String releaseDescription;
	
	private int releaseQuantity;
	
	private Long releaseTotalPrice;
	
	private String releaseType;
	
	private Byte releaseConfirmed;
	
	private Production production;
	
	private Delivery delivery;
	
}
