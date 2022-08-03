package com.gongzone.release.service;

import java.util.List;

import com.gongzone.release.dto.ReleaseDetailsVehicleDto;
import com.gongzone.release.dto.ReleaseListDto;

/**
 * 출고 서비스 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
public interface ReleaseService {
	
	/**
	 * 전체 출고 목록 조회
	 * @return List<ReleaseListDto>
	 * */
	public List<ReleaseListDto> findAllReleases();
	
	/**
	 * 출고 코드(release_id)로 출고 조회
	 * @param { releaseId }
	 * @return ReleaseDto
	 * */
//	public ReleaseDetailsDto findByReleaseId(Long releaseId);
	
	/**
	 * 출고 등록
	 * @return void
	 * */
//	public void insertRelease()
	
}
