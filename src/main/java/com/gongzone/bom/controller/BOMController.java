package com.gongzone.bom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.bom.service.BOMServiceImpl;

@RestController
public class BOMController {
	@Autowired
	public BOMServiceImpl bomService;
	
	@GetMapping(value="/api/BOM/list")
	public List<BOM> findBOM(){
		return bomService.findBOM();
	}
	
	
	@GetMapping(value="/api/BOM/{bomid}")
	public BOMDTO findBOMByBomId(Long bomId) {
		return bomService.findBOMByBomId(bomId);
	}
	
	@PostMapping(value="/api/BOM")
	public void insertBOM(BOMDTO bomDTO) {
		bomService.insertBOM(bomDTO);
	}
	
	@PutMapping(value="/api/BOM")
	public void updateBOM(BOMDTO bomDTO) {
		bomService.updateBOM(bomDTO);
	}
	
	@DeleteMapping(value="/api/BOM/{bomid}")
	public void deleteBOM(Long bomId) {
		bomService.deleteBOM(bomId);
	}
	
	
	
}
