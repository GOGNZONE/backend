package com.gongzone.employee.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.dto.employee.EmployeeDto;
import com.gongzone.entity.employee.Employee;

/**
 * Employee Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface EmployeeMapper extends GenericMapper<EmployeeDto, Employee> { }
