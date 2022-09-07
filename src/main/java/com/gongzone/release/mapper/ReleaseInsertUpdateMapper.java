package com.gongzone.release.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.release.dto.ReleaseInsertUpdateDto;
import com.gongzone.release.entity.Release;

/**
 * ReleaseInsertDto ↔ Release
 * @author Hanju Park
 * @version 1.0 
 * */
@Mapper(componentModel = "spring")
public interface ReleaseInsertUpdateMapper extends GenericMapper<ReleaseInsertUpdateDto, Release> {
	
}
