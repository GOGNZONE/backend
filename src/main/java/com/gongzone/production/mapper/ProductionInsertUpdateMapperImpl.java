package com.gongzone.production.mapper;

import com.gongzone.entity.production.Production;
import com.gongzone.production.dto.ProductionInsertUpdateDto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-03T15:47:35+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ProductionInsertUpdateMapperImpl implements ProductionInsertUpdateMapper {

    @Override
    public ProductionInsertUpdateDto toDto(Production e) {
        if ( e == null ) {
            return null;
        }

        ProductionInsertUpdateDto.ProductionInsertUpdateDtoBuilder productionInsertUpdateDto = ProductionInsertUpdateDto.builder();

        productionInsertUpdateDto.productionId( e.getProductionId() );
        productionInsertUpdateDto.productionName( e.getProductionName() );
        productionInsertUpdateDto.productionBrandName( e.getProductionBrandName() );
        productionInsertUpdateDto.productionPrice( e.getProductionPrice() );
        productionInsertUpdateDto.productionQuantity( e.getProductionQuantity() );
        productionInsertUpdateDto.productionFile( e.getProductionFile() );
        productionInsertUpdateDto.productionStandard( e.getProductionStandard() );
        productionInsertUpdateDto.productionUnit( e.getProductionUnit() );
        productionInsertUpdateDto.productionDescription( e.getProductionDescription() );
        productionInsertUpdateDto.productionReleasedDate( e.getProductionReleasedDate() );
        productionInsertUpdateDto.productionStartDate( e.getProductionStartDate() );
        productionInsertUpdateDto.productionEndDate(e.getProductionEndDate());
        productionInsertUpdateDto.productionProgress( e.getProductionProgress() );
        productionInsertUpdateDto.client( e.getClient() );
        productionInsertUpdateDto.stock(e.getStock());

        return productionInsertUpdateDto.build();
    }

    @Override
    public Production toEntity(ProductionInsertUpdateDto d) {
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
        production.productionStartDate( d.getProductionStartDate() );
        production.productionEndDate(d.getProductionEndDate());
        production.productionProgress( d.getProductionProgress() );
        production.client( d.getClient() );
        production.stock(d.getStock());

        return production.build();
    }

    @Override
    public List<ProductionInsertUpdateDto> toDtoList(List<Production> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductionInsertUpdateDto> list = new ArrayList<ProductionInsertUpdateDto>( entityList.size() );
        for ( Production production : entityList ) {
            list.add( toDto( production ) );
        }

        return list;
    }

    @Override
    public List<Production> toEntityList(List<ProductionInsertUpdateDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Production> list = new ArrayList<Production>( dtoList.size() );
        for ( ProductionInsertUpdateDto productionInsertUpdateDto : dtoList ) {
            list.add( toEntity( productionInsertUpdateDto ) );
        }

        return list;
    }
}
