package com.gongzone.production.apiController;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.dto.ProductionListDto;
import com.gongzone.production.dto.ProductionUpdateDto;
import com.gongzone.production.service.ProductionServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 생산 컨트롤러
 * @author Hanju Park
 * @version 1.0
 * */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/production")
public class ProductionRestController {
	
	private final ProductionServiceImpl productionServiceImpl;
	
	/**
	 *  전체 생산 품목 조회
	 *  @return List<ProductionListDto>
	 */
	@GetMapping("/list")
	public List<ProductionListDto> findAllProductions() {
		return productionServiceImpl.findAllProductions();
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 조회
	 * @param { productionId }
	 * @return ProductionDto
	 * */
	@GetMapping("/{productionId}")
	public ProductionDto findByProductionId(@PathVariable Long productionId) {
		return productionServiceImpl.findByProductionId(productionId);
	}
	
	/**
	 * 생산 품목 등록
	 * @param { ProductionDto }
	 * @return void
	 * */
	@PostMapping("")
	public void insertProduction(@Validated @RequestBody final ProductionDto productionDto) {
		log.info("@param productionDTO : {}", productionDto);
		productionServiceImpl.insertProduction(productionDto);
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 수정
	 * @param { productionId, productionUpdateDto }
	 * @return void
	 * */
	@PutMapping("/{productionId}")
	public void updateProduction(@PathVariable Long productionId, 
			@Validated @RequestBody final ProductionUpdateDto productionUpdateDto) {
		log.info("@param productionId : {}", productionId);
		log.info("@param productionDTO : {}", productionUpdateDto);
		productionServiceImpl.updateProduction(productionId, productionUpdateDto); 
	}
	
	/**
	 * 생산 품목 코드(production_id)로 생산 품목 삭제
	 * @param { productionId }
	 * @return void
	 * */
	@DeleteMapping("/{productionId}")
	public void deleteProduction(@PathVariable Long productionId) {
		productionServiceImpl.deleteProduction(productionId);
	}
	
}
