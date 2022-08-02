package com.gongzone.bom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.bom.repository.BOMRepository;


@Service
public class BOMServiceImpl implements BOMService{
	@Autowired
	public BOMRepository bomRepo;
	
	@Override
	public List<BOM> findBOM() {
		return bomRepo.findAll();
	}

	@Override
	public BOMDTO findBOMByBomId(Long bomId) {
		return bomRepo.findBOMByBomId(bomId).toDTO(bomRepo.findBOMByBomId(bomId));
	}

	@Override
	public void insertBOM(BOMDTO bomDTO) {
		BOM bomEntity = bomDTO.toEntity(bomDTO);
		bomRepo.save(bomEntity);
	}

	@Override
	public void updateBOM(BOMDTO bomDTO) {
		BOM bom = findBOMByBomId(bomDTO.getBomId()).toEntity(findBOMByBomId(bomDTO.getBomId()));
		bom.updateBOM(bomDTO);
		bomRepo.save(bom);
	}

	@Override
	public void deleteBOM(Long bomId) {
		bomRepo.deleteBOMByBomId(bomId);
	}

	
	
}
