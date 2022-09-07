package com.gongzone.release.mapper;

import com.gongzone.entity.production.Production;
import com.gongzone.entity.release.Delivery;
import com.gongzone.entity.release.Release;
import com.gongzone.production.dto.ReleaseProductionDto;
import com.gongzone.release.dto.DeliveryDto;
import com.gongzone.release.dto.ReleaseDto;

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
public class ReleaseMapperImpl implements ReleaseMapper {

    @Override
    public Release toEntity(ReleaseDto d) {
        if ( d == null ) {
            return null;
        }

        Release.ReleaseBuilder release = Release.builder();

        release.releaseId( d.getReleaseId() );
        release.releaseDate( d.getReleaseDate() );
        release.releaseDescription( d.getReleaseDescription() );
        release.releaseQuantity( d.getReleaseQuantity() );
        release.releaseTotalPrice( d.getReleaseTotalPrice() );
        release.releaseType( d.getReleaseType() );
        release.releaseConfirmed(d.getReleaseConfirmed());
        release.production( releaseProductionDtoToProduction( d.getProduction() ) );
        release.delivery( deliveryDtoToDelivery( d.getDelivery() ) );

        return release.build();
    }

    @Override
    public List<ReleaseDto> toDtoList(List<Release> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ReleaseDto> list = new ArrayList<ReleaseDto>( entityList.size() );
        for ( Release release : entityList ) {
            list.add( toDto( release ) );
        }

        return list;
    }

    @Override
    public List<Release> toEntityList(List<ReleaseDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Release> list = new ArrayList<Release>( dtoList.size() );
        for ( ReleaseDto releaseDto : dtoList ) {
            list.add( toEntity( releaseDto ) );
        }

        return list;
    }

    protected Production releaseProductionDtoToProduction(ReleaseProductionDto releaseProductionDto) {
        if ( releaseProductionDto == null ) {
            return null;
        }

        Production.ProductionBuilder production = Production.builder();

        production.productionName( releaseProductionDto.getProductionName() );
        production.productionBrandName( releaseProductionDto.getProductionBrandName() );
        production.productionPrice( releaseProductionDto.getProductionPrice() );

        return production.build();
    }

    protected Delivery deliveryDtoToDelivery(DeliveryDto deliveryDto) {
        if ( deliveryDto == null ) {
            return null;
        }

        Delivery.DeliveryBuilder delivery = Delivery.builder();

        delivery.deliveryId( deliveryDto.getDeliveryId() );
        delivery.deliveryCompanyName( deliveryDto.getDeliveryCompanyName() );
        delivery.deliveryTrackingNumber( deliveryDto.getDeliveryTrackingNumber() );

        return delivery.build();
    }
}
