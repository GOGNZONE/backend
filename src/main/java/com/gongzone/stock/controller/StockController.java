package com.gongzone.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;
import com.gongzone.stock.service.StockServiceImpl;




@RestController  //JSON을 반환하는 컨트롤러
public class StockController {
	@Autowired
	public StockServiceImpl stockService;
	
	@GetMapping(value="/api/stock/list")
	public List<Stock> getStock(){
		return stockService.findStock();

	}
	
	@GetMapping(value="/api/stock/{stockId}")
	public StockDTO getStockbyid(@PathVariable Long stockId){
		return stockService.findStockByStockId(stockId);
	}
	
	@PostMapping(value="/api/stock")
	public void insertStock(@RequestBody StockDTO stockDTO) {
		stockService.insertStock(stockDTO);
	}
	@PutMapping(value="/api/stock")
	public void updateStock(@RequestBody StockDTO stockDTO) {
		stockService.updateStock(stockDTO);
	}
	@DeleteMapping(value="/api/stock/{stockId}")
	public void deleteStock(@PathVariable Long stockId) {
		stockService.deleteStock(stockId);
	}
	
	
}

