package com.gongzone.release.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.release.dto.ReleaseDetailsDto;
import com.gongzone.release.dto.ReleaseDto;
import com.gongzone.release.entity.Release;
import com.gongzone.release.mapper.ReleaseMapper;
import com.gongzone.release.mapper.ReleaseDetailsMapper;
import com.gongzone.release.repository.ReleaseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 출고 서비스 인터페이스 구현체
 * @author Hanju Park
 * @version 1.0
 * */
@Slf4j
@Service
@RequiredArgsConstructor
public class ReleaseServiceImpl implements ReleaseService {
	
	private final ReleaseRepository releaseRepository;
	private final ReleaseMapper releaseMapper = Mappers.getMapper(ReleaseMapper.class);
	private final ReleaseDetailsMapper releaseDetailsMapper = Mappers.getMapper(ReleaseDetailsMapper.class);
	
	/**
	 * 전체 출고 목록 조회
	 * @return List<ReleaseListDto>
	 * */
	@Override
	@Transactional(readOnly = true)
	public List<ReleaseDto> findAllReleases() {
		List<Release> releases = releaseRepository.findAll();
		return releaseMapper.toDtoList(releases);
	}

	/**
	 * 출고 코드(release_id)로 출고 조회
	 * @param { releaseId }
	 * @return ReleaseDetailsDto
	 * */
	@Override
	@Transactional(readOnly = true)
	public ReleaseDetailsDto findByReleaseId(Long releaseId) {
		Release release = releaseRepository.findById(releaseId).orElse(null);
		return toDto(release); 
	}

	/**
	 * 출고 등록
	 * @param { releaseDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertRelease(ReleaseDto releaseDto) {
		releaseRepository.save(toEntity(releaseDto));
	}
	
	/**
	 * 출고 코드(release_id)로 출고 수정
	 * @param { releaseId, releaseDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void updateRelease(Long releaseId, ReleaseDto releaseDto) {
		Release release = releaseRepository.findById(releaseId).orElse(null);
		log.info("release = {}", release);
		release.updateRelease(releaseDto);
	}

	/**
	 * 출고 코드(release_id)로 출고 삭제
	 * @param { releaseId }
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteRelease(Long releaseId) {
		Release release = releaseRepository.findById(releaseId).orElse(null);
		log.info("release = {}", release);
		releaseRepository.delete(release);
	}

	
	/* MapStruct Mapper Release ↔ ReleaseDto */
	protected ReleaseDetailsDto toDto(Release release) {
		return releaseDetailsMapper.toDto(release);
	}
	
	/* MapStruct Mapper ReleaseDto ↔ Release */
	protected Release toEntity(ReleaseDto releaseDto) {
		return releaseMapper.toEntity(releaseDto);
	}
	
}
