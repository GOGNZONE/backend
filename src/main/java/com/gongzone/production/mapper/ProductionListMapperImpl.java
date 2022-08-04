package com.gongzone.production.mapper;

import com.gongzone.production.dto.ProductionListDto;
import com.gongzone.production.entity.Production;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T05:07:55+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ProductionListMapperImpl implements ProductionListMapper {

    @Override
    public ProductionListDto toDto(Production e) {
        if ( e == null ) {
            return null;
        }

        ProductionListDto.ProductionListDtoBuilder productionListDto = ProductionListDto.builder();

        productionListDto.productionId( e.getProductionId() );
        productionListDto.productionName( e.getProductionName() );
        productionListDto.productionBrandName( e.getProductionBrandName() );
        productionListDto.productionPrice( e.getProductionPrice() );
        productionListDto.productionQuantity( e.getProductionQuantity() );
        productionListDto.productionDescription( e.getProductionDescription() );

        return productionListDto.build();
    }

    @Override
    public Production toEntity(ProductionListDto d) {
        if ( d == null ) {
            return null;
        }

        Production.ProductionBuilder production = Production.builder();

        production.productionId( d.getProductionId() );
        production.productionName( d.getProductionName() );
        production.productionBrandName( d.getProductionBrandName() );
        production.productionPrice( d.getProductionPrice() );
        production.productionQuantity( d.getProductionQuantity() );
        production.productionDescription( d.getProductionDescription() );

        return production.build();
    }

    @Override
    public List<ProductionListDto> toDtoList(List<Production> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductionListDto> list = new ArrayList<ProductionListDto>( entityList.size() );
        for ( Production production : entityList ) {
            list.add( toDto( production ) );
        }

        return list;
    }

    @Override
    public List<Production> toEntityList(List<ProductionListDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Production> list = new ArrayList<Production>( dtoList.size() );
        for ( ProductionListDto productionListDto : dtoList ) {
            list.add( toEntity( productionListDto ) );
        }

        return list;
    }
}