package com.gongzone.s3.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.gongzone.s3.service.S3Service;
import lombok.RequiredArgsConstructor;


/**
 * S3 컨트롤러
 * @author kangdonghyeon
 * @version 1.0
 */

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class S3Controller {
    private final S3Service service;

    
    /**
	 *  S3에 파일 업로드
	 *  @return String
	 */
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
    }

    
    /**
   	 *  S3에 있는 파일 다운로드
   	 *  @param { fileName }
   	 *  @return ByteArrayResource
   	 */
    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {    
    	byte[] data = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    /**
   	 *  S3에 있는 파일 삭제
   	 *  @param { fileName }
   	 *  @return String
   	 */	
    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
    }
}