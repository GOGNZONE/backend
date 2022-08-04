package com.gongzone.production.mapper;

import com.gongzone.production.dto.ReleaseProductionDto;
import com.gongzone.production.entity.Production;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T10:53:13+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ReleaseProductionMapperImpl implements ReleaseProductionMapper {

    @Override
    public ReleaseProductionDto toDto(Production e) {
        if ( e == null ) {
            return null;
        }

        ReleaseProductionDto.ReleaseProductionDtoBuilder releaseProductionDto = ReleaseProductionDto.builder();

        releaseProductionDto.productionName( e.getProductionName() );
        releaseProductionDto.productionBrandName( e.getProductionBrandName() );
        releaseProductionDto.productionPrice( e.getProductionPrice() );

        return releaseProductionDto.build();
    }

    @Override
    public Production toEntity(ReleaseProductionDto d) {
        if ( d == null ) {
            return null;
        }

        Production.ProductionBuilder production = Production.builder();

        production.productionName( d.getProductionName() );
        production.productionBrandName( d.getProductionBrandName() );
        production.productionPrice( d.getProductionPrice() );

        return production.build();
    }

    @Override
    public List<ReleaseProductionDto> toDtoList(List<Production> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReleaseProductionDto> list = new ArrayList<ReleaseProductionDto>( entityList.size() );
        for ( Production production : entityList ) {
            list.add( toDto( production ) );
        }

        return list;
    }

    @Override
    public List<Production> toEntityList(List<ReleaseProductionDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Production> list = new ArrayList<Production>( dtoList.size() );
        for ( ReleaseProductionDto releaseProductionDto : dtoList ) {
            list.add( toEntity( releaseProductionDto ) );
        }

        return list;
    }
}
