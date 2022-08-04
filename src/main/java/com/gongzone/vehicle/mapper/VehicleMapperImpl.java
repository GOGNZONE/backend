package com.gongzone.vehicle.mapper;

import com.gongzone.vehicle.dto.VehicleDto;
import com.gongzone.vehicle.entity.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-04T05:28:37+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public VehicleDto toDto(Vehicle e) {
        if ( e == null ) {
            return null;
        }

        VehicleDto.VehicleDtoBuilder vehicleDto = VehicleDto.builder();

        vehicleDto.vehicleId( e.getVehicleId() );
        vehicleDto.vehicleNumber( e.getVehicleNumber() );
        vehicleDto.vehicleType( e.getVehicleType() );

        return vehicleDto.build();
    }

    @Override
    public Vehicle toEntity(VehicleDto d) {
        if ( d == null ) {
            return null;
        }

        Vehicle.VehicleBuilder vehicle = Vehicle.builder();

        vehicle.vehicleId( d.getVehicleId() );
        vehicle.vehicleNumber( d.getVehicleNumber() );
        vehicle.vehicleType( d.getVehicleType() );

        return vehicle.build();
    }

    @Override
    public List<VehicleDto> toDtoList(List<Vehicle> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VehicleDto> list = new ArrayList<VehicleDto>( entityList.size() );
        for ( Vehicle vehicle : entityList ) {
            list.add( toDto( vehicle ) );
        }

        return list;
    }

    @Override
    public List<Vehicle> toEntityList(List<VehicleDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Vehicle> list = new ArrayList<Vehicle>( dtoList.size() );
        for ( VehicleDto vehicleDto : dtoList ) {
            list.add( toEntity( vehicleDto ) );
        }

        return list;
    }
}
