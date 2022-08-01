package com.gongzone.production.service;

import java.util.List;

import com.gongzone.production.dto.ProductionDTO;
import com.gongzone.production.dto.ProductionFindAllDTO;

/**
 * 생산 서비스 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
public interface ProductionService {
	
	/**
	 *  전체 생산 목록 조회
	 *  @return List<ProductionDTO>
	 */
	public List<ProductionFindAllDTO> findAllProductions();
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 조회
	 * @param { productionId }
	 * @return ProductionDTO
	 * */
	public ProductionDTO findByProductionId(Long productionId);
	
	/**
	 * 생산 품목 등록
	 * @param { productionDTO }
	 * @return void
	 * */
	public void createProduction(ProductionDTO productionDTO);

}
