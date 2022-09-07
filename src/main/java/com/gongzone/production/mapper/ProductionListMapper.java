package com.gongzone.production.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.production.Production;
import com.gongzone.production.dto.ProductionListDto;

/**
 * ProductionListMapper 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ProductionListMapper extends GenericMapper<ProductionListDto, Production>{
	
}
