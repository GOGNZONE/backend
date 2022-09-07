package com.gongzone.service.implement.stock;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.entity.stock.Stock;
import com.gongzone.repository.stock.StockRepository;
import com.gongzone.service.stock.StockService;
import com.gongzone.stock.dto.StockDTO;
import com.gongzone.stock.dto.StockListDTO;
import com.gongzone.stock.dto.StockUpdateDTO;
import com.gongzone.stock.mapper.StockListMapper;
import com.gongzone.stock.mapper.StockMapper;

import lombok.RequiredArgsConstructor;



/**
 * 재고 서비스 인터페이스 구현체
 * @author kangdonghyeon
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService{
	private final StockRepository stockRepo;
	private final StockMapper stockMapper = Mappers.getMapper(StockMapper.class);
	private final StockListMapper stockListMapper = Mappers.getMapper(StockListMapper.class);
	
	/**
	 *  전체 재고 조회
	 *  @return List<StockDTO>
	 */
	@Override
	public List<StockListDTO> findStock() {
		List<Stock> list = stockRepo.findAll();
		return stockListMapper.toDtoList(list);
	}

	/**
	 * 재고코드(stockId)로 조회
	 * @param { stockId }
	 * @return StockDTO
	 * */
	@Override
	public StockDTO findStockByStockId(Long stockId) {
		return toDTO(stockRepo.findStockByStockId(stockId));
	}

	/**
	 * 재고 등록
	 * @param { stockDTO }
	 * @return void
	 * */
	@Override
	public void insertStock(StockDTO stockDTO) {
		stockRepo.save(toEntity(stockDTO));
		
	}

	/**
	 * 재고 코드(stockId)로 수정
	 * @param { stockId, stockDTO }
	 * @return void
	 * */
	@Override
	public void updateStock(Long stockId, StockUpdateDTO updateDTO) {
		Stock stock = toEntity(findStockByStockId(stockId));
		stock.updateStock(updateDTO.getStockName(), updateDTO.getStockQuantity(), updateDTO.getStockDescription());
		stockRepo.save(stock);
		
	}

	/**
	 * 재고 코드(stockId)로 삭제
	 * @param { stockId }
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteStock(Long stockId) {
		stockRepo.deleteByStockId(stockId);
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
