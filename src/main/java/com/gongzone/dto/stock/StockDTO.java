package com.gongzone.dto.stock;


import com.gongzone.entity.stock.Stock;
import com.gongzone.entity.storage.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
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
	
	/* Entity -> DTO */
	public StockDTO(Stock stock){
		this.stockId = stock.getStockId();
		this.stockName = stock.getStockName();
		this.stockQuantity = stock.getStockQuantity();
		this.stockDescription = stock.getStockDescription();
		this.storage = stock.getStorage();
	}
	
	@Getter
	public static class StockRequest {
		private Long stockId;
		private String stockName;
		private Long stockQuantity;
		private String stockDescription;
		private Storage storage;
		
		/* DTO -> Entity */
		public Stock toEntity() {
			Stock stock = Stock.builder()
					.stockId(stockId)
					.stockName(stockName)
					.stockQuantity(stockQuantity)
					.stockDescription(stockDescription)
					.storage(storage)
					.build();
			return stock;
		}
	}
}
