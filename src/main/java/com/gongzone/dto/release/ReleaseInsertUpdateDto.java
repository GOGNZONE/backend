package com.gongzone.dto.release;

import com.gongzone.entity.production.Production;
import com.gongzone.entity.release.Delivery;
import com.gongzone.entity.release.Release;

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
	
	/* DTO -> Entity */
	public Release toEntity() {
		Release release = Release.builder()
				.releaseId(releaseId)
				.releaseDate(releaseDate)
				.releaseDescription(releaseDescription)
				.releaseQuantity(releaseQuantity)
				.releaseTotalPrice(releaseTotalPrice)
				.releaseType(releaseType)
				.releaseConfirmed(releaseConfirmed)
				.production(production)
				.delivery(delivery)
				.build();
		return release;
	}
	
}
