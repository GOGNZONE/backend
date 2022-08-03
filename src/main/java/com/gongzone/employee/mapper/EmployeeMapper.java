package com.gongzone.employee.mapper;

import org.mapstruct.Mapper;

import com.gongzone.employee.dto.EmployeeDto;
import com.gongzone.employee.entity.Employee;
import com.gongzone.mapper.GenericMapper;

/**
 * Employee Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends GenericMapper<EmployeeDto, Employee> { }
