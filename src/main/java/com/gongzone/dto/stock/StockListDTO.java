package com.gongzone.dto.stock;

import com.gongzone.entity.stock.Stock;

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
	
	public StockListDTO(Stock stock) {
		this.stockId = stock.getStockId();
		this.stockName = stock.getStockName();
		this.stockQuantity = stock.getStockQuantity();
		this.stockDescription = stock.getStockDescription();
	}

}
