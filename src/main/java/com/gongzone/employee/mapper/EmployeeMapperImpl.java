package com.gongzone.employee.mapper;

import com.gongzone.employee.dto.EmployeeDto;
import com.gongzone.employee.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-02T17:26:52+0900",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto toDto(Employee e) {
        if ( e == null ) {
            return null;
        }

        EmployeeDto.EmployeeDtoBuilder employeeDto = EmployeeDto.builder();

        employeeDto.employeeId( e.getEmployeeId() );
        employeeDto.employeeName( e.getEmployeeName() );
        employeeDto.employeeAddress( e.getEmployeeAddress() );
        employeeDto.employeeEmail( e.getEmployeeEmail() );
        employeeDto.employeePhone( e.getEmployeePhone() );
        employeeDto.employeeHiredate( e.getEmployeeHiredate() );
        employeeDto.employeeImage( e.getEmployeeImage() );
        employeeDto.employeeRole( e.getEmployeeRole() );

        return employeeDto.build();
    }

    @Override
    public Employee toEntity(EmployeeDto d) {
        if ( d == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.employeeId( d.getEmployeeId() );
        employee.employeeName( d.getEmployeeName() );
        employee.employeeAddress( d.getEmployeeAddress() );
        employee.employeeEmail( d.getEmployeeEmail() );
        employee.employeePhone( d.getEmployeePhone() );
        employee.employeeHiredate( d.getEmployeeHiredate() );
        employee.employeeRole( d.getEmployeeRole() );
        employee.employeeImage( d.getEmployeeImage() );

        return employee.build();
    }

    @Override
    public List<EmployeeDto> toDtoList(List<Employee> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( entityList.size() );
        for ( Employee employee : entityList ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public List<Employee> toEntityList(List<EmployeeDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dtoList.size() );
        for ( EmployeeDto employeeDto : dtoList ) {
            list.add( toEntity( employeeDto ) );
        }

        return list;
    }
}
