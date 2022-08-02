package com.gongzone.bom.service;

import java.util.List;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;


public interface BOMService {
	public List<BOM> findBOM();
	public BOMDTO findBOMByBomId(Long bomId);
	public void insertBOM(BOMDTO bomDTO);
	public void updateBOM(BOMDTO bomDTO);
	public void deleteBOM(Long bomId);
}
