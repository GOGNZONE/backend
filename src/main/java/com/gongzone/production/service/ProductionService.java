package com.gongzone.production.service;

import java.util.List;

import com.gongzone.production.dto.ProductionDetailsDto;
import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.dto.ProductionListDto;
import com.gongzone.production.dto.ProductionUpdateDto;

/**
 * 생산 서비스 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
public interface ProductionService {
	
	/**
	 *  전체 생산 목록 조회
	 *  @return List<ProductionListDto>
	 */
	public List<ProductionListDto> findAllProductions();
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 조회
	 * @param { productionId }
	 * @return ProductionDetailsDto
	 * */
	public ProductionDetailsDto findByProductionId(Long productionId);
	
	/**
	 * 생산 품목 등록
	 * @param { productionDto }
	 * @return void
	 * */
	public void insertProduction(ProductionDto productionDto);
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 수정
	 * @param { productionId, productionDto }
	 * @return void
	 * */
	public void updateProduction(Long productionId, ProductionUpdateDto productionUpdateDto);
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 삭제
	 * @param { productionId }
	 * @return void
	 * */
	public void deleteProduction(Long productionId);
	
}
