package com.gongzone.release.apiController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.release.dto.DeliveryDto;
import com.gongzone.release.service.DeliveryServiceImpl;

import lombok.RequiredArgsConstructor;

/**
 * 택배 컨트롤러 
 * @author Hanju Park
 * @version 1.0
 * */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/delivery")
public class DeliveryRestController {
	
	private final DeliveryServiceImpl deliveryServiceImpl;
	
	/**
	 * 배송 등록
	 * @param { deliveryDto }
	 * @return ResponseEntity<Void>
	 * */
	@PostMapping("")
	public ResponseEntity<Void> insertDelivery(@RequestBody @Validated final DeliveryDto deliveryDto) {
		deliveryServiceImpl.insertDelivery(deliveryDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.build();
	}
	
}
