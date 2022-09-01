package com.gongzone.release.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;
//import com.gongzone.delivery.entity.Delivery;
//import com.gongzone.delivery.repository.DeliveryRepository;
import com.gongzone.production.entity.Production;
import com.gongzone.production.repository.ProductionRepository;
import com.gongzone.release.dto.ReleaseDto;
import com.gongzone.release.dto.ReleaseInsertUpdateDto;
import com.gongzone.release.dto.ReleaseListDto;
import com.gongzone.release.entity.Delivery;
import com.gongzone.release.entity.Release;
import com.gongzone.release.mapper.ReleaseMapper;
import com.gongzone.release.mapper.DeliveryMapper;
import com.gongzone.release.mapper.ReleaseInsertUpdateMapper;
import com.gongzone.release.mapper.ReleaseListMapper;
import com.gongzone.release.repository.DeliveryRepository;
import com.gongzone.release.repository.ReleaseRepository;

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
	
	private final ReleaseListMapper releaseListMapper = Mappers.getMapper(ReleaseListMapper.class);
	private final ReleaseMapper releaseMapper = Mappers.getMapper(ReleaseMapper.class);
	private final ReleaseInsertUpdateMapper releaseInsertUpdateMapper = Mappers.getMapper(ReleaseInsertUpdateMapper.class);
	private final DeliveryMapper deliveryMapper = Mappers.getMapper(DeliveryMapper.class);
	
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
	 * @param { productionId, releaseInsertUpdateDto, deliveryDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertRelease(final Long productionId, final ReleaseInsertUpdateDto releaseInsertUpdateDto) {
		Production production = productionRepository.findById(productionId).orElse(null);
		Delivery delivery = deliveryRepository.save(deliveryMapper.toEntity(releaseInsertUpdateDto.getDeliveryDto()));

		releaseInsertUpdateDto.setProduction(production);
		releaseInsertUpdateDto.setDeliveryDto(deliveryMapper.toDto(delivery));
		
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
		Delivery delivery = deliveryRepository.save(deliveryMapper.toEntity(releaseInsertUpdateDto.getDeliveryDto()));
		
		releaseInsertUpdateDto.setDeliveryDto(deliveryMapper.toDto(delivery));
		
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
		releaseRepository.deleteRelease(releaseId);
//		releaseRepository.delete(release);
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
