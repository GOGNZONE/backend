package com.gongzone.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.stock.Repository.StockRepository;
import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;



@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockRepository stockRepo;
	
	@Override
	public List<Stock> findStock() {
		return stockRepo.findAll();
	}

	@Override
	public StockDTO findStockByStockId(Long stockId) {
		return stockRepo.findStockByStockId(stockId).toDTO(stockRepo.findStockByStockId(stockId));
	}

	@Override
	public void insertStock(StockDTO stockDTO) {
		Stock stockEntity = stockDTO.toEntity(stockDTO);
		stockRepo.save(stockEntity);
	}

	@Override
	public void updateStock(StockDTO stockDTO) {
		Stock stock = findStockByStockId(stockDTO.getStockId()).toEntity(findStockByStockId(stockDTO.getStockId()));
		stock.updateStock(stockDTO.getStockName(), stockDTO.getStockQuantity(), stockDTO.getStockDescription());
		stockRepo.save(stock);
	}

	@Override
	public void deleteStock(Long stockId) {
		stockRepo.deleteByStockId(stockId);
	}

}
