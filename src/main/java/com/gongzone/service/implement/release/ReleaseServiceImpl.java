package com.gongzone.service.implement.release;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;
import com.gongzone.dto.release.ReleaseDto;
import com.gongzone.dto.release.ReleaseInsertUpdateDto;
import com.gongzone.dto.release.ReleaseListDto;
import com.gongzone.entity.production.Production;
import com.gongzone.entity.release.Delivery;
import com.gongzone.entity.release.Release;
import com.gongzone.entity.stock.Stock;
import com.gongzone.repository.production.ProductionRepository;
import com.gongzone.repository.release.DeliveryRepository;
import com.gongzone.repository.release.ReleaseRepository;
import com.gongzone.repository.stock.StockRepository;
import com.gongzone.service.release.ReleaseService;

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
	
	/**
	 * 전체 출고 목록 조회
	 * @return List<ReleaseListDto>
	 * */
	@Override
	@Transactional(readOnly = true)
	public List<ReleaseListDto> findAllReleases() {
		List<ReleaseListDto> releases = releaseRepository.findAll()
				.stream()
				.map(ReleaseListDto::new)
				.collect(Collectors.toList());
		
		return releases;
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
		return new ReleaseDto(release);
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
		releaseRepository.saveRelease(releaseInsertUpdateDto.toEntity());
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
}
