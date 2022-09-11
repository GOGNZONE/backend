package com.gongzone.dto.release;

import com.gongzone.entity.client.Client;
import com.gongzone.entity.release.Delivery;
import com.gongzone.entity.release.Release;

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
	
	private Byte releaseConfirmed;
	
	private Client client;
	
	private String productionName;
	
	private Delivery delivery;
	
	/* Entity -> DTO */
	public ReleaseListDto(Release release) {
		this.releaseId = release.getReleaseId();
		this.releaseDate = release.getReleaseDate();
		this.releaseQuantity = release.getReleaseQuantity();
		this.releaseType = release.getReleaseType();
		this.releaseConfirmed = release.getReleaseConfirmed();
		this.client = release.getProduction().getClient();
		this.productionName = release.getProduction().getProductionName();
		this.delivery = release.getDelivery();
	}
	
}
