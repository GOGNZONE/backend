package com.gongzone.production.service;

import java.util.List;

import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.dto.ProductionDtoDetail;

/**
 * 생산 서비스 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
public interface ProductionService {
	
	/**
	 *  전체 생산 목록 조회
	 *  @return List<ProductionDtoDetail>
	 */
	public List<ProductionDtoDetail> findAllProductions();
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 조회
	 * @param { productionId }
	 * @return ProductionDTO
	 * */
	public ProductionDto findByProductionId(Long productionId);
	
	/**
	 * 생산 품목 등록
	 * @param { productionDTO }
	 * @return void
	 * */
	public void insertProduction(ProductionDto productionDTO);
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 수정
	 * @param { productionId, productionDTO }
	 * @return void
	 * */
	public void updateProduction(Long productionId, ProductionDto productionDTO);
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 삭제
	 * @param { productionId }
	 * @return void
	 * */
	public void deleteProduction(Long productionId);
	
}
