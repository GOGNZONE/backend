package com.gongzone.order.dto;

import java.time.LocalDateTime;

import com.gongzone.client.entity.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
	private String orderProuctionFile;
	private String orderProductionStandard;
	private String orderProductionUnit;
	private String orderProductionDescription;
	private String orderProductionEndDate;
	private LocalDateTime orderDate;
	private Client client;
}
