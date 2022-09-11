package com.gongzone.dto.stock;

import com.gongzone.entity.stock.Stock;
import com.gongzone.entity.storage.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 재고수정 DTO
 * @author kangdonghyeon
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class StockUpdateDTO {
	private String stockName;
	private Long stockQuantity;
	private String stockDescription;
	private Storage storage;
	
	/* DTO -> Entity */
	public Stock toEntity() {
		Stock stock = Stock.builder()
				.stockName(stockName)
				.stockQuantity(stockQuantity)
				.stockDescription(stockDescription)
				.storage(storage)
				.build();
		return stock;
	}
}
