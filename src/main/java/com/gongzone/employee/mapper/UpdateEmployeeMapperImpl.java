package com.gongzone.employee.mapper;

import com.gongzone.employee.dto.UpdateEmployeeDto;
import com.gongzone.employee.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-02T17:44:36+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class UpdateEmployeeMapperImpl implements UpdateEmployeeMapper {

    @Override
    public UpdateEmployeeDto toDto(Employee e) {
        if ( e == null ) {
            return null;
        }

        UpdateEmployeeDto.UpdateEmployeeDtoBuilder updateEmployeeDto = UpdateEmployeeDto.builder();

        updateEmployeeDto.employeeName( e.getEmployeeName() );
        updateEmployeeDto.employeePhone( e.getEmployeePhone() );
        updateEmployeeDto.employeeAddress( e.getEmployeeAddress() );
        updateEmployeeDto.employeeEmail( e.getEmployeeEmail() );

        return updateEmployeeDto.build();
    }

    @Override
    public Employee toEntity(UpdateEmployeeDto d) {
        if ( d == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.employeeName( d.getEmployeeName() );
        employee.employeeAddress( d.getEmployeeAddress() );
        employee.employeeEmail( d.getEmployeeEmail() );
        employee.employeePhone( d.getEmployeePhone() );

        return employee.build();
    }

    @Override
    public List<UpdateEmployeeDto> toDtoList(List<Employee> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UpdateEmployeeDto> list = new ArrayList<UpdateEmployeeDto>( entityList.size() );
        for ( Employee employee : entityList ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public List<Employee> toEntityList(List<UpdateEmployeeDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dtoList.size() );
        for ( UpdateEmployeeDto updateEmployeeDto : dtoList ) {
            list.add( toEntity( updateEmployeeDto ) );
        }

        return list;
    }
}
