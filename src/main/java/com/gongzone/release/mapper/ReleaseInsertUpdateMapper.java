package com.gongzone.release.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.production.entity.Production;
import com.gongzone.release.dto.ReleaseInsertUpdateDto;
import com.gongzone.release.entity.Delivery;
import com.gongzone.release.entity.Release;

/**
 * ReleaseInsertDto ↔ Release
 * @author Hanju Park
 * @version 1.0 
 * */
@Mapper(componentModel = "spring")
public interface ReleaseInsertUpdateMapper extends GenericMapper<ReleaseInsertUpdateDto, Release> {
	
	DeliveryMapper deliveryMapper = Mappers.getMapper(DeliveryMapper.class);
	
	@Override
	default Release toEntity(ReleaseInsertUpdateDto d) {
		
		if ( d == null ) {
          return null;
		}
		
		Long releaseId = d.getReleaseId();
		String releaseDate = d.getReleaseDate();
		String releaseDescription = d.getReleaseDescription();
		int releaseQuantity = d.getReleaseQuantity();
		Long releaseTotalPrice = d.getReleaseTotalPrice();
		String releaseType = d.getReleaseType();
		Production production = d.getProduction();
		// Delivery
		Delivery delivery = deliveryMapper.toEntity(d.getDeliveryDto()); 
		
		Release release = new Release(releaseId, releaseDate, releaseDescription,
				releaseQuantity, releaseTotalPrice, releaseType, production, delivery);
		return release;
		
	}
	
}
