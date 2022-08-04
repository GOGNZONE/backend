package com.gongzone.s3.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.gongzone.s3.service.FileUploadService;



@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FileUploadController {

	private final FileUploadService fileUploadService;
	
	@PostMapping("/api/s3/upload")
	public String uploadImage(@RequestPart MultipartFile file) {
		return fileUploadService.uploadImage(file);
	}
}