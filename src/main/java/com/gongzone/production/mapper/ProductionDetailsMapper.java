package com.gongzone.production.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gongzone.client.mapper.ReleaseClientMapper;
import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.production.dto.ProductionDetailsDto;
import com.gongzone.production.entity.Production;
import com.gongzone.release.entity.Release;

/**
 * ProductionDetailsDto ↔ Production
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ProductionDetailsMapper extends GenericMapper<ProductionDetailsDto, Production> {
	
	ReleaseClientMapper releaseClientMapper = Mappers.getMapper(ReleaseClientMapper.class);
	
	@Override
	default ProductionDetailsDto toDto(Production e) {
		
		if(e == null) {
			return null;
		}
		
		ProductionDetailsDto.ProductionDetailsDtoBuilder productionDetailsDto = ProductionDetailsDto.builder();

		productionDetailsDto.productionId( e.getProductionId() );
		productionDetailsDto.productionName( e.getProductionName() );
		productionDetailsDto.productionBrandName( e.getProductionBrandName() );
		productionDetailsDto.productionPrice( e.getProductionPrice() );
		productionDetailsDto.productionQuantity( e.getProductionQuantity() );
		productionDetailsDto.productionFile( e.getProductionFile() );
		productionDetailsDto.productionStandard( e.getProductionStandard() );
		productionDetailsDto.productionUnit( e.getProductionUnit() );
		productionDetailsDto.productionDescription( e.getProductionDescription() );
		productionDetailsDto.productionReleasedDate(e.getProductionReleasedDate());
		productionDetailsDto.productionStartDate( e.getProductionStartDate() );
		productionDetailsDto.productionEndDate(e.getProductionEndDate());
		productionDetailsDto.productionProgress(e.getProductionProgress());
		productionDetailsDto.client(releaseClientMapper.toDto(e.getClient()));
        List<Release> list = e.getReleases();
        if ( list != null ) {
        	productionDetailsDto.releases( new ArrayList<Release>( list ) );
        }

        return productionDetailsDto.build();
        
	}
	
}
