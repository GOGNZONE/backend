package com.gongzone.production.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.client.entity.Client;
import com.gongzone.client.repository.ClientRepository;
import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;
import com.gongzone.production.dto.ProductionDetailsDto;
import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.dto.ProductionListDto;
import com.gongzone.production.dto.ProductionUpdateDto;
import com.gongzone.production.entity.Production;
import com.gongzone.production.mapper.ProductionDetailsMapper;
import com.gongzone.production.mapper.ProductionListMapper;
import com.gongzone.production.mapper.ProductionMapper;
import com.gongzone.production.repository.ProductionRepository;

import lombok.RequiredArgsConstructor;

/**
 * 생산 서비스 인터페이스 구현체
 * @author Hanju Park
 * @version 1.0
 * */
@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements ProductionService {
	
	private final ProductionRepository productionRepository;
	private final ClientRepository clientRepository;
	
	private final ProductionListMapper productionListMapper = Mappers.getMapper(ProductionListMapper.class);
	private final ProductionMapper productionMapper = Mappers.getMapper(ProductionMapper.class);
	private final ProductionDetailsMapper productionDetailsMapper = Mappers.getMapper(ProductionDetailsMapper.class);
	
	/**
	 *  전체 생산 목록 조회
	 *  @return List<ProductionListDto>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ProductionListDto> findAllProductions() {
		List<Production> productions = productionRepository.findAll();
		return productionListMapper.toDtoList(productions);
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 상세 조회
	 * @param { productionId }
	 * @return ProductionDetailsDto
	 * */
	@Override
	@Transactional(readOnly = true)
	public ProductionDetailsDto findByProductionId(final Long productionId) throws RestApiException {
		Production production = productionRepository.findById(productionId)
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		return productionDetailsMapper.toDto(production);
	}
	
	/**
	 * 생산 품목 등록
	 * @param { productionDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertProduction(final ProductionDto productionDto) {
		Client client = clientRepository.findById(productionDto.getClient().getClientId()).orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		productionDto.setClient(client);
		productionRepository.save(toEntity(productionDto));
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 수정
	 * @param { productionId, productionUpdateDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void updateProduction(final Long productionId, final ProductionUpdateDto productionUpdateDto) throws RestApiException {
		Production production = productionRepository.findById(productionId)
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		production.updateProduction(productionUpdateDto);
	}

	/**
	 * 생산 품목 코드(production_id)로 생산 품목 삭제
	 * @param { productionId }
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteProduction(final Long productionId) throws RestApiException {
		Production production = productionRepository.findById(productionId)
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		productionRepository.delete(production);
	}
	
	
	/* MapStruct Mapper ProductionDTO → Production */
	protected Production toEntity(ProductionDto productionDto) {
		return productionMapper.toEntity(productionDto);
	}

}
