package com.gongzone.stock.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.dto.StockUpdateDTO;
import com.gongzone.stock.service.StockServiceImpl;

import lombok.RequiredArgsConstructor;



/**
 * 재고 Controller
 * @author kangdonghyeon
 * @version 1.0
 * */


@RestController  
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockController {
	private final StockServiceImpl stockService;
	
	/**
	 *  전체 재고 조회
	 *  @return List<StockDTO>
	 */
	@GetMapping("/list")
	public List<StockDTO> getStock(){
		return stockService.findStock();
	}
	
	
	/**
	 * 재고코드(stockId)로 조회
	 * @param { stockId }
	 * @return StockDTO
	 * */
	@GetMapping("/{stockId}")
	public StockDTO getStockbyid(@PathVariable Long stockId){
		return stockService.findStockByStockId(stockId);
	}
	
	/**
	 * 재고 등록
	 * @param { stockDTO }
	 * @return void
	 * */
	@PostMapping("")
	public void insertStock(@RequestBody StockDTO stockDTO) {
		stockService.insertStock(stockDTO);
	}
	
	
	/**
	 * 재고 코드(stockId)로 수정
	 * @param { stockId, stockDTO }
	 * @return void
	 * */
	@PutMapping("/{stockId}")
	public void updateStock(@PathVariable Long stockId, @RequestBody StockUpdateDTO updateDto) {
		stockService.updateStock(stockId, updateDto);
	}
	
	/**
	 * 재고 코드(stockId)로 삭제
	 * @param { stockId }
	 * @return void
	 * */
	@DeleteMapping("/{stockId}")
	public void deleteStock(@PathVariable Long stockId) {
		stockService.deleteStock(stockId);
	}
}

