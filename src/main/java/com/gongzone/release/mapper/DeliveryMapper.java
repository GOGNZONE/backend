package com.gongzone.release.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.release.Delivery;
import com.gongzone.release.dto.DeliveryDto;

/**
 * DeliveryDto ↔ Delivery
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface DeliveryMapper extends GenericMapper<DeliveryDto, Delivery>{

}
