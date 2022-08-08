package com.gongzone.order.dto;

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

}
