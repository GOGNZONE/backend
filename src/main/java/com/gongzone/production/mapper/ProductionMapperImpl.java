package com.gongzone.production.mapper;

import com.gongzone.production.dto.ProductionDto;
import com.gongzone.production.entity.Production;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-03T09:49:38+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ProductionMapperImpl implements ProductionMapper {

    @Override
    public ProductionDto toDto(Production e) {
        if ( e == null ) {
            return null;
        }

        ProductionDto.ProductionDtoBuilder productionDto = ProductionDto.builder();

        productionDto.productionId( e.getProductionId() );
        productionDto.productionName( e.getProductionName() );
        productionDto.productionBrandName( e.getProductionBrandName() );
        productionDto.productionPrice( e.getProductionPrice() );
        productionDto.productionQuantity( e.getProductionQuantity() );
        productionDto.productionFile( e.getProductionFile() );
        productionDto.productionStandard( e.getProductionStandard() );
        productionDto.productionUnit( e.getProductionUnit() );
        productionDto.productionDescription( e.getProductionDescription() );
        productionDto.productionReleasedDate( e.getProductionReleasedDate() );
        productionDto.productionDate( e.getProductionDate() );

        return productionDto.build();
    }

    @Override
    public Production toEntity(ProductionDto d) {
        if ( d == null ) {
            return null;
        }

        Production.ProductionBuilder production = Production.builder();

        production.productionId( d.getProductionId() );
        production.productionName( d.getProductionName() );
        production.productionBrandName( d.getProductionBrandName() );
        production.productionPrice( d.getProductionPrice() );
        production.productionQuantity( d.getProductionQuantity() );
        production.productionFile( d.getProductionFile() );
        production.productionStandard( d.getProductionStandard() );
        production.productionUnit( d.getProductionUnit() );
        production.productionDescription( d.getProductionDescription() );
        production.productionReleasedDate( d.getProductionReleasedDate() );
        production.productionDate( d.getProductionDate() );

        return production.build();
    }

    @Override
    public List<ProductionDto> toDtoList(List<Production> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductionDto> list = new ArrayList<ProductionDto>( entityList.size() );
        for ( Production production : entityList ) {
            list.add( toDto( production ) );
        }

        return list;
    }

    @Override
    public List<Production> toEntityList(List<ProductionDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Production> list = new ArrayList<Production>( dtoList.size() );
        for ( ProductionDto productionDto : dtoList ) {
            list.add( toEntity( productionDto ) );
        }

        return list;
    }

    @Override
    public void updateProduction(ProductionDto dto, Production entity) {
        if ( dto == null ) {
            return;
        }
    }
}