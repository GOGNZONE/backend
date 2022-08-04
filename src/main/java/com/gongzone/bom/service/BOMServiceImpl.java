package com.gongzone.bom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.bom.repository.BOMRepository;

/**
 * BOM 서비스 인터페이스 구현체
 * @author kangdonghyeon
 * @version 1.0
 */
@Service
public class BOMServiceImpl implements BOMService{
	@Autowired
	public BOMRepository bomRepo;
	
	/**
	 *  전체 BOM 조회
	 *  @return List<BOM>
	 */
	@Override
	public List<BOM> findBOM() {
		return bomRepo.findAll();
	}

	/**
	 * BOM코드(bomId)로 조회
	 * @param { bomId }
	 * @return BOMDTO
	 * */
	@Override
	public BOMDTO findBOMByBomId(Long bomId) {
		return bomRepo.findBOMByBomId(bomId).toDTO(bomRepo.findBOMByBomId(bomId));
	}

	/**
	 * BOM 등록
	 * @param { BOMDTO }
	 * @return void
	 * */
	@Override
	public void insertBOM(BOMDTO bomDTO) {
		BOM bomEntity = bomDTO.toEntity(bomDTO);
		bomRepo.save(bomEntity);
	}

	/**
	 * BOM 코드(bomId)로 수정
	 * @param { BOMDTO }
	 * @return void
	 * */
	@Override
	public void updateBOM(BOMDTO bomDTO) {
		BOM bom = findBOMByBomId(bomDTO.getBomId()).toEntity(findBOMByBomId(bomDTO.getBomId()));
		bom.updateBOM(bomDTO);
		bomRepo.save(bom);
	}

	
	/**
	 * BOM 코드(bomId)로 삭제
	 * @param { bomId }
	 * @return void
	 * */
	@Override
	public void deleteBOM(Long bomId) {
		bomRepo.deleteBOMByBomId(bomId);
	}

	
	
}
