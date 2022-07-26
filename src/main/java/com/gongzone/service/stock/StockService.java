package com.gongzone.service.stock;

import java.util.List;

import com.gongzone.dto.stock.StockDTO;
import com.gongzone.dto.stock.StockDTO.StockRequest;
import com.gongzone.dto.stock.StockListDTO;
import com.gongzone.dto.stock.StockUpdateDTO;


/**
 * 재고 서비스 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 */

public interface StockService {
	/**
	 *  전체 재고 조회
	 *  @return List<StockDTO>
	 */
	public List<StockListDTO> findStock();
	

	/**
	 * 재고코드(stockId)로 조회
	 * @param { stockId }
	 * @return StockDTO
	 * */
	public StockDTO findStockByStockId(Long stockId);
	
	/**
	 * 재고 등록
	 * @param { stockRequest }
	 * @return void
	 * */
	public void insertStock(StockRequest stockRequest);
	
	
	/**
	 * 재고 코드(stockId)로 수정
	 * @param { stockId, stockDTO }
	 * @return void
	 * */
	public void updateStock(Long stockId, StockUpdateDTO updateDTO);
	
	/**
	 * 재고 코드(stockId)로 삭제
	 * @param { stockId }
	 * @return void
	 * */
	public void deleteStock(Long stockId);
}
