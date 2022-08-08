package com.gongzone.production.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.production.dto.ProductionListDto;
import com.gongzone.production.entity.Production;

/**
 * ProductionListMapper 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ProductionListMapper extends GenericMapper<ProductionListDto, Production>{
	
}
