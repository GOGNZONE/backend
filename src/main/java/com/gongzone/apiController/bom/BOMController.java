package com.gongzone.apiController.bom;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.dto.bom.BOMDTO.BomRequest;
import com.gongzone.dto.bom.BOMDTO.BomResponse;
import com.gongzone.dto.bom.BOMListDTO;
import com.gongzone.dto.bom.BOMUpdateDTO;
import com.gongzone.service.implement.bom.BOMServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


/**
 * BOM 컨트롤러
 * @author kangdonghyeon
 * @version 1.0
 */
@RestController
@RequestMapping("/api/BOM")
@RequiredArgsConstructor
@Tag(name = "BOM", description = "BOM 관리 API")
public class BOMController {
	private final BOMServiceImpl bomService;
	
	
	/**
	 *  전체 BOM 조회
	 *  @return List<BOMDTO>
	 */
	@GetMapping("/list")
	public List<BOMListDTO> findBOM(){
		return bomService.findBOM();
	}
	
	/**
	 * BOM코드(bomId)로 조회
	 * @param { bomId }
	 * @return BOMDTO
	 * */
	@GetMapping("/{bomId}")
	public BomResponse findBOMByBomId(@PathVariable Long bomId) {
		return bomService.findBOMByBomId(bomId);
	}
	
//	@GetMapping("/{bomId}")
//	public  ResponseEntity<BOMDTO> findBOMByBomId(@PathVariable Long bomId) {
//		return 	ResponseEntity.ok(bomService.findBOMByBomId(bomId));
//	}
//	
	
	/**
	 * BOM 등록
	 * @param { BOMDTO }
	 * @return void
	 * */
	@PostMapping("")
	public void insertBOM(@RequestBody BomRequest bomDTO) {
		System.out.println(bomDTO);
		bomService.insertBOM(bomDTO);
	}
	
	/**
	 * BOM 코드(bomId)로 수정
	 * @param { bomId, BOMDTO }
	 * @return void
	 * */
	@PutMapping("/{bomId}")
	public void updateBOM(@PathVariable Long bomId, @RequestBody BOMUpdateDTO updateDTO) {
//		System.out.println(updateDTO);
		bomService.updateBOM(bomId, updateDTO);
	}
	
	
	/**
	 * BOM 코드(bomId)로 삭제
	 * @param { bomId }
	 * @return void
	 * */
	@DeleteMapping("/{bomId}")
	public void deleteBOM(@PathVariable Long bomId) {
		bomService.deleteBOM(bomId);
	}
	
	
	
}
