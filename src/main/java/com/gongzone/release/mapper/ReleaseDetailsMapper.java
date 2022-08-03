package com.gongzone.release.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gongzone.client.dto.ReleaseClientDto;
import com.gongzone.client.mapper.ReleaseClientMapper;
import com.gongzone.delivery.dto.DeliveryDto;
import com.gongzone.delivery.mapper.DeliveryMapper;
import com.gongzone.mapper.GenericMapper;
import com.gongzone.production.dto.ReleaseProductionDto;
import com.gongzone.production.mapper.ReleaseProductionMapper;
import com.gongzone.release.dto.ReleaseDetailsDto;
import com.gongzone.release.entity.Release;
import com.gongzone.release.entity.ReleaseType;
import com.gongzone.vehicle.dto.VehicleDto;
import com.gongzone.vehicle.mapper.VehicleMapper;

/**
 * ReleaseDto ↔ Release 
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ReleaseDetailsMapper extends GenericMapper<ReleaseDetailsDto, Release> {
	
	ReleaseClientMapper releaseClientMapper = Mappers.getMapper(ReleaseClientMapper.class);
	ReleaseProductionMapper releaseProductionMapper = Mappers.getMapper(ReleaseProductionMapper.class);
	DeliveryMapper deliveryMapper = Mappers.getMapper(DeliveryMapper.class);
	VehicleMapper vehicleMapper = Mappers.getMapper(VehicleMapper.class);
	
	@Override
	default ReleaseDetailsDto toDto(Release e) {
		
		if(e == null) {
			return null;
		}
		
		Long releaseId = e.getReleaseId();
		String releaseDate = e.getReleaseDate();
		String releaseDescription = e.getReleaseDescription();
		int releaseQuantity = e.getReleaseQuantity();
		Long releaseTotalPrice = e.getReleaseTotalPrice();
		ReleaseType releaseType = e.getReleaseType();
		// Client Info
		ReleaseClientDto releaseDetailsInClientDto = releaseClientMapper.toDto(e.getClient());
		// Employee Info
		
		// Production Info
		ReleaseProductionDto releaseDetailsInProductionDto = releaseProductionMapper.toDto(e.getProduction());
		// Delivery Info
		DeliveryDto deliveryDto = deliveryMapper.toDto(e.getDelivery());
		// Vehicle Info
		VehicleDto vehicleDto = vehicleMapper.toDto(e.getVehicle());
		
		ReleaseDetailsDto releaseDetailsDeliveryDto = new ReleaseDetailsDto(
				releaseId, releaseDate, releaseDescription, 
				releaseQuantity, releaseTotalPrice, releaseType, 
				releaseDetailsInClientDto, releaseDetailsInProductionDto, deliveryDto, vehicleDto);
		return releaseDetailsDeliveryDto;
		
	}
	
}
