package com.gongzone.production.mapper;

import com.gongzone.production.dto.ProductionUpdateDto;
import com.gongzone.production.entity.Production;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T17:12:25+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.16 (Eclipse Adoptium)"
)
@Component
public class ProductionUpdateMapperImpl implements ProductionUpdateMapper {

    @Override
    public ProductionUpdateDto toDto(Production e) {
        if ( e == null ) {
            return null;
        }

        ProductionUpdateDto.ProductionUpdateDtoBuilder productionUpdateDto = ProductionUpdateDto.builder();

        productionUpdateDto.productionId( e.getProductionId() );
        productionUpdateDto.productionName( e.getProductionName() );
        productionUpdateDto.productionBrandName( e.getProductionBrandName() );
        productionUpdateDto.productionPrice( e.getProductionPrice() );
        productionUpdateDto.productionQuantity( e.getProductionQuantity() );
        productionUpdateDto.productionFile( e.getProductionFile() );
        productionUpdateDto.productionStandard( e.getProductionStandard() );
        productionUpdateDto.productionUnit( e.getProductionUnit() );
        productionUpdateDto.productionDescription( e.getProductionDescription() );
        productionUpdateDto.productionReleasedDate( e.getProductionReleasedDate() );

        return productionUpdateDto.build();
    }

    @Override
    public Production toEntity(ProductionUpdateDto d) {
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

        return production.build();
    }

    @Override
    public List<ProductionUpdateDto> toDtoList(List<Production> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductionUpdateDto> list = new ArrayList<ProductionUpdateDto>( entityList.size() );
        for ( Production production : entityList ) {
            list.add( toDto( production ) );
        }

        return list;
    }

    @Override
    public List<Production> toEntityList(List<ProductionUpdateDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Production> list = new ArrayList<Production>( dtoList.size() );
        for ( ProductionUpdateDto productionUpdateDto : dtoList ) {
            list.add( toEntity( productionUpdateDto ) );
        }

        return list;
    }
}
