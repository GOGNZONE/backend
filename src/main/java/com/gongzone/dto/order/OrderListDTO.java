package com.gongzone.dto.order;

import com.gongzone.entity.order.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 발주리스트 DTO
 * @author kangdonghyeon
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderListDTO {
	private Long orderId;
	private String orderProductionName;
	private String orderProductionBrandName;
	private Long orderProductionPrice;
	private int orderProductionQuantity;
	private String orderProductionDescription;
	
	public OrderListDTO(Order order) {
		this.orderId = order.getId();
		this.orderProductionName = order.getOrderProductionName();
		this.orderProductionBrandName = order.getOrderProductionBrandName();
		this.orderProductionPrice = order.getOrderProductionPrice();
		this.orderProductionQuantity = order.getOrderProductionQuantity();
		this.orderProductionDescription = order.getOrderProductionDescription();
	}

}
