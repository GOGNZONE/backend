package com.gongzone.bom.service;

import java.util.List;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;


/**
 * BOM 서비스 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 */
public interface BOMService {
	/**
	 *  전체 BOM 조회
	 *  @return List<BOM>
	 */
	public List<BOM> findBOM();
	
	/**
	 * BOM코드(bomId)로 조회
	 * @param { bomId }
	 * @return BOMDTO
	 * */
	public BOMDTO findBOMByBomId(Long bomId);
	
	/**
	 * BOM 등록
	 * @param { BOMDTO }
	 * @return void
	 * */
	public void insertBOM(BOMDTO bomDTO);
	
	/**
	 * BOM 코드(bomId)로 수정
	 * @param { BOMDTO }
	 * @return void
	 * */
	public void updateBOM(BOMDTO bomDTO);
	
	/**
	 * BOM 코드(bomId)로 삭제
	 * @param { bomId }
	 * @return void
	 * */
	public void deleteBOM(Long bomId);
}
