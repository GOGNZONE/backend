package com.gongzone.apiController.production;

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

import com.gongzone.dto.production.ProductionDetailsDto;
import com.gongzone.dto.production.ProductionInsertUpdateDto;
import com.gongzone.dto.production.ProductionListDto;
import com.gongzone.service.implement.production.ProductionServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * 생산 컨트롤러
 * @author Hanju Park
 * @version 1.0
 * */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/production")
@Tag(name = "PRODUCTION", description = "생산관리 API")
public class ProductionRestController {
	
	private final ProductionServiceImpl productionServiceImpl;
	
	/**
	 *  전체 생산 품목 조회
	 *  @return ResponseEntity<List<ProductionListDto>>
	 */
	@Operation(summary = "전체 생산품목 조회", description = "생산코드, 생산품목, 브랜드, 제품수량, 단가, 출고일자, 진행상황, 비고 등 등록된 생산 품목에 대한 데이터 제공")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ProductionListDto.class))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@GetMapping("/list")
	public ResponseEntity<List<ProductionListDto>> findAllProductions() {
		final List<ProductionListDto> response = productionServiceImpl.findAllProductions();
		return ResponseEntity.ok().body(response);
	}
	
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 상세 조회
	 * @param { productionId }
	 * @return ResponseEntity<ProductionDetailsDto>
	 * */
	@Operation(summary = "생산품목 상세 조회", description = "생산코드, 생산품목, 브랜드, 제품수량/단위, 단가 등 생산 품목에 대한 상세 데이터 제공")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ProductionDetailsDto.class))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@GetMapping("/{productionId}")
	public ResponseEntity<ProductionDetailsDto> findByProductionId(@Parameter(description = "생산 제품 코드") @PathVariable final Long productionId) {
		return ResponseEntity.ok().body(productionServiceImpl.findByProductionId(productionId));
	}
	
	/**
	 * 생산 품목 등록
	 * @param { productionInsertUpdateDto }
	 * @return ResponseEntity<Objects>
	 * */
	@Operation(summary = "생산품목 등록", description = "생산품목, 브랜드, 단가, 제품수량/단위, 규격 등 생산 품목에 대한 데이터 입력")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "CREATED", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@PostMapping("")
	public ResponseEntity<Objects> insertProduction(@RequestBody @Validated final ProductionInsertUpdateDto productionInsertUpdateDto) {
		productionServiceImpl.insertProduction(productionInsertUpdateDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.build();
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 수정
	 * @param { productionId, productionInsertUpdateDto }
	 * @return ResponseEntity<Objects>
	 * */
	@Operation(summary = "생산품목 수정", description = "생산품목, 브랜드, 단가, 제품수량/단위, 규격 등 생산 품목에 대한 데이터 수정")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "NO CONTENT", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@PutMapping("/{productionId}")
	public ResponseEntity<Objects> updateProduction(@Parameter(description = "생산 제품 코드") @PathVariable final Long productionId, 
			@RequestBody @Validated final ProductionInsertUpdateDto productionInsertUpdateDto) {
		productionServiceImpl.updateProduction(productionId, productionInsertUpdateDto);
		return ResponseEntity.noContent()
				.build();
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 삭제
	 * @param { productionId }
	 * @return ResponseEntity<Objects>
	 * */
	@Operation(summary = "생산품목 삭제", description = "해당 생산품목 삭제")
	@ApiResponses({
		@ApiResponse(responseCode = "204", description = "NO CONTENT", content = @Content(schema = @Schema(hidden = true))),
		@ApiResponse(responseCode = "400", description = "BAD REQUEST", content = @Content(schema = @Schema(example = "잘못된 문법 등으로 인해 클라이언트가 올바르지 못한 요청을 보내 서버가 요청을 이해할 수 없음을 의미합니다."))),
		@ApiResponse(responseCode = "401", description = "UNAUTHORIZED", content = @Content(schema = @Schema(example = "인증되지 않은 사용자가 인증이 필요한 리소스를 요청하는 경우의 응답 입니다."))),
		@ApiResponse(responseCode = "404", description = "NOT FOUND", content = @Content(schema = @Schema(example = "요청한 리소스가 존재하지 않음을 의미합니다."))),
		@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR", content = @Content(schema = @Schema(example = "서버에 오류가 발생하여 응답할 수 없음을 의미합니다. 서버에 오류가 발생했으나 처리 방법을 알 수 없을 경우의 응답입니다.")))
	})
	@DeleteMapping("/{productionId}")
	public ResponseEntity<Objects> deleteProduction(@Parameter(description = "생산 제품 코드") @PathVariable final Long productionId) {
		productionServiceImpl.deleteProduction(productionId);
		return ResponseEntity.noContent()
				.build();
	}
	
}
