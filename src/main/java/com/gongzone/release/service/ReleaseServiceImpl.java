package com.gongzone.release.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.gongzone.release.dto.ReleaseDetailsVehicleDto;
import com.gongzone.release.dto.ReleaseListDto;
import com.gongzone.release.entity.Release;
import com.gongzone.release.mapper.ReleaseListMapper;
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
	private final ReleaseListMapper releaseListMapper = Mappers.getMapper(ReleaseListMapper.class);
	
	/**
	 * 전체 출고 목록 조회
	 * @return List<ReleaseListDto>
	 * */
	public List<ReleaseListDto> findAllReleases() {
		List<Release> releases = releaseRepository.findAll();
		return releaseListMapper.toDtoList(releases);
	}

//	@Override
//	public ReleaseDto findByReleaseId(Long releaseId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
