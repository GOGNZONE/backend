package com.gongzone.production.apiController;

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
import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.dto.ProductionListDto;
import com.gongzone.production.dto.ProductionUpdateDto;
import com.gongzone.production.service.ProductionServiceImpl;

import lombok.RequiredArgsConstructor;

/**
 * 생산 컨트롤러
 * @author Hanju Park
 * @version 1.0
 * */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/production")
public class ProductionRestController {
	
	private final ProductionServiceImpl productionServiceImpl;
	
	/**
	 *  전체 생산 품목 조회
	 *  @return ResponseEntity<List<ProductionListDto>>
	 */
	@GetMapping("/list")
	public ResponseEntity<List<ProductionListDto>> findAllProductions() {
		final List<ProductionListDto> response = productionServiceImpl.findAllProductions();
		return ResponseEntity.ok(response);
	}
	
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 상세 조회
	 * @param { productionId }
	 * @return ResponseEntity<ProductionDto>
	 * */
	@GetMapping("/{productionId}")
	public ResponseEntity<ProductionDto> findByProductionId(@PathVariable final Long productionId) throws RestApiException {
		return ResponseEntity.ok(productionServiceImpl.findByProductionId(productionId));
	}
	
	/**
	 * 생산 품목 등록
	 * @param { ProductionDto }
	 * @return ResponseEntity<Void>
	 * */
	@PostMapping("")
	public ResponseEntity<Void> insertProduction(@RequestBody @Validated final ProductionDto productionDto) {
		productionServiceImpl.insertProduction(productionDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.build();
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 수정
	 * @param { productionId, productionUpdateDto }
	 * @return ResponseEntity<Void>
	 * */
	@PutMapping("/{productionId}")
	public ResponseEntity<Void> updateProduction(@PathVariable final Long productionId, 
			@RequestBody @Validated final ProductionUpdateDto productionUpdateDto) throws RestApiException {
		productionServiceImpl.updateProduction(productionId, productionUpdateDto);
		return ResponseEntity.noContent()
				.build();
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 삭제
	 * @param { productionId }
	 * @return ResponseEntity<Void>
	 * */
	@DeleteMapping("/{productionId}")
	public ResponseEntity<Void> deleteProduction(@PathVariable final Long productionId) throws RestApiException {
		productionServiceImpl.deleteProduction(productionId);
		return ResponseEntity.noContent()
				.build();
	}
	
}
