package com.gongzone.production.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.production.dto.ProductionUpdateDto;
import com.gongzone.production.entity.Production;

/**
 * ProductionUpdateDto 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ProductionUpdateMapper extends GenericMapper<ProductionUpdateDto, Production> {

}
