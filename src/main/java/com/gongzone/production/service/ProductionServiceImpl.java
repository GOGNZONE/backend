package com.gongzone.production.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.dto.ProductionFindAllDto;
import com.gongzone.production.entity.Production;
import com.gongzone.production.mapper.ProductionFindAllMapper;
import com.gongzone.production.mapper.ProductionMapper;
import com.gongzone.production.repository.ProductionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 생산 서비스 인터페이스 구현체
 * @author Hanju Park
 * @version 1.0
 * */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {
	
	private final ProductionRepository productionRepository;
	private final ProductionFindAllMapper productionFindAllMapper = Mappers.getMapper(ProductionFindAllMapper.class);
	private final ProductionMapper productionMapper = Mappers.getMapper(ProductionMapper.class);
	
	/**
	 *  전체 생산 목록 조회
	 *  @return List<ProductionFindAllDto>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ProductionFindAllDto> findAllProductions() {
		List<Production> productions = productionRepository.findAll();
		return productionFindAllMapper.toDtoList(productions);
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 조회
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
	 * 생산 품목 등록
	 * @param { productionDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertProduction(ProductionDto productionDto) {
		productionRepository.save(toEntity(productionDto));
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 수정
	 * @param { productionId, productionDto }
	 * @return productionDto
	 * */
	@Override
	@Transactional
	public void updateProduction(Long productionId, ProductionDto productionDto) {
		Production production = productionRepository.findById(productionId).orElse(null);
		log.info("production = {}", production);
		production.updateProduction(productionDto.getProductionName(), productionDto.getProductionBrandName(), productionDto.getProductionPrice(), 
				productionDto.getProductionQuantity(), productionDto.getProductionFile(), productionDto.getProductionStandard(), 
				productionDto.getProductionUnit(), productionDto.getProductionDescription(), productionDto.getProductionReleasedDate());
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
		log.info("production = {}", production);
		productionRepository.delete(production);
	}
	
	
	/* MapStruct Mapper Production ↔ ProductionDTO */
	protected ProductionDto toDTO(Production production) {
		return productionMapper.toDto(production);
	}
	
	/* MapStruct Mapper ProductionDTO ↔ Production */
	protected Production toEntity(ProductionDto productionDTO) {
		return productionMapper.toEntity(productionDTO);
	}

}
