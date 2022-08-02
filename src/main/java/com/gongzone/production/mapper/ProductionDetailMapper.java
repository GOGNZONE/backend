package com.gongzone.production.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.production.dto.ProductionDtoDetail;
import com.gongzone.production.entity.Production;

/**
 * ProductionDtoDetail 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ProductionDetailMapper extends GenericMapper<ProductionDtoDetail, Production>{
	
	@Override
	default Production toEntity(ProductionDtoDetail productionDtoDetail) {
		
		if(productionDtoDetail == null) {
			return null;
		}
		
		String productionName = productionDtoDetail.getProductionName();
		String productionBrandName = productionDtoDetail.getProductionBrandName();
		Long productionPrice = productionDtoDetail.getProductionPrice();
		int productionQuantity = productionDtoDetail.getProductionQuantity();
		String productionDescription = productionDtoDetail.getProductionDescription();
		
		Production production = new Production(productionName, productionBrandName, productionPrice, productionQuantity, productionDescription);
	
		return production;
		
	}
	
}
