package com.gongzone.stock.dto;


import com.gongzone.storage.entity.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 재고 DTO
 * @author kangdonghyeon
 * @version 1.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StockDTO {
	private Long stockId;
	private String stockName;
	private Long stockQuantity;
	private String stockDescription;
	private Storage storage;
}
