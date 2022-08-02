package com.gongzone.storage.service;

import java.util.List;

import com.gongzone.storage.dto.StorageDTO;
import com.gongzone.storage.entity.Storage;

/**
 * â�� ���� �������̽�
 * @author kangdonghyeon
 * @version 1.0
 * */
public interface StorageService {
	/**
	 *  ��ü â�� ��ȸ
	 *  @return  List<Storage>
	 */
	public List<Storage> findStorage();
	
	/**
	 * â�� �ڵ�(storageId)�� ��ȸ
	 * @param { storageId }
	 * @return StorageDTO
	 * */
	public StorageDTO findStorageByStorageId(Long storageId);
	
	/**
	 * â�� ���
	 * @param { storageDTO }
	 * @return void
	 * */
	public void insertStorage(StorageDTO storageDTO);
	
	/**
	 * â�� ����(production_id)�� ���� ǰ�� ����
	 * @param { productionId, productionDTO }
	 * @return void
	 * */
	public void updateStorage(StorageDTO storageDTO);
	

	/**
	 * â�� �ڵ�(storageId)�� ���� ǰ�� ����
	 * @param { storageId }
	 * @return void
	 * */
	public void deleteStorage(Long storageId);
}
