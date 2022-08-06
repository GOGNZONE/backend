package com.gongzone.release.service;

import javax.transaction.Transactional;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.gongzone.release.dto.DeliveryDto;
import com.gongzone.release.entity.Delivery;
import com.gongzone.release.mapper.DeliveryMapper;
import com.gongzone.release.repository.DeliveryRepository;

import lombok.RequiredArgsConstructor;

/**
 * 배송 서비스 인터페이스 구현체
 * @author Hanju Park
 * @version 1.0
 * */
@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
	
	private final DeliveryRepository deliveryRepository;

	private final DeliveryMapper deliveryMapper = Mappers.getMapper(DeliveryMapper.class);
	
	/**
	 * 배송 등록
	 * @param { deliveryId, deliveryDto }
	 * @return void
	 * */
	@Override
	@Transactional
	public void insertDelivery(DeliveryDto deliveryDto) {
		deliveryRepository.save(toEntity(deliveryDto));
	}
	
	/* MapStruct Mapper DeliveryDto → Delivery */
	protected Delivery toEntity(DeliveryDto deliveryDto) {
		return deliveryMapper.toEntity(deliveryDto);
	}
	
}
