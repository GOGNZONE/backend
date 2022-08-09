package com.gongzone.bom.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.dto.BOMListDTO;
import com.gongzone.bom.dto.BOMUpdateDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.bom.mapper.BomListMapper;
import com.gongzone.bom.mapper.BomMapper;
import com.gongzone.bom.repository.BOMRepository;


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
	private final BomMapper bomMapper = Mappers.getMapper(BomMapper.class);
	private final BomListMapper bomListMapper = Mappers.getMapper(BomListMapper.class);
	
	/**
	 *  전체 BOM 조회
	 *  @return List<BOMDTO>
	 */
	@Override
	public List<BOMListDTO> findBOM() {
		List<BOM> list = bomRepo.findAll();
		return bomListMapper.toDtoList(list);
	}

	/**
	 * BOM코드(bomId)로 조회
	 * @param { bomId }
	 * @return BOMDTO
	 * */
	@Override
	public BOMDTO findBOMByBomId(Long bomId) {
		return toDTO(bomRepo.findBOMByBomId(bomId));
	
	}

	/**
	 * BOM 등록
	 * @param { BOMDTO }
	 * @return void
	 * */
	@Override
	public void insertBOM(BOMDTO bomDTO) {
		bomRepo.save(toEntity(bomDTO));
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

	/* MapStruct Mapper Production ↔ ProductionDTO */
	protected BOMDTO toDTO(BOM bom) {
		return bomMapper.toDto(bom);
	}
	
	/* MapStruct Mapper ProductionDTO ↔ Production */
	protected BOM toEntity(BOMDTO bomDto) {
		return bomMapper.toEntity(bomDto);
	}
	
}
