package com.gongzone.dto.release;

import com.gongzone.entity.release.Delivery;

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
	
	/* Entity -> DTO*/
	public DeliveryDto(Delivery delivery) {
		this.deliveryId = delivery.getDeliveryId();
		this.deliveryCompanyName = delivery.getDeliveryCompanyName();
		this.deliveryTrackingNumber = delivery.getDeliveryTrackingNumber();
	}
}
