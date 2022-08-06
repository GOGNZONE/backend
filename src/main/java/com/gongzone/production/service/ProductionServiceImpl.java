package com.gongzone.production.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.dto.ProductionListDto;
import com.gongzone.production.dto.ProductionUpdateDto;
import com.gongzone.production.entity.Production;
import com.gongzone.production.mapper.ProductionListMapper;
import com.gongzone.production.mapper.ProductionMapper;
import com.gongzone.production.repository.ProductionRepository;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

/**
 * 생산 서비스 인터페이스 구현체
 * @author Hanju Park
 * @version 1.0
 * */
//@Slf4j
@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {
	
	private final ProductionRepository productionRepository;
	private final ProductionListMapper productionListMapper = Mappers.getMapper(ProductionListMapper.class);
	private final ProductionMapper productionMapper = Mappers.getMapper(ProductionMapper.class);
	
	/**
	 *  전체 생산 목록 조회 (ProductionListMapper)
	 *  @return List<ProductionListDto>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ProductionListDto> findAllProductions() {
		List<Production> productions = productionRepository.findAll();
		return productionListMapper.toDtoList(productions);
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 상세 조회 (ProductionMapper)
	 * @param { productionId }
	 * @return ProductionDto
	 * */
	@Override
	@Transactional(readOnly = true)
	public ProductionDto findByProductionId(Long productionId) {
		Production production = productionRepository.findById(productionId).orElse(null);
		return toDTO(production);
	}
	
	/**
	 * 생산 품목 등록 (ProductionMapper)
	 * @param { productionDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertProduction(ProductionDto productionDto) {
		productionRepository.save(toEntity(productionDto));
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 수정 (ProductionUpdateMapper)
	 * @param { productionId, productionUpdateDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void updateProduction(Long productionId, ProductionUpdateDto productionUpdateDto) {
		Production production = productionRepository.findById(productionId).orElse(null);
//		log.info("production = {}", production);
		production.updateProduction(productionUpdateDto);
	}

	/**
	 * 생산 품목 코드(production_id)로 생산 품목 삭제
	 * @param { productionId }
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteProduction(Long productionId) {
		Production production = productionRepository.findById(productionId).orElse(null);
//		log.info("production = {}", production);
		productionRepository.delete(production);
	}
	
	
	/* MapStruct Mapper Production → ProductionDTO */
	protected ProductionDto toDTO(Production production) {
		return productionMapper.toDto(production);
	}
	
	/* MapStruct Mapper ProductionDTO → Production */
	protected Production toEntity(ProductionDto productionDto) {
		return productionMapper.toEntity(productionDto);
	}

}
