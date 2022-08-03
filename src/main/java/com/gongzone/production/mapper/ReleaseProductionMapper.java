package com.gongzone.production.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.production.dto.ReleaseProductionDto;
import com.gongzone.production.entity.Production;

/**
 * ReleaseProductionDto ↔ Production
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ReleaseProductionMapper extends GenericMapper<ReleaseProductionDto, Production>{

}
