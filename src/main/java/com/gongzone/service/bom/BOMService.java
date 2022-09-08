package com.gongzone.service.bom;

import java.util.List;

import com.gongzone.dto.bom.BOMDTO.BomRequest;
import com.gongzone.dto.bom.BOMDTO.BomResponse;
import com.gongzone.dto.bom.BOMListDTO;
import com.gongzone.dto.bom.BOMUpdateDTO;

/**
 * BOM 서비스 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 */
public interface BOMService {
	/**
	 *  전체 BOM 조회
	 *  @return List<BOMDTO>
	 */
	public List<BOMListDTO> findBOM();
	
	/**
	 * BOM코드(bomId)로 조회
	 * @param { bomId }
	 * @return BOMDTO
	 * */
	public BomResponse findBOMByBomId(Long bomId);
	
	/**
	 * BOM 등록
	 * @param { BOMDTO }
	 * @return void
	 * */
	public void insertBOM(BomRequest bomDTO);
	
	/**
	 * BOM 코드(bomId)로 수정
	 * @param { BOMDTO }
	 * @return void
	 * */
	public void updateBOM(Long bomId, BOMUpdateDTO updateDto);
	
	/**
	 * BOM 코드(bomId)로 삭제
	 * @param { bomId }
	 * @return void
	 * */
	public void deleteBOM(Long bomId);
}
