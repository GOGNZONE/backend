package com.gongzone.storage.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.storage.dto.StorageDTO;
import com.gongzone.storage.dto.StorageUpdateDTO;
import com.gongzone.storage.service.StorageServiceImpl;

import lombok.RequiredArgsConstructor;


/**
 * 창고 컨트롤러
 * @author kangdonghyeon
 * @version 1.0
 * */


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/storage")
public class StorageController {

	private final StorageServiceImpl storageService;
	
	/**
	 *  전체 창고 조회
	 *  @return  List<StorageDTO>
	 */
	@GetMapping("/list")
	public List<StorageDTO> getStock(){
		return storageService.findStorage();
	}
	
	/**
	 * 창고 코드(storageId)로 조회
	 * @param { storageId }
	 * @return StorageDTO
	 * */
	@GetMapping("/{storageId}")
	public StorageDTO getStockbyid(@PathVariable Long storageId){
		return storageService.findStorageByStorageId(storageId);
	}
	
	
	/**
	 * 창고 등록
	 * @param { storageDTO }
	 * @return void
	 * */
	@PostMapping("")
	public void insertStorage(@RequestBody StorageDTO storageDTO) {
		storageService.insertStorage(storageDTO);
	}
	
	/**
	 * 창고 수정(storageId)로 생산 품목 수정
	 * @param { storageId, storageDTO }
	 * @return void
	 * */
	@PutMapping("{storageId}")
	public void updateStorage(@PathVariable Long storageId ,@RequestBody StorageUpdateDTO updateDTO ) {
//		System.out.println(stockDTO);
		storageService.updateStorage(storageId,updateDTO);
	}
	
	/**
	 * 창고 코드(storageId)로 생산 품목 삭제
	 * @param { storageId }
	 * @return void
	 * */
	@DeleteMapping("/{storageId}")
	public void deleteStorage(@PathVariable Long storageId) {
		storageService.deleteStorage(storageId);
	}
	
	
}
