package com.gongzone.release.service;

import com.gongzone.release.dto.DeliveryDto;

/**
 * 배송 서비스 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
public interface DeliveryService {
	
	/**
	 * 배송 등록
	 * @param { deliveryId, deliveryDto }
	 * @return void
	 * */
	public void insertDelivery(DeliveryDto deliveryDto);
	
}
