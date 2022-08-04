package com.gongzone.storage.controller;

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

import com.gongzone.storage.dto.StorageDTO;
import com.gongzone.storage.entity.Storage;
import com.gongzone.storage.service.StorageServiceImpl;


/**
 * â�� ��Ʈ�ѷ�
 * @author kangdonghyeon
 * @version 1.0
 * */


@RestController
@RequestMapping("/api/storage")
public class StorageController {
	@Autowired
	public StorageServiceImpl storageService;
	
	/**
	 *  ��ü â�� ��ȸ
	 *  @return  List<Storage>
	 */
	@GetMapping("/list")
	public List<Storage> getStock(){
		return storageService.findStorage();
	}
	
	/**
	 * â�� �ڵ�(storageId)�� ��ȸ
	 * @param { storageId }
	 * @return StorageDTO
	 * */
	@GetMapping("/{storageId}")
	public StorageDTO getStockbyid(@PathVariable Long storageId){
		return storageService.findStorageByStorageId(storageId);
	}
	
	
	/**
	 * â�� ���
	 * @param { storageDTO }
	 * @return void
	 * */
	@PostMapping("")
	public void insertStorage(@RequestBody StorageDTO storageDTO) {
		storageService.insertStorage(storageDTO);
//		System.out.println(storageDTO);
	}
	
	/**
	 * â�� ����(storageId)�� ���� ǰ�� ����
	 * @param { storageId, storageDTO }
	 * @return void
	 * */
	@PutMapping("{storageId}")
	public void updateStorage(@PathVariable Long storageId ,@RequestBody StorageDTO storageDTO ) {
//		System.out.println(stockDTO);
		storageService.updateStorage(storageDTO);
	}
	
	/**
	 * â�� �ڵ�(storageId)�� ���� ǰ�� ����
	 * @param { storageId }
	 * @return void
	 * */
	@DeleteMapping("/{storageId}")
	public void deleteStorage(@PathVariable Long storageId) {
		storageService.deleteStorage(storageId);
	}
	
	
}
