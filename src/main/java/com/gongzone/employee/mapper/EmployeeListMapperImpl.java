package com.gongzone.employee.mapper;

import com.gongzone.employee.dto.EmployeeListDto;
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
public class EmployeeListMapperImpl implements EmployeeListMapper {

    @Override
    public EmployeeListDto toDto(Employee e) {
        if ( e == null ) {
            return null;
        }

        EmployeeListDto.EmployeeListDtoBuilder employeeListDto = EmployeeListDto.builder();

        employeeListDto.employeeId( e.getEmployeeId() );
        employeeListDto.employeeName( e.getEmployeeName() );
        employeeListDto.employeeAddress( e.getEmployeeAddress() );
        employeeListDto.employeeEmail( e.getEmployeeEmail() );
        employeeListDto.employeePhone( e.getEmployeePhone() );
        employeeListDto.employeeHiredate( e.getEmployeeHiredate() );
        employeeListDto.employeeRole( e.getEmployeeRole() );

        return employeeListDto.build();
    }

    @Override
    public Employee toEntity(EmployeeListDto d) {
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

        return employee.build();
    }

    @Override
    public List<EmployeeListDto> toDtoList(List<Employee> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EmployeeListDto> list = new ArrayList<EmployeeListDto>( entityList.size() );
        for ( Employee employee : entityList ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public List<Employee> toEntityList(List<EmployeeListDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dtoList.size() );
        for ( EmployeeListDto employeeListDto : dtoList ) {
            list.add( toEntity( employeeListDto ) );
        }

        return list;
    }
}
