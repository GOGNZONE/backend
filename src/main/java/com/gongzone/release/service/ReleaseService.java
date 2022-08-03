package com.gongzone.release.service;

import java.util.List;

import com.gongzone.release.dto.ReleaseDetailsDto;
import com.gongzone.release.dto.ReleaseDto;

/**
 * 출고 서비스 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
public interface ReleaseService {
	
	/**
	 * 전체 출고 목록 조회
	 * @return List<ReleaseDto>
	 * */
	public List<ReleaseDto> findAllReleases();
	
	/**
	 * 출고 코드(release_id)로 출고 조회
	 * @param { releaseId }
	 * @return ReleaseDetailsDto
	 * */
	public ReleaseDetailsDto findByReleaseId(Long releaseId);
	
	/**
	 * 출고 등록
	 * @param { releaseDto }
	 * @return void
	 * */
	public void insertRelease(ReleaseDto releaseDto);
	
	/**
	 * 출고 코드(release_id)로 출고 수정
	 * @param { releaseId, releaseDto }
	 * @return void
	 * */
	public void updateRelease(Long releaseId, ReleaseDto releaseDto);
	
	/**
	 * 출고 코드(release_id)로 출고 삭제
	 * @param { releaseId }
	 * @return void
	 * */
	public void deleteRelease(Long releaseId);
	
}
