package com.gongzone.production.mapper;

import com.gongzone.production.dto.ProductionDtoDetail;
import com.gongzone.production.entity.Production;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-02T14:25:24+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ProductionDetailMapperImpl implements ProductionDetailMapper {

    @Override
    public ProductionDtoDetail toDto(Production e) {
        if ( e == null ) {
            return null;
        }

        ProductionDtoDetail.ProductionDtoDetailBuilder productionDtoDetail = ProductionDtoDetail.builder();

        productionDtoDetail.productionId( e.getProductionId() );
        productionDtoDetail.productionName( e.getProductionName() );
        productionDtoDetail.productionBrandName( e.getProductionBrandName() );
        productionDtoDetail.productionPrice( e.getProductionPrice() );
        productionDtoDetail.productionQuantity( e.getProductionQuantity() );
        productionDtoDetail.productionDescription( e.getProductionDescription() );

        return productionDtoDetail.build();
    }

    @Override
    public List<ProductionDtoDetail> toDtoList(List<Production> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductionDtoDetail> list = new ArrayList<ProductionDtoDetail>( entityList.size() );
        for ( Production production : entityList ) {
            list.add( toDto( production ) );
        }

        return list;
    }

    @Override
    public List<Production> toEntityList(List<ProductionDtoDetail> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Production> list = new ArrayList<Production>( dtoList.size() );
        for ( ProductionDtoDetail productionDtoDetail : dtoList ) {
            list.add( toEntity( productionDtoDetail ) );
        }

        return list;
    }
}
