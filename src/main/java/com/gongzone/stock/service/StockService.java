package com.gongzone.stock.service;

import java.util.List;

import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;

public interface StockService {
	public List<Stock> findStock();
	public StockDTO findStockByStockId(Long stockId);
	public void insertStock(StockDTO stockDTO);
	public void updateStock(StockDTO stockDTO);
	public void deleteStock(Long stockId);
}
