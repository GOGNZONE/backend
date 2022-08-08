package com.gongzone.release.apiController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.common.errors.exception.RestApiException;
import com.gongzone.release.dto.ReleaseDto;
import com.gongzone.release.dto.ReleaseInsertUpdateDto;
import com.gongzone.release.dto.ReleaseListDto;
import com.gongzone.release.service.ReleaseServiceImpl;

import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;

/**
 * 출고 컨트롤러
 * @author Hanju Park
 * @version 1.0
 * */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/release")
public class ReleaseRestController {
	
	private final ReleaseServiceImpl releaseServiceImpl;
	
	/**
	 * 전체 출고 목록 조회
	 * @return ResponseEntity<List<ReleaseListDto>>
	 * */
	@GetMapping("/list")
	public ResponseEntity<List<ReleaseListDto>> findAllReleases() {
		final List<ReleaseListDto> response = releaseServiceImpl.findAllReleases();
		return ResponseEntity.ok(response);
	}
	
	/**
	 * 출고 코드(release_id)로 출고 상세 조회
	 * @param { releaseId }
	 * @return ResponseEntity<ReleaseDto>
	 * */
	@GetMapping("/{releaseId}")
	public ResponseEntity<ReleaseDto> findByReleaseId(@PathVariable final Long releaseId) throws RestApiException {
		return ResponseEntity.ok(releaseServiceImpl.findByReleaseId(releaseId));
	}
	
	/**
	 * 출고 등록
	 * @param { productionId, releaseInsertUpdateDto }
	 * @return ResponseEntity<Void>
	 * */
	@PostMapping("/{productionId}")
	public ResponseEntity<Void> insertRelease(@PathVariable final Long productionId, 
			@RequestBody @Validated final ReleaseInsertUpdateDto releaseInsertUpdateDto) {
		releaseServiceImpl.insertRelease(productionId, releaseInsertUpdateDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.build();
	}
	
	/**
	 * 출고 코드(release_id)로 출고 수정
	 * @param { releaseId, releaseInsertUpdateDto }
	 * @return ResponseEntity<Void>
	 * */
	@PutMapping("/{releaseId}")
	public ResponseEntity<Void> updateRelease(@PathVariable final Long releaseId, 
			@RequestBody @Validated final ReleaseInsertUpdateDto releaseInsertUpdateDto) throws RestApiException {
		releaseServiceImpl.updateRelease(releaseId, releaseInsertUpdateDto);
		return ResponseEntity.noContent()
				.build();
	}
	
	/**
	 * 출고 코드(release_id)로 출고 삭제
	 * @param { releaseId }
	 * @return ResponseEntity<Void>
	 * */
	@DeleteMapping("/{releaseId}")
	public ResponseEntity<Void> deleteRelease(@PathVariable final Long releaseId) throws RestApiException {
		releaseServiceImpl.deleteRelease(releaseId);
		return ResponseEntity.noContent()
				.build();
	}
}
