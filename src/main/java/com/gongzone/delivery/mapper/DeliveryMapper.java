package com.gongzone.delivery.mapper;

import org.mapstruct.Mapper;

import com.gongzone.delivery.dto.DeliveryDto;
import com.gongzone.delivery.entity.Delivery;
import com.gongzone.mapper.GenericMapper;

/**
 * DeliveryDto ↔ Delivery
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface DeliveryMapper extends GenericMapper<DeliveryDto, Delivery>{

}
