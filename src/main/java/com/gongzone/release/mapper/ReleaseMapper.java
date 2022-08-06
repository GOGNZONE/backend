package com.gongzone.release.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gongzone.client.dto.ReleaseClientDto;
import com.gongzone.client.mapper.ReleaseClientMapper;
import com.gongzone.mapper.GenericMapper;
import com.gongzone.production.dto.ReleaseProductionDto;
import com.gongzone.production.mapper.ReleaseProductionMapper;
import com.gongzone.release.dto.DeliveryDto;
import com.gongzone.release.dto.ReleaseDto;
import com.gongzone.release.entity.Release;

/**
 * ReleaseDto ↔ Release 
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ReleaseMapper extends GenericMapper<ReleaseDto, Release> {
	
	ReleaseClientMapper releaseClientMapper = Mappers.getMapper(ReleaseClientMapper.class);
	ReleaseProductionMapper releaseProductionMapper = Mappers.getMapper(ReleaseProductionMapper.class);
	DeliveryMapper deliveryMapper = Mappers.getMapper(DeliveryMapper.class);
	
	@Override
	default ReleaseDto toDto(Release e) {
		
		if(e == null) {
			return null;
		}
		
		Long releaseId = e.getReleaseId();
		String releaseDate = e.getReleaseDate();
		String releaseDescription = e.getReleaseDescription();
		int releaseQuantity = e.getReleaseQuantity();
		Long releaseTotalPrice = e.getReleaseTotalPrice();
		String releaseType = e.getReleaseType();
		// Client
		ReleaseClientDto releaseClientDto  = releaseClientMapper.toDto(e.getProduction().getClient());
		// Production
		ReleaseProductionDto releaseProductionDto = releaseProductionMapper.toDto(e.getProduction());
		// Delivery
		DeliveryDto deliveryDto = deliveryMapper.toDto(e.getDelivery());
		
		ReleaseDto releaseDetailsDto = new ReleaseDto(
				releaseId, releaseDate, releaseDescription, 
				releaseQuantity, releaseTotalPrice, releaseType, 
				releaseClientDto, releaseProductionDto, deliveryDto);
		return releaseDetailsDto;
		
	}
	
//	@Override
//	default Release toEntity(ReleaseDto d) {
//		
//		if(d == null) {
//			return null;
//		}
//		
//		Long releaseId = d.getReleaseId();
//		String releaseDate = d.getReleaseDate();
//		String releaseDescription = d.getReleaseDescription();
//		int releaseQuantity = d.getReleaseQuantity();
//		Long releaseTotalPrice = d.getReleaseTotalPrice();
//		String releaseType = d.getReleaseType();
//		// Production
//		Production production = releaseProductionMapper.toEntity(d.getReleaseProductionDto());
//		// Delivery
//		Delivery delivery = deliveryMapper.toEntity(d.getDeliveryDto());
//		
//		Release release = new Release(
//				releaseId, releaseDate, releaseDescription,
//				releaseQuantity, releaseTotalPrice, releaseType,
//				production, delivery);
//		return release;
//		
//	}
	
}
