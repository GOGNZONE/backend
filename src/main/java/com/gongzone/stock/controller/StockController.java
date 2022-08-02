package com.gongzone.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;
import com.gongzone.stock.service.StockServiceImpl;



/**
 * ��� ��Ʈ�ѷ�
 * @author Hanju Park
 * @version 1.0
 * */


@RestController  //JSON�� ��ȯ�ϴ� ��Ʈ�ѷ�
@RequestMapping("/api/production")

public class StockController {
	@Autowired
	public StockServiceImpl stockService;
	
	/**
	 *  ��ü ��� ��ȸ
	 *  @return List<Stock>
	 */
	@GetMapping("/list")
	public List<Stock> getStock(){
		return stockService.findStock();
	}
	
	
	/**
	 * ��� �ڵ�(stockId)�� ��ȸ
	 * @param { stockId }
	 * @return StockDTO
	 * */
	@GetMapping("/{stockId}")
	public StockDTO getStockbyid(@PathVariable Long stockId){
		return stockService.findStockByStockId(stockId);
	}
	
	
	/**
	 * ��� ���
	 * @param { stockDTO }
	 * @return void
	 * */
	@PostMapping("")
	public void insertStock(@RequestBody StockDTO stockDTO) {
		stockService.insertStock(stockDTO);
	}
	
	
	/**
	 * ��� �ڵ�(stockId)�� ����
	 * @param { stockId, stockDTO }
	 * @return void
	 * */
	@PutMapping("/{stockId}")
	public void updateStock(@PathVariable Long stockId, @RequestBody StockDTO stockDTO) {
		stockService.updateStock(stockId, stockDTO);
	}
	
	
	/**
	 * ��� �ڵ�(stockId)�� ����
	 * @param { stockId }
	 * @return void
	 * */
	@DeleteMapping("/{stockId}")
	public void deleteStock(@PathVariable Long stockId) {
		stockService.deleteStock(stockId);
	}
	
	
}

