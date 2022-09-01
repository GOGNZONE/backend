package com.gongzone.production.mapper;

import com.gongzone.production.dto.ProductionDetailsDto;
import com.gongzone.production.entity.Production;
import com.gongzone.release.entity.Release;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-01T09:37:50+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ProductionDetailsMapperImpl implements ProductionDetailsMapper {

    @Override
    public Production toEntity(ProductionDetailsDto d) {
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
        production.productionDate( d.getProductionDate() );
        List<Release> list = d.getReleases();
        if ( list != null ) {
            production.releases( new ArrayList<Release>( list ) );
        }

        return production.build();
    }

    @Override
    public List<ProductionDetailsDto> toDtoList(List<Production> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProductionDetailsDto> list = new ArrayList<ProductionDetailsDto>( entityList.size() );
        for ( Production production : entityList ) {
            list.add( toDto( production ) );
        }

        return list;
    }

    @Override
    public List<Production> toEntityList(List<ProductionDetailsDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Production> list = new ArrayList<Production>( dtoList.size() );
        for ( ProductionDetailsDto productionDetailsDto : dtoList ) {
            list.add( toEntity( productionDetailsDto ) );
        }

        return list;
    }
}