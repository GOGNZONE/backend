package com.gongzone.production.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.dto.ProductionDtoDetail;
import com.gongzone.production.entity.Production;
import com.gongzone.production.mapper.ProductionDetailMapper;
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
	private final ProductionDetailMapper productionDetailMapper = Mappers.getMapper(ProductionDetailMapper.class);
	private final ProductionMapper productionMapper = Mappers.getMapper(ProductionMapper.class);
	
	/**
	 *  전체 생산 목록 조회
	 *  @return List<ProductionDtoDetail>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ProductionDtoDetail> findAllProductions() {
		List<Production> productions = productionRepository.findAll();
		return productionDetailMapper.toDtoList(productions);
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 조회
	 * @param { productionId }
	 * @return ProductionDTO
	 * */
	@Override
	@Transactional(readOnly = true)
	public ProductionDto findByProductionId(Long productionId) {
		Production production = productionRepository.findById(productionId).orElse(null);
		return toDTO(production);
	}
	
	/**
	 * 생산 품목 등록
	 * @param { productionDTO }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertProduction(ProductionDto productionDTO) {
		productionRepository.save(toEntity(productionDTO));
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 수정
	 * @param { productionId, productionDTO }
	 * @return ProductionDTO
	 * */
	@Override
	@Transactional
	public void updateProduction(Long productionId, ProductionDto productionDTO) {
		Production production = productionRepository.findById(productionId).orElse(null);
		log.info("production = {}", production);
		/****/
		production.updateProduction(productionDTO.getProductionName(), productionDTO.getProductionBrandName(), productionDTO.getProductionPrice(), 
				productionDTO.getProductionQuantity(), productionDTO.getProductionFile(), productionDTO.getProductionStandard(), 
				productionDTO.getProductionUnit(), productionDTO.getProductionDescription(), productionDTO.getProductionReleasedDate());
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
