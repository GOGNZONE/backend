package com.gongzone.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.stock.Repository.StockRepository;
import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;

/**
 * ��� ���� �������̽� ����ü
 * @author kangdonghyeon
 * @version 1.0
 */

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockRepository stockRepo;
	
	/**
	 *  ��ü ��� ��� ��ȸ
	 *  @return List<Stock>
	 */
	@Override
	public List<Stock> findStock() {
		return stockRepo.findAll();
	}
	
	
	
	/**
	 *  ��� �ڵ�(stockId)�� ��ȸ
	 *  @return StockDTO
	 */
	@Override
	public StockDTO findStockByStockId(Long stockId) {
		return stockRepo.findStockByStockId(stockId).toDTO(stockRepo.findStockByStockId(stockId));
	}

	
	/**
	 * ��� ���
	 * @param { stockDTO }
	 * @return void
	 * */
	@Override
	public void insertStock(StockDTO stockDTO) {
		Stock stockEntity = stockDTO.toEntity(stockDTO);
		stockRepo.save(stockEntity);
	}

	
	/**
	 * ��� �ڵ�(stockId)�� ����
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
	 * ��� �ڵ�(stockId)�� ����
	 * @param { stockId }
	 * @return void
	 * */
	@Override
	public void deleteStock(Long stockId) {
		stockRepo.deleteByStockId(stockId);
	}

}
