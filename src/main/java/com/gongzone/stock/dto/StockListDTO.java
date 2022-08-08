package com.gongzone.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 재고리스트 DTO
 * @author kangdonghyeon
 * @version 1.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StockListDTO {
	private Long stockId;
	private String stockName;
	private Long stockQuantity;
	private String stockDescription;

}
