package com.gongzone.order.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 발주 DTO
 * @author kangdonghyeon
 * @version 1.0
 */

@Getter
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
	 * OrderDTO를 OrderEntity로 변환
	 * @param {OrderDTO}
	 * @return Order
	 */
}
