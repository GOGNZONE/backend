package com.gongzone.vehicle.mapper;

import org.mapstruct.Mapper;

import com.gongzone.mapper.GenericMapper;
import com.gongzone.vehicle.dto.VehicleDto;
import com.gongzone.vehicle.entity.Vehicle;

/**
 * VehicleDto ↔ Vehicle
 * @author Hanju Park
 * @version 1.0 
 * */
@Mapper(componentModel = "spring")
public interface VehicleMapper extends GenericMapper<VehicleDto, Vehicle>{

}
