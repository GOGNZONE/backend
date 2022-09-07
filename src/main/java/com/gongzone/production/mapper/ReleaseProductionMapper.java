package com.gongzone.production.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.production.Production;
import com.gongzone.production.dto.ReleaseProductionDto;

/**
 * ReleaseProductionDto ↔ Production
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ReleaseProductionMapper extends GenericMapper<ReleaseProductionDto, Production>{

}
