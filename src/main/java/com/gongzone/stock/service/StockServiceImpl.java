package com.gongzone.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.stock.Repository.StockRepository;
import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;

/**
 * 재고 서비스 인터페이스 구현체
 * @author kangdonghyeon
 * @version 1.0
 */

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockRepository stockRepo;
	
	/**
	 *  전체 재고 목록 조회
	 *  @return List<Stock>
	 */
	@Override
	public List<Stock> findStock() {
		return stockRepo.findAll();
	}
	
	
	
	/**
	 *  재고 코드(stockId)로 조회
	 *  @return StockDTO
	 */
	@Override
	public StockDTO findStockByStockId(Long stockId) {
		return stockRepo.findStockByStockId(stockId).toDTO(stockRepo.findStockByStockId(stockId));
	}

	
	/**
	 * 재고 등록
	 * @param { stockDTO }
	 * @return void
	 * */
	@Override
	public void insertStock(StockDTO stockDTO) {
		Stock stockEntity = stockDTO.toEntity(stockDTO);
		stockRepo.save(stockEntity);
	}

	
	/**
	 * 재고 코드(stockId)로 수정
	 * @param { stockId, stockDTO }
	 * @return void
	 * */
	@Override
	public void updateStock(Long stockId, StockDTO stockDTO) {
		Stock stock = findStockByStockId(stockDTO.getStockId()).toEntity(findStockByStockId(stockDTO.getStockId()));
		stock.updateStock(stockDTO.getStockName(), stockDTO.getStockQuantity(), stockDTO.getStockDescription());
		stockRepo.save(stock);
	}

	
	/**
	 * 재고 코드(stockId)로 삭제
	 * @param { stockId }
	 * @return void
	 * */
	@Override
	public void deleteStock(Long stockId) {
		stockRepo.deleteByStockId(stockId);
	}

}
