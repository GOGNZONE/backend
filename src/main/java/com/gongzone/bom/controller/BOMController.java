package com.gongzone.bom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.bom.service.BOMServiceImpl;


/**
 * BOM ��Ʈ�ѷ�
 * @author kangdonghyeon
 * @version 1.0
 */
@RestController
@RequestMapping("/api/BOM")
public class BOMController {
	@Autowired
	public BOMServiceImpl bomService;
	
	
	/**
	 *  ��ü BOM ��ȸ
	 *  @return List<BOM>
	 */
	@GetMapping("/list")
	public List<BOM> findBOM(){
		return bomService.findBOM();
	}
	
	/**
	 * BOM�ڵ�(bomId)�� ��ȸ
	 * @param { bomId }
	 * @return BOMDTO
	 * */
	@GetMapping("/{bomid}")
	public BOMDTO findBOMByBomId(Long bomId) {
		return bomService.findBOMByBomId(bomId);
	}
	
	/**
	 * BOM ���
	 * @param { BOMDTO }
	 * @return void
	 * */
	@PostMapping("")
	public void insertBOM(BOMDTO bomDTO) {
		bomService.insertBOM(bomDTO);
	}
	
	/**
	 * BOM �ڵ�(bomId)�� ����
	 * @param { bomId, BOMDTO }
	 * @return void
	 * */
	@PutMapping("{bomId}")
	public void updateBOM(@PathVariable Long bomId,@RequestBody BOMDTO bomDTO) {
		bomService.updateBOM(bomDTO);
	}
	
	
	/**
	 * BOM �ڵ�(bomId)�� ����
	 * @param { bomId }
	 * @return void
	 * */
	@DeleteMapping("/{bomid}")
	public void deleteBOM(Long bomId) {
		bomService.deleteBOM(bomId);
	}
	
	
	
}
