package com.gongzone.employee.mapper;

import org.mapstruct.Mapper;

import com.gongzone.employee.dto.UpdateEmployeeDto;
import com.gongzone.employee.entity.Employee;
import com.gongzone.mapper.GenericMapper;

/**
 * Update Employee Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface UpdateEmployeeMapper extends GenericMapper<UpdateEmployeeDto, Employee> {

}
