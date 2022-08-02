package com.gongzone.bom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.bom.repository.BOMRepository;

/**
 * BOM ���� �������̽� ����ü
 * @author kangdonghyeon
 * @version 1.0
 */
@Service
public class BOMServiceImpl implements BOMService{
	@Autowired
	public BOMRepository bomRepo;
	
	/**
	 *  ��ü BOM ��ȸ
	 *  @return List<BOM>
	 */
	@Override
	public List<BOM> findBOM() {
		return bomRepo.findAll();
	}

	/**
	 * BOM�ڵ�(bomId)�� ��ȸ
	 * @param { bomId }
	 * @return BOMDTO
	 * */
	@Override
	public BOMDTO findBOMByBomId(Long bomId) {
		return bomRepo.findBOMByBomId(bomId).toDTO(bomRepo.findBOMByBomId(bomId));
	}

	/**
	 * BOM ���
	 * @param { BOMDTO }
	 * @return void
	 * */
	@Override
	public void insertBOM(BOMDTO bomDTO) {
		BOM bomEntity = bomDTO.toEntity(bomDTO);
		bomRepo.save(bomEntity);
	}

	/**
	 * BOM �ڵ�(bomId)�� ����
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
	 * BOM �ڵ�(bomId)�� ����
	 * @param { bomId }
	 * @return void
	 * */
	@Override
	public void deleteBOM(Long bomId) {
		bomRepo.deleteBOMByBomId(bomId);
	}

	
	
}
