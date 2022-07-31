package com.gongzone.util;

import org.mapstruct.Mapper;
import com.gongzone.dto.ProductionDTO;
import com.gongzone.entity.Production;

/**
 * 생산 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ProductionMapper extends GenericMapper<ProductionDTO, Production>{
	
}