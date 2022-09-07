package com.gongzone.employee.mapper;

import com.gongzone.employee.dto.RetiredEmployeeDto;
import com.gongzone.entity.employee.RetiredEmployee;

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
public class RetiredEmployeeMapperImpl implements RetiredEmployeeMapper {

    @Override
    public RetiredEmployeeDto toDto(RetiredEmployee e) {
        if ( e == null ) {
            return null;
        }

        RetiredEmployeeDto.RetiredEmployeeDtoBuilder retiredEmployeeDto = RetiredEmployeeDto.builder();

        retiredEmployeeDto.employeeId( e.getEmployeeId() );
        retiredEmployeeDto.employeeName( e.getEmployeeName() );
        retiredEmployeeDto.employeeAddress( e.getEmployeeAddress() );
        retiredEmployeeDto.employeeEmail( e.getEmployeeEmail() );
        retiredEmployeeDto.employeePhone( e.getEmployeePhone() );
        retiredEmployeeDto.employeeHiredate( e.getEmployeeHiredate() );
        retiredEmployeeDto.employeeRetiredDate( e.getEmployeeRetiredDate() );
        retiredEmployeeDto.employeeRole( e.getEmployeeRole() );
        retiredEmployeeDto.employeeImage( e.getEmployeeImage() );

        return retiredEmployeeDto.build();
    }

    @Override
    public RetiredEmployee toEntity(RetiredEmployeeDto d) {
        if ( d == null ) {
            return null;
        }

        RetiredEmployee.RetiredEmployeeBuilder retiredEmployee = RetiredEmployee.builder();

        retiredEmployee.employeeId( d.getEmployeeId() );
        retiredEmployee.employeeName( d.getEmployeeName() );
        retiredEmployee.employeeAddress( d.getEmployeeAddress() );
        retiredEmployee.employeeEmail( d.getEmployeeEmail() );
        retiredEmployee.employeePhone( d.getEmployeePhone() );
        retiredEmployee.employeeHiredate( d.getEmployeeHiredate() );
        retiredEmployee.employeeRetiredDate( d.getEmployeeRetiredDate() );
        retiredEmployee.employeeRole( d.getEmployeeRole() );
        retiredEmployee.employeeImage( d.getEmployeeImage() );

        return retiredEmployee.build();
    }

    @Override
    public List<RetiredEmployeeDto> toDtoList(List<RetiredEmployee> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RetiredEmployeeDto> list = new ArrayList<RetiredEmployeeDto>( entityList.size() );
        for ( RetiredEmployee retiredEmployee : entityList ) {
            list.add( toDto( retiredEmployee ) );
        }

        return list;
    }

    @Override
    public List<RetiredEmployee> toEntityList(List<RetiredEmployeeDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RetiredEmployee> list = new ArrayList<RetiredEmployee>( dtoList.size() );
        for ( RetiredEmployeeDto retiredEmployeeDto : dtoList ) {
            list.add( toEntity( retiredEmployeeDto ) );
        }

        return list;
    }
}
