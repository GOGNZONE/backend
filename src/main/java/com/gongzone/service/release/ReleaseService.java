package com.gongzone.service.release;

import java.util.List;

import com.gongzone.release.dto.ReleaseDto;
import com.gongzone.release.dto.ReleaseInsertUpdateDto;
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
	 * @return ReleaseDetailsDto
	 * */
	public ReleaseDto findByReleaseId(Long releaseId);
	
	/**
	 * 출고 등록
	 * @param { productionId, releaseInsertUpdateDto}
	 * @return void
	 * */
	public void insertRelease(Long productionId, ReleaseInsertUpdateDto releaseInsertDto);
	
	/**
	 * 출고 코드(release_id)로 출고 수정
	 * @param { releaseId, releaseInsertUpdateDto }
	 * @return void
	 * */
	public void updateRelease(Long releaseId, ReleaseInsertUpdateDto releaseInsertUpdateDto);
	
	/**
	 * 출고 코드(release_id)로 출고 삭제
	 * @param { releaseId }
	 * @return void
	 * */
	public void deleteRelease(Long releaseId);
	
}
