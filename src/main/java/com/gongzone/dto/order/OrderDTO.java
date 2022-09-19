package com.gongzone.dto.order;

import java.time.LocalDate;

import com.gongzone.entity.client.Client;
import com.gongzone.entity.order.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 발주 DTO
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
	private String orderProductionStandard;
	private String orderProductionUnit;
	private String orderProductionDescription;
	private String orderProductionEndDate;
	private LocalDate orderDate;
	private Client client;
	
	@Data
	public static class OrderRequest {
		private Long orderId;
		private String orderProductionName;
		private String orderProductionBrandName;
		private Long orderProductionPrice;
		private int orderProductionQuantity;
		private String orderProductionStandard;
		private String orderProductionUnit;
		private String orderProductionDescription;
		private String orderProductionEndDate;
		private LocalDate orderDate;
		private Client client;
		
		/* DTO -> Entity */
		public Order toEntity() {
			Order order = Order.builder()
					.orderId(orderId)
					.orderProductionName(orderProductionName)
					.orderProductionBrandName(orderProductionBrandName)
					.orderProductionPrice(orderProductionPrice)
					.orderProductionQuantity(orderProductionQuantity)
					.orderProductionStandard(orderProductionStandard)
					.orderProductionUnit(orderProductionUnit)
					.orderProductionDescription(orderProductionDescription)
					.orderProductionEndDate(orderProductionEndDate)
					.orderDate(orderDate)
					.client(client)
					.build();
			return order;
		}
	}
	
	@Getter
	public static class OrderResponse {
		private Long orderId;
		private String orderProductionName;
		private String orderProductionBrandName;
		private Long orderProductionPrice;
		private int orderProductionQuantity;
		private String orderProductionStandard;
		private String orderProductionUnit;
		private String orderProductionDescription;
		private String orderProductionEndDate;
		private LocalDate orderDate;
		private Client client;
		
		public OrderResponse(Order order) {
			this.orderId = order.getId();
			this.orderProductionName = order.getOrderProductionName();
			this.orderProductionBrandName = order.getOrderProductionBrandName();
			this.orderProductionPrice = order.getOrderProductionPrice();
			this.orderProductionQuantity = order.getOrderProductionQuantity();
			this.orderProductionStandard = order.getOrderProductionStandard();
			this.orderProductionUnit = order.getOrderProductionUnit();
			this.orderProductionDescription = order.getOrderProductionDescription();
			this.orderProductionEndDate = order.getOrderProductionEndDate();
			this.orderDate = order.getOrderDate();
			this.client = order.getClient();
		}
	}
}
