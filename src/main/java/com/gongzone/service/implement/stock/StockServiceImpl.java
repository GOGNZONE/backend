package com.gongzone.service.implement.stock;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;
import com.gongzone.dto.stock.StockDTO;
import com.gongzone.dto.stock.StockDTO.StockRequest;
import com.gongzone.dto.stock.StockListDTO;
import com.gongzone.dto.stock.StockUpdateDTO;
import com.gongzone.entity.stock.Stock;
import com.gongzone.repository.stock.StockRepository;
import com.gongzone.service.stock.StockService;

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
	
	/**
	 *  전체 재고 조회
	 *  @return List<StockListDTO>
	 */
	@Override
	public List<StockListDTO> findStock() {
		List<StockListDTO> list = stockRepo.findAll()
				.stream()
				.map(StockListDTO::new)
				.collect(Collectors.toList());
		return list;
	}

	/**
	 * 재고코드(stockId)로 조회
	 * @param { stockId }
	 * @return StockDTO
	 * */
	@Override
	public StockDTO findStockByStockId(Long stockId) {
		Stock stock = stockRepo.findStockByStockId(stockId)
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		return new StockDTO(stock);
	}

	/**
	 * 재고 등록
	 * @param { StockRequest }
	 * @return void
	 * */
	@Override
	public void insertStock(StockRequest stockRequest) {
		stockRepo.save(stockRequest.toEntity());
	}

	/**
	 * 재고 코드(stockId)로 수정
	 * @param { stockId, StockUpdateDTO }
	 * @return void
	 * */
	@Override
	public void updateStock(Long stockId, StockUpdateDTO updateDTO) {
		Stock stock = stockRepo.findById(stockId).orElseThrow(
				() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
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
		stockRepo.deleteByStockId(stockId).orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
	}
	
}
