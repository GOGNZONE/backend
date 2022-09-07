package com.gongzone.order.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.order.Order;
import com.gongzone.order.dto.OrderUpdateDTO;


/**
 * 발주 수정 DTO 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface OrderUpdateMapper extends GenericMapper<OrderUpdateDTO, Order> {

}
