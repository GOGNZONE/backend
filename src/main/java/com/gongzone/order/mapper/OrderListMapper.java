package com.gongzone.order.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.order.dto.OrderListDTO;
import com.gongzone.order.entity.Order;


/**
 * 발주 리스트 DTO 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface OrderListMapper extends GenericMapper<OrderListDTO, Order> {

}
