package com.gongzone.service.implement.bom;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.dto.bom.BOMDTO.BomRequest;
import com.gongzone.dto.bom.BOMDTO.BomResponse;
import com.gongzone.dto.bom.BOMListDTO;
import com.gongzone.dto.bom.BOMUpdateDTO;
import com.gongzone.entity.bom.BOM;
import com.gongzone.repository.bom.BOMRepository;
import com.gongzone.service.bom.BOMService;

import lombok.RequiredArgsConstructor;

/**
 * BOM 서비스 인터페이스 구현체
 * @author kangdonghyeon
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class BOMServiceImpl implements BOMService{
	private final BOMRepository bomRepo;
	
	/**
	 *  전체 BOM 조회
	 *  @return List<BOMListDTO>
	 */
	@Override
	public List<BOMListDTO> findBOM() {
		List<BOMListDTO> list = bomRepo.findAll()
				.stream()
				.map(BOMListDTO::new)
				.collect(Collectors.toList());
		
		return list;
	}

	/**
	 * BOM코드(bomId)로 조회
	 * @param { bomId }
	 * @return BOMDTO
	 * */
	@Override
	public BomResponse findBOMByBomId(Long bomId) {
		BOM bom = bomRepo.findBOMByBomId(bomId);
		return new BomResponse(bom);
	
	}

	/**
	 * BOM 등록
	 * @param { BOMDTO }
	 * @return void
	 * */
	@Override
	public void insertBOM(BomRequest bomDTO) {
		bomRepo.save(bomDTO.toEntity());
	}

	/**
	 * BOM 코드(bomId)로 수정
	 * @param { BOMDTO }
	 * @return void
	 * */
	@Override
	public void updateBOM(Long bomId, BOMUpdateDTO updateDto) {
		BOM bom = bomRepo.findBOMByBomId(bomId);
		bom.updateBOM(updateDto);
		bomRepo.save(bom);
	}

	
	/**
	 * BOM 코드(bomId)로 삭제
	 * @param { bomId }
	 * @return void
	 * */
	@Override
	@Transactional
	public void deleteBOM(Long bomId) {
		bomRepo.deleteBOMByBomId(bomId);
	}

}
