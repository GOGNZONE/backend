package com.gongzone.storage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.storage.dto.StorageDTO;
import com.gongzone.storage.entity.Storage;
import com.gongzone.storage.service.StorageServiceImpl;


@RestController
public class StorageController {
	@Autowired
	public StorageServiceImpl storageService;
	
	@GetMapping(value="/api/storage/list")
	public List<Storage> getStock(){
		return storageService.findStorage();
	}
	
	@GetMapping(value="/api/storage/{storageId}")
	public StorageDTO getStockbyid(@PathVariable Long storageId){
		return storageService.findStorageByStorageId(storageId);
	}
	
	@PostMapping(value="/api/storage")
	public void insertStorage(@RequestBody StorageDTO storageDTO) {
		storageService.insertStorage(storageDTO);
//		System.out.println(storageDTO);
	}
	@PutMapping(value="/api/storage")
	public void updateStorage(@RequestBody StorageDTO storageDTO) {
//		System.out.println(stockDTO);
		storageService.updateStorage(storageDTO);
	}
	@DeleteMapping(value="/api/storage/{storageId}")
	public void deleteStorage(@PathVariable Long storageId) {
		storageService.deleteStorage(storageId);
	}
	
	
}
