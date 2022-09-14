package com.gongzone.dto.release;

import com.gongzone.dto.client.ReleaseClientDto;
import com.gongzone.dto.production.ReleaseProductionDto;
import com.gongzone.entity.release.Delivery;
import com.gongzone.entity.release.Release;

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
	private Delivery delivery;
	
	public ReleaseDto(Release release) {
		this.releaseId = release.getReleaseId();
		this.releaseDate = release.getReleaseDate();
		this.releaseDescription = release.getReleaseDescription();
		this.releaseQuantity = release.getReleaseQuantity();
		this.releaseTotalPrice = release.getReleaseTotalPrice();
		this.releaseType = release.getReleaseType();
		this.releaseConfirmed = release.getReleaseConfirmed();
		this.client = new ReleaseClientDto(release.getProduction().getClient());
		this.production = new ReleaseProductionDto(release.getProduction());
		this.delivery = release.getDelivery();

	}
	
}
