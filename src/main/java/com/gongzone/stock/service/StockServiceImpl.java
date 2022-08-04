package com.gongzone.stock.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.order.repository.OrderRepository;
import com.gongzone.stock.Repository.StockRepository;
import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.dto.StockUpdateDTO;
import com.gongzone.stock.entity.Stock;
import com.gongzone.stock.mapper.StockMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService{
	private final StockRepository stockRepo;
	private final StockMapper stockMapper = Mappers.getMapper(StockMapper.class);
	
	@Override
	public List<StockDTO> findStock() {
		List<Stock> list = stockRepo.findAll();
		return stockMapper.toDtoList(list);
	}

	@Override
	public StockDTO findStockByStockId(Long stockId) {
		return toDTO(stockRepo.findStockByStockId(stockId));
	}

	@Override
	public void insertStock(StockDTO stockDTO) {
		stockRepo.save(toEntity(stockDTO));
		
	}

	@Override
	public void updateStock(Long stockId, StockUpdateDTO updateDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStock(Long stockId) {
		// TODO Auto-generated method stub
		
	}

	/* MapStruct Mapper Production ↔ ProductionDTO */
	protected StockDTO toDTO(Stock stock) {
		return stockMapper.toDto(stock);
	}
	
	/* MapStruct Mapper ProductionDTO ↔ Production */
	protected Stock toEntity(StockDTO stockDto) {
		return stockMapper.toEntity(stockDto);
	}
	
}
