package com.gongzone.delivery.mapper;

import com.gongzone.delivery.dto.DeliveryDto;
import com.gongzone.delivery.entity.Delivery;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T17:48:34+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public DeliveryDto toDto(Delivery e) {
        if ( e == null ) {
            return null;
        }

        DeliveryDto.DeliveryDtoBuilder deliveryDto = DeliveryDto.builder();

        deliveryDto.deliveryId( e.getDeliveryId() );
        deliveryDto.deliveryCompanyName( e.getDeliveryCompanyName() );
        deliveryDto.deliveryTrackingNumber( e.getDeliveryTrackingNumber() );

        return deliveryDto.build();
    }

    @Override
    public Delivery toEntity(DeliveryDto d) {
        if ( d == null ) {
            return null;
        }

        Delivery.DeliveryBuilder delivery = Delivery.builder();

        delivery.deliveryId( d.getDeliveryId() );
        delivery.deliveryCompanyName( d.getDeliveryCompanyName() );
        delivery.deliveryTrackingNumber( d.getDeliveryTrackingNumber() );

        return delivery.build();
    }

    @Override
    public List<DeliveryDto> toDtoList(List<Delivery> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DeliveryDto> list = new ArrayList<DeliveryDto>( entityList.size() );
        for ( Delivery delivery : entityList ) {
            list.add( toDto( delivery ) );
        }

        return list;
    }

    @Override
    public List<Delivery> toEntityList(List<DeliveryDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Delivery> list = new ArrayList<Delivery>( dtoList.size() );
        for ( DeliveryDto deliveryDto : dtoList ) {
            list.add( toEntity( deliveryDto ) );
        }

        return list;
    }
}
