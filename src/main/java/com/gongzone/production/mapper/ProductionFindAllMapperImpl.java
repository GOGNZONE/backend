package com.gongzone.production.mapper;

import com.gongzone.production.dto.ProductionFindAllDto;
import com.gongzone.production.entity.Production;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-02T17:02:29+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ProductionFindAllMapperImpl implements ProductionFindAllMapper {

    @Override
    public ProductionFindAllDto toDto(Production e) {
        if ( e == null ) {
            return null;
        }

        ProductionFindAllDto.ProductionFindAllDtoBuilder productionFindAllDto = ProductionFindAllDto.builder();

        productionFindAllDto.productionId( e.getProductionId() );
        productionFindAllDto.productionName( e.getProductionName() );
        productionFindAllDto.productionBrandName( e.getProductionBrandName() );
        productionFindAllDto.productionPrice( e.getProductionPrice() );
        productionFindAllDto.productionQuantity( e.getProductionQuantity() );
        productionFindAllDto.productionDescription( e.getProductionDescription() );

        return productionFindAllDto.build();
    }

    @Override
    public List<ProductionFindAllDto> toDtoList(List<Production> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductionFindAllDto> list = new ArrayList<ProductionFindAllDto>( entityList.size() );
        for ( Production production : entityList ) {
            list.add( toDto( production ) );
        }

        return list;
    }

    @Override
    public List<Production> toEntityList(List<ProductionFindAllDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Production> list = new ArrayList<Production>( dtoList.size() );
        for ( ProductionFindAllDto productionFindAllDto : dtoList ) {
            list.add( toEntity( productionFindAllDto ) );
        }

        return list;
    }
}
