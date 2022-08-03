package com.gongzone.release.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.release.dto.ReleaseListDto;
import com.gongzone.release.entity.Release;

/**
 * ReleaseListMapper 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ReleaseListMapper extends GenericMapper<ReleaseListDto, Release> {
	
}