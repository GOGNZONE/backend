package com.gongzone.order.mapper;

import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-02T18:19:55+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO toDto(Order e) {
        if ( e == null ) {
            return null;
        }

        OrderDTO.OrderDTOBuilder orderDTO = OrderDTO.builder();

        orderDTO.orderId( e.getOrderId() );
        orderDTO.orderProductionName( e.getOrderProductionName() );
        orderDTO.orderProductionBrandName( e.getOrderProductionBrandName() );
        orderDTO.orderProductionPrice( e.getOrderProductionPrice() );
        orderDTO.orderProductionQuantity( e.getOrderProductionQuantity() );
        orderDTO.orderProuctionFile( e.getOrderProuctionFile() );
        orderDTO.orderProductionStandard( e.getOrderProductionStandard() );
        orderDTO.orderProductionUnit( e.getOrderProductionUnit() );
        orderDTO.orderProductionDescription( e.getOrderProductionDescription() );
        orderDTO.orderProductionEndDate( e.getOrderProductionEndDate() );
        orderDTO.orderDate( e.getOrderDate() );
        orderDTO.client( e.getClient() );

        return orderDTO.build();
    }

    @Override
    public Order toEntity(OrderDTO d) {
        if ( d == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        order.orderId( d.getOrderId() );
        order.orderProductionName( d.getOrderProductionName() );
        order.orderProductionBrandName( d.getOrderProductionBrandName() );
        order.orderProductionPrice( d.getOrderProductionPrice() );
        order.orderProductionQuantity( d.getOrderProductionQuantity() );
        order.orderProuctionFile( d.getOrderProuctionFile() );
        order.orderProductionStandard( d.getOrderProductionStandard() );
        order.orderProductionUnit( d.getOrderProductionUnit() );
        order.orderProductionDescription( d.getOrderProductionDescription() );
        order.orderProductionEndDate( d.getOrderProductionEndDate() );
        order.orderDate( d.getOrderDate() );
        order.client( d.getClient() );

        return order.build();
    }

    @Override
    public List<OrderDTO> toDtoList(List<Order> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( entityList.size() );
        for ( Order order : entityList ) {
            list.add( toDto( order ) );
        }

        return list;
    }

    @Override
    public List<Order> toEntityList(List<OrderDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( dtoList.size() );
        for ( OrderDTO orderDTO : dtoList ) {
            list.add( toEntity( orderDTO ) );
        }

        return list;
    }
}
