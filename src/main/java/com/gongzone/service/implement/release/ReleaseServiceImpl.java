package com.gongzone.service.implement.release;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;
import com.gongzone.entity.production.Production;
import com.gongzone.entity.release.Delivery;
import com.gongzone.entity.release.Release;
import com.gongzone.entity.stock.Stock;
import com.gongzone.release.dto.ReleaseDto;
import com.gongzone.release.dto.ReleaseInsertUpdateDto;
import com.gongzone.release.dto.ReleaseListDto;
import com.gongzone.release.mapper.ReleaseMapper;
import com.gongzone.release.mapper.ReleaseInsertUpdateMapper;
import com.gongzone.release.mapper.ReleaseListMapper;
import com.gongzone.repository.production.ProductionRepository;
import com.gongzone.repository.release.DeliveryRepository;
import com.gongzone.repository.release.ReleaseRepository;
import com.gongzone.repository.stock.StockRepository;
import com.gongzone.service.release.ReleaseService;
import com.gongzone.stock.dto.StockUpdateDTO;
import com.gongzone.stock.mapper.StockMapper;
import com.gongzone.stock.mapper.StockUpdateMapper;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

/**
 * 출고 서비스 인터페이스 구현체
 * @author Hanju Park
 * @version 1.0
 * */
@Service
@RequiredArgsConstructor
public class ReleaseServiceImpl implements ReleaseService {
	
	private final ReleaseRepository releaseRepository;
	private final ProductionRepository productionRepository;
	private final DeliveryRepository deliveryRepository;	
	private final StockRepository stockRepository;
	
	private final ReleaseListMapper releaseListMapper = Mappers.getMapper(ReleaseListMapper.class);
	private final ReleaseMapper releaseMapper = Mappers.getMapper(ReleaseMapper.class);
	private final ReleaseInsertUpdateMapper releaseInsertUpdateMapper = Mappers.getMapper(ReleaseInsertUpdateMapper.class);
	
	/**
	 * 전체 출고 목록 조회
	 * @return List<ReleaseListDto>
	 * */
	@Override
	@Transactional(readOnly = true)
	public List<ReleaseListDto> findAllReleases() {
		List<Release> releases = releaseRepository.findAll();
		return releaseListMapper.toDtoList(releases);
	}

	/**
	 * 출고 코드(release_id)로 출고 조회
	 * @param { releaseId }
	 * @return ReleaseDto
	 * */
	@Override
	@Transactional(readOnly = true)
	public ReleaseDto findByReleaseId(final Long releaseId) throws RestApiException {
		Release release = releaseRepository.findByReleaseId(releaseId)
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		return toDto(release); 
	}

	/**
	 * 출고 등록
	 * @param { productionId, releaseInsertUpdateDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertRelease(final Long productionId, final ReleaseInsertUpdateDto releaseInsertUpdateDto) {
		Production production = productionRepository.findById(productionId).orElse(null);
		Stock stock = stockRepository.findById(production.getStock().getStockId()).orElse(null);

		if(releaseInsertUpdateDto.getDelivery().getDeliveryCompanyName() != "" && releaseInsertUpdateDto.getDelivery().getDeliveryTrackingNumber() != "") {
			Delivery delivery = deliveryRepository.save(releaseInsertUpdateDto.getDelivery());
			releaseInsertUpdateDto.setDelivery(delivery);
		} else {
			releaseInsertUpdateDto.setDelivery(null);
		}
		
		Long newStockQuantity = (long) (production.getProductionQuantity() - releaseInsertUpdateDto.getReleaseQuantity());

		stock.updateStock(production.getProductionName(), newStockQuantity, production.getProductionDescription());
		releaseInsertUpdateDto.setProduction(production);
		releaseRepository.saveRelease(toEntity(releaseInsertUpdateDto));
	}
	
	/**
	 * 출고 코드(release_id)로 출고 수정
	 * @param { releaseId, releaseInsertUpdateDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void updateRelease(final Long releaseId, final ReleaseInsertUpdateDto releaseInsertUpdateDto) throws RestApiException {
		Release release = releaseRepository.findByReleaseId(releaseId)
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		Production production = releaseInsertUpdateDto.getProduction();
		Stock stock = stockRepository.findById(release.getProduction().getStock().getStockId()).orElse(null);
		
		if(releaseInsertUpdateDto.getDelivery() != null) {
			Delivery delivery = deliveryRepository.save(releaseInsertUpdateDto.getDelivery());
			releaseInsertUpdateDto.setDelivery(delivery);
		} else {
			releaseInsertUpdateDto.setDelivery(null);
		}
		
		Long newStockQuantity = (long) (production.getProductionQuantity() - releaseInsertUpdateDto.getReleaseQuantity());
		
		stock.updateStock(stock.getStockName(), newStockQuantity, stock.getStockDescription());
		releaseInsertUpdateDto.setProduction(production);
		release.updateRelease(releaseInsertUpdateDto);
	}

	/**
	 * 출고 코드(release_id)로 출고 삭제
	 * @param { releaseId }
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteRelease(final Long releaseId) throws RestApiException {
		Release release = releaseRepository.findByReleaseId(releaseId)
				.orElseThrow(() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		Stock stock = stockRepository.findById(release.getProduction().getStock().getStockId()).orElse(null);
		
		Long newStockQuantity = (long) (release.getProduction().getProductionQuantity());
		
		stock.updateStock(stock.getStockName(), newStockQuantity, stock.getStockDescription());
		releaseRepository.deleteRelease(releaseId);
	}

	
	/* MapStruct Mapper Release → ReleaseDto */
	protected ReleaseDto toDto(Release release) {
		return releaseMapper.toDto(release);
	}
	
	/* MapStruct Mapper ReleaseInsertDto → Release */
	protected Release toEntity(ReleaseInsertUpdateDto releaseInsertUpdateDto) {
		return releaseInsertUpdateMapper.toEntity(releaseInsertUpdateDto);
	}
	
}
