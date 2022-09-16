package com.gongzone.dto.order;

import com.gongzone.entity.client.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 발주업데이트 DTO
 * @author kangdonghyeon
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderUpdateDTO {
	private String orderProductionName;
	private String orderProductionBrandName;
	private Long orderProductionPrice;
	private int orderProductionQuantity;
	private String orderProductionStandard;
	private String orderProductionUnit;
	private String orderProductionDescription;
	private String orderProductionEndDate;
	private Client client;


	/* DTO -> Entity */
	public OrderUpdateDTO toEntity() {
		OrderUpdateDTO order = OrderUpdateDTO.builder()
			.orderProductionName(orderProductionName)
			.orderProductionBrandName(orderProductionBrandName)
			.orderProductionPrice(orderProductionPrice)
			.orderProductionQuantity(orderProductionQuantity)
			.orderProductionStandard(orderProductionStandard)
			.orderProductionUnit(orderProductionUnit)
			.orderProductionDescription(orderProductionDescription)
		.orderProductionEndDate(orderProductionEndDate)
		.client(client)
		.build();
	return order;
}
}


