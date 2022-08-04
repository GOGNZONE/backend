package com.gongzone.stock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gongzone.order.repository.OrderRepository;
import com.gongzone.stock.Repository.StockRepository;
import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.entity.Stock;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService{
	private final StockRepository stockRepo;
	
	@Override
	public List<Stock> findStock() {
		stockRepo.findAll();
		return null;
	}

	@Override
	public StockDTO findStockByStockId(Long stockId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStock(StockDTO stockDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStock(Long stockId, StockDTO stockDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStock(Long stockId) {
		// TODO Auto-generated method stub
		
	}

}
