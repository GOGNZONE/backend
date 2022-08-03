package com.gongzone.production.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.production.dto.ProductionListDto;
import com.gongzone.production.entity.Production;

/**
 * ProductionListMapper 매핑 인터페이스
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ProductionListMapper extends GenericMapper<ProductionListDto, Production>{
	
//	@Override
//	default Production toEntity(ProductionListDto d) {
//		
//		if(d == null) {
//			return null;
//		}
//		
//		String productionName = d.getProductionName();
//		String productionBrandName = d.getProductionBrandName();
//		Long productionPrice = d.getProductionPrice();
//		int productionQuantity = d.getProductionQuantity();
//		String productionDescription = d.getProductionDescription();
//		
//		Production production = new Production(productionName, productionBrandName, productionPrice, productionQuantity, productionDescription);
//	
//		return production;
//		
//	}
	
}
