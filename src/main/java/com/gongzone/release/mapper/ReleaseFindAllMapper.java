package com.gongzone.release.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.release.dto.ReleaseFindAllDto;
import com.gongzone.release.entity.Release;

/**
 * ReleaseFindAllDto 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ReleaseFindAllMapper extends GenericMapper<ReleaseFindAllDto, Release> {
	
//	@Override
//	default Release toEntity(ReleaseFindAllDto d) {
//		
//		if(d == null) {
//			return null;
//		}
//		
//		String releaseDate = d.getReleaseDate();
//		String releaseDescription = d.getReleaseDescription();
//		int releaseQuantity = d.getReleaseQuantity();
//		Long releaseTotalPrice = d.getReleaseTotalPrice();
//		
//	}
	
}
