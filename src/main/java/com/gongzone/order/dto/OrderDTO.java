package com.gongzone.order.dto;

import java.time.LocalDateTime;

import com.gongzone.order.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order DTO
 * @author kangdonghyeon
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderDTO {
	private Long orderId;
	private String orderProductionName;
	private String orderProductionBrandName;
	private Long orderProductionPrice;
	private int orderProductionQuantity;
	private String orderProuctionFile;
	private String orderProductionStandard;
	private String orderProductionUnit;
	private String orderProductionDescription;
	private String orderProductionEndDate;
	private LocalDateTime orderDate;
	private Long fkClientId;

	
	/**
	 * OrderDTO를 OrderEntity로 변경
	 * @param {OrderDTO}
	 * @return OrderDTO를 OrderEntity로 변경한 값
	 */
	
	
	public Order toEntity(OrderDTO orderDTO) {
		Order orderEntity = Order.builder()
				.orderId(orderDTO.getOrderId())
				.orderProductionName(orderDTO.getOrderProductionName())
				.orderProductionBrandName(orderDTO.getOrderProductionBrandName())
				.orderProductionPrice(orderDTO.getOrderProductionPrice())
				.orderProductionQuantity(orderDTO.getOrderProductionQuantity())
				.orderProuctionFile(orderDTO.getOrderProuctionFile())
				.orderProductionStandard(orderDTO.getOrderProductionStandard())
				.orderProductionUnit(orderDTO.getOrderProductionUnit())
				.orderProductionDescription(orderDTO.getOrderProductionDescription())
				.orderProductionEndDate(orderDTO.getOrderProductionEndDate())
				.orderDate(orderDTO.getOrderDate())
				.fkClientId(orderDTO.getFkClientId())
				.build();
		return orderEntity;
	}
	
	
}
