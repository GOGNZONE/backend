package com.gongzone.release.apiController;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gongzone.release.dto.DeliveryDto;
import com.gongzone.release.service.DeliveryServiceImpl;

import lombok.RequiredArgsConstructor;

/**
 * 배송 컨트롤러
 * @author Hanju Park
 * @version 1.0
 * */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/delivery")
public class DeliveryRestController {
	
	private final DeliveryServiceImpl deliveryServiceImpl;
	
	/**
	 * 배송 등록
	 * @param { deliveryId, deliveryDto }
	 * @return void
	 * */
	@PostMapping("")
	public void insertDelivery(@Validated @RequestBody DeliveryDto deliveryDto) {
		deliveryServiceImpl.insertDelivery(deliveryDto);
	}
	
}
