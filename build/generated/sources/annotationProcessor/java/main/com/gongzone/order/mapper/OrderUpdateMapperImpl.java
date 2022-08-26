package com.gongzone.order.mapper;

import com.gongzone.order.dto.OrderUpdateDTO;
import com.gongzone.order.entity.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-25T15:58:16+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class OrderUpdateMapperImpl implements OrderUpdateMapper {

    @Override
    public OrderUpdateDTO toDto(Order e) {
        if ( e == null ) {
            return null;
        }

        OrderUpdateDTO.OrderUpdateDTOBuilder orderUpdateDTO = OrderUpdateDTO.builder();

        orderUpdateDTO.orderProductionName( e.getOrderProductionName() );
        orderUpdateDTO.orderProductionBrandName( e.getOrderProductionBrandName() );
        orderUpdateDTO.orderProductionPrice( e.getOrderProductionPrice() );
        orderUpdateDTO.orderProductionQuantity( e.getOrderProductionQuantity() );
        orderUpdateDTO.orderProuctionFile( e.getOrderProuctionFile() );
        orderUpdateDTO.orderProductionStandard( e.getOrderProductionStandard() );
        orderUpdateDTO.orderProductionUnit( e.getOrderProductionUnit() );
        orderUpdateDTO.orderProductionDescription( e.getOrderProductionDescription() );
        orderUpdateDTO.orderProductionEndDate( e.getOrderProductionEndDate() );

        return orderUpdateDTO.build();
    }

    @Override
    public Order toEntity(OrderUpdateDTO d) {
        if ( d == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.orderProductionName( d.getOrderProductionName() );
        order.orderProductionBrandName( d.getOrderProductionBrandName() );
        order.orderProductionPrice( d.getOrderProductionPrice() );
        order.orderProductionQuantity( d.getOrderProductionQuantity() );
        order.orderProuctionFile( d.getOrderProuctionFile() );
        order.orderProductionStandard( d.getOrderProductionStandard() );
        order.orderProductionUnit( d.getOrderProductionUnit() );
        order.orderProductionDescription( d.getOrderProductionDescription() );
        order.orderProductionEndDate( d.getOrderProductionEndDate() );

        return order.build();
    }

    @Override
    public List<OrderUpdateDTO> toDtoList(List<Order> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrderUpdateDTO> list = new ArrayList<OrderUpdateDTO>( entityList.size() );
        for ( Order order : entityList ) {
            list.add( toDto( order ) );
        }

        return list;
    }

    @Override
    public List<Order> toEntityList(List<OrderUpdateDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( dtoList.size() );
        for ( OrderUpdateDTO orderUpdateDTO : dtoList ) {
            list.add( toEntity( orderUpdateDTO ) );
        }

        return list;
    }
}
