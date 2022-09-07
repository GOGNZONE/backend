package com.gongzone.apiController.release;

import java.util.List;
import java.util.Objects;

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
import com.gongzone.service.implement.release.ReleaseServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "RELEASE", description = "출고관리 API")
public class ReleaseRestController {
	
	private final ReleaseServiceImpl releaseServiceImpl;
	
	/**
	 * 전체 출고 목록 조회
	 * @return ResponseEntity<List<ReleaseListDto>>
	 * */
	@Operation(summary = "전체 출고내역 조회", description = "등록된 출고의 출고코드, 출고일자, 출고수량, 출고방식, 출고 대상 회사, 출고 대상 상품에 대한 데이터 제공")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ReleaseListDto.class))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@GetMapping("/list")
	public ResponseEntity<List<ReleaseListDto>> findAllReleases() {
		final List<ReleaseListDto> response = releaseServiceImpl.findAllReleases();
		return ResponseEntity.ok().body(response);
	}
	
	/**
	 * 출고 코드(release_id)로 출고 상세 조회
	 * @param { releaseId }
	 * @return ResponseEntity<ReleaseDto>
	 * */
	@Operation(summary = "상세 출고내역 조회", description = "출고코드, 출고일자, 수량 등 출고에 대한 상세정보와 해당 출고와 관련된 거래처, 상품, 배송에 대한 데이터 제공")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ReleaseDto.class))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@GetMapping("/{releaseId}")
	public ResponseEntity<ReleaseDto> findByReleaseId(@Parameter(description = "출고 코드") @PathVariable final Long releaseId) throws RestApiException {
		return ResponseEntity.ok().body(releaseServiceImpl.findByReleaseId(releaseId));
	}
	
	/**
	 * 출고 등록
	 * @param { productionId, releaseInsertUpdateDto }
	 * @return ResponseEntity<Objects>
	 * */
	@Operation(summary = "출고 등록", description = "출고 대상 생산품목에 대한 출고코드, 출고일자, 출고수량 등 출고에 대한 데이터와 택배사에 대한 데이터 입력")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@PostMapping("/{productionId}")
	public ResponseEntity<Objects> insertRelease(@Parameter(description = "생산 제품 코드") @PathVariable final Long productionId, @RequestBody @Validated final ReleaseInsertUpdateDto releaseInsertUpdateDto) {
		releaseServiceImpl.insertRelease(productionId, releaseInsertUpdateDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.build();
	}
	
	/**
	 * 출고 코드(release_id)로 출고 수정
	 * @param { releaseId, releaseInsertUpdateDto }
	 * @return ResponseEntity<Objects>
	 * */
	@Operation(summary = "출고내역 수정", description = "출고일자, 수량, 공급가액(합계), 비고 등 출고 내역에 대한 데이터 수정 및 택배사 데이터 수정 및 등록")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "NO CONTENT", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@PutMapping("/{releaseId}")
	public ResponseEntity<Objects> updateRelease(@Parameter(description = "출고 코드") @PathVariable final Long releaseId, 
			@RequestBody @Validated final ReleaseInsertUpdateDto releaseInsertUpdateDto) throws RestApiException {
		releaseServiceImpl.updateRelease(releaseId, releaseInsertUpdateDto);
		return ResponseEntity.noContent()
				.build();
	}
	
	/**
	 * 출고 코드(release_id)로 출고 삭제
	 * @param { releaseId }
	 * @return ResponseEntity<Objects>
	 * */
	@Operation(summary = "출고내역 삭제", description = "해당 출고내역 삭제")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "NO CONTENT", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@DeleteMapping("/{releaseId}")
	public ResponseEntity<Objects> deleteRelease(@Parameter(description = "출고 코드") @PathVariable final Long releaseId) throws RestApiException {
		releaseServiceImpl.deleteRelease(releaseId);
		return ResponseEntity.noContent()
				.build();
	}
}
