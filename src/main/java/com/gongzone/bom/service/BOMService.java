package com.gongzone.bom.service;

import java.util.List;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;


/**
 * BOM ���� �������̽�
 * @author kangdonghyeon
 * @version 1.0
 */
public interface BOMService {
	/**
	 *  ��ü BOM ��ȸ
	 *  @return List<BOM>
	 */
	public List<BOM> findBOM();
	
	/**
	 * BOM�ڵ�(bomId)�� ��ȸ
	 * @param { bomId }
	 * @return BOMDTO
	 * */
	public BOMDTO findBOMByBomId(Long bomId);
	
	/**
	 * BOM ���
	 * @param { BOMDTO }
	 * @return void
	 * */
	public void insertBOM(BOMDTO bomDTO);
	
	/**
	 * BOM �ڵ�(bomId)�� ����
	 * @param { BOMDTO }
	 * @return void
	 * */
	public void updateBOM(BOMDTO bomDTO);
	
	/**
	 * BOM �ڵ�(bomId)�� ����
	 * @param { bomId }
	 * @return void
	 * */
	public void deleteBOM(Long bomId);
}
