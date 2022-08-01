package com.gongzone.production.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.production.dto.ProductionFindAllDTO;
import com.gongzone.production.entity.Production;

/**
 * ProductionFindAllDTO 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductionFindAllMapper extends GenericMapper<ProductionFindAllDTO, Production>{
	
}
