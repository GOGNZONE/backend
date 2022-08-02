package com.gongzone.production.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.entity.Production;

/**
 * 생산 품목 상세 조회, 생산 품목 등록 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ProductionMapper extends GenericMapper<ProductionDto, Production> {
	
	@Override
	default Production toEntity(ProductionDto d) {
		
		if(d == null) {
			return null;
		}
		
		String productionName = d.getProductionName();
		String productionBrandName = d.getProductionBrandName();
		Long productionPrice = d.getProductionPrice();
		int productionQuantity = d.getProductionQuantity();
		String productionFile = d.getProductionFile();
		String productionStandard = d.getProductionStandard();
		String productionUnit = d.getProductionUnit();
		String productionDescription = d.getProductionDescription();
		String productionReleasedDate = d.getProductionReleasedDate();
		String productionDate = d.getProductionDate();
		
		Production production = new Production(productionName, productionBrandName, productionPrice,
				productionQuantity, productionFile, productionStandard, productionUnit,
				productionDescription, productionReleasedDate, productionDate);
		
		return production;
	}
	
}
