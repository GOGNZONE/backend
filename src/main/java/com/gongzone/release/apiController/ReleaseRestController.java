package com.gongzone.release.apiController;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.release.dto.ReleaseDetailsVehicleDto;
import com.gongzone.release.dto.ReleaseListDto;
import com.gongzone.release.service.ReleaseServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 출고 컨트롤러
 * @author Hanju Park
 * @version 1.0
 * */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/release")
public class ReleaseRestController {
	
	private final ReleaseServiceImpl releaseServiceImpl;
	
	/**
	 * 전체 출고 목록 조회
	 * @return List<ReleaseListDto>
	 * */
	@GetMapping("/list")
	public List<ReleaseListDto> findAllReleases() {
		return releaseServiceImpl.findAllReleases();
	}
	
	/**
	 * 출고 코드(release_id)로 출고 상세 조회
	 * @param { releaseId }
	 * @return ReleaseDto
	 * */
//	@GetMapping("/{releaseId}")
//	public ReleaseDetailsDto findByReleaseId(@PathVariable Long releaseId) {
//		return releaseServiceImpl.findByReleaseId(releaseId);
//	}
	
	/**
	 * 출고 등록
	 * */
//	@PostMapping("")
//	public void insertRelease(@Validated @RequestBody final ReleaseDto releaseDto )
	
	/**
	 * 출고 코드(release_id)로 출고 수정
	 * */
	
	/**
	 * 출고 코드(release_id)로 출고 삭제
	 * */
}
