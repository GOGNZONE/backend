package com.gongzone.order.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.order.dto.OrderDTO;
import com.gongzone.order.entity.Order;


/**
 * 발주 DTO 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface OrderMapper extends GenericMapper<OrderDTO, Order> {

}
