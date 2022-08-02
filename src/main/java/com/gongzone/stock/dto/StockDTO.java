package com.gongzone.stock.dto;

import com.gongzone.stock.entity.Stock;
import com.gongzone.storage.entity.Storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * ��� DTO
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
	
	/**
	 * StockDTO�� StockEntity�� ����
	 * @param {StockDTO}
	 * @return Stock
	 */

	
	public Stock toEntity(StockDTO stockDTO) {
		Stock stockEntity = Stock.builder()
				.stockId(stockDTO.getStockId())
				.stockName(stockDTO.getStockName())
				.stockQuantity(stockDTO.getStockQuantity())
				.stockDescription(stockDTO.getStockDescription())
				.storage(stockDTO.getStorage())
				.build();
		return stockEntity;
	}
}
