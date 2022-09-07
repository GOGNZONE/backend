package com.gongzone.release.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.release.Release;
import com.gongzone.release.dto.ReleaseInsertUpdateDto;

/**
 * ReleaseInsertDto ↔ Release
 * @author Hanju Park
 * @version 1.0 
 * */
@Mapper(componentModel = "spring")
public interface ReleaseInsertUpdateMapper extends GenericMapper<ReleaseInsertUpdateDto, Release> {
	
}
