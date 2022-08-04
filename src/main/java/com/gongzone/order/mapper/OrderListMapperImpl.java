package com.gongzone.order.mapper;

import com.gongzone.order.dto.OrderListDTO;
import com.gongzone.order.entity.Order;
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
public class OrderListMapperImpl implements OrderListMapper {

    @Override
    public OrderListDTO toDto(Order e) {
        if ( e == null ) {
            return null;
        }

        OrderListDTO.OrderListDTOBuilder orderListDTO = OrderListDTO.builder();

        orderListDTO.orderId( e.getOrderId() );
        orderListDTO.orderProductionName( e.getOrderProductionName() );
        orderListDTO.orderProductionBrandName( e.getOrderProductionBrandName() );
        orderListDTO.orderProductionPrice( e.getOrderProductionPrice() );
        orderListDTO.orderProductionQuantity( e.getOrderProductionQuantity() );
        orderListDTO.orderProductionDescription( e.getOrderProductionDescription() );

        return orderListDTO.build();
    }

    @Override
    public Order toEntity(OrderListDTO d) {
        if ( d == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.orderId( d.getOrderId() );
        order.orderProductionName( d.getOrderProductionName() );
        order.orderProductionBrandName( d.getOrderProductionBrandName() );
        order.orderProductionPrice( d.getOrderProductionPrice() );
        order.orderProductionQuantity( d.getOrderProductionQuantity() );
        order.orderProductionDescription( d.getOrderProductionDescription() );

        return order.build();
    }

    @Override
    public List<OrderListDTO> toDtoList(List<Order> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrderListDTO> list = new ArrayList<OrderListDTO>( entityList.size() );
        for ( Order order : entityList ) {
            list.add( toDto( order ) );
        }

        return list;
    }

    @Override
    public List<Order> toEntityList(List<OrderListDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( dtoList.size() );
        for ( OrderListDTO orderListDTO : dtoList ) {
            list.add( toEntity( orderListDTO ) );
        }

        return list;
    }
}
