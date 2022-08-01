package com.gongzone.production.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.production.dto.ProductionDTO;
import com.gongzone.production.dto.ProductionFindAllDTO;
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
	 *  @return List<ProductionDTO>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ProductionFindAllDTO> findAllProductions() {
		List<Production> productions = productionRepository.findAll();
		System.out.println(productionMapper.toDTOList(productions));
		return productionFindAllMapper.toDTOList(productions);
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 조회
	 * @param { productionId }
	 * @return ProductionDTO
	 * */
	@Override
	@Transactional(readOnly = true)
	public ProductionDTO findByProductionId(Long productionId) {
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
	public void createProduction(ProductionDTO productionDTO) {
		productionRepository.save(toEntity(productionDTO));
	}
	
	
	/* MapStruct Mapper Production ↔ ProductionDTO */
	protected ProductionDTO toDTO(Production production) {
		return productionMapper.toDTO(production);
	}
	
	/* MapStruct Mapper ProductionDTO ↔ Production */
	protected Production toEntity(ProductionDTO productionDTO) {
		return productionMapper.toEntity(productionDTO);
	}


}
