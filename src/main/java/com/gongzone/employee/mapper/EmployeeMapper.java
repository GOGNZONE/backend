package com.gongzone.employee.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.employee.dto.EmployeeDto;
import com.gongzone.employee.entity.Employee;

/**
 * Employee Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends GenericMapper<EmployeeDto, Employee> { }
