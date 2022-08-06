package com.gongzone.release.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.release.dto.DeliveryDto;
import com.gongzone.release.entity.Delivery;

/**
 * DeliveryDto ↔ Delivery
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface DeliveryMapper extends GenericMapper<DeliveryDto, Delivery>{

}
