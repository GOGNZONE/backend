package com.gongzone.release.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.release.dto.ReleaseListDto;
import com.gongzone.release.entity.Release;

/**
 * ReleaseListDto ↔ Release
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ReleaseListMapper extends GenericMapper<ReleaseListDto, Release> {
	
	@Override
	default ReleaseListDto toDto(Release e) {
		
		if(e == null) {
			return null;
		}
		
		Long releaseId = e.getReleaseId();
		String releaseDate = e.getReleaseDate();
		int releaseQuantity = e.getReleaseQuantity();
		String releaseType = e.getReleaseType();
		String clientName = e.getProduction().getClient().getClientName();
		String productionName = e.getProduction().getProductionName();
		
		ReleaseListDto releaseListDto = new ReleaseListDto(
				releaseId, releaseDate, releaseQuantity,
				releaseType, clientName, productionName);
		return releaseListDto;
		
	}
	
}
