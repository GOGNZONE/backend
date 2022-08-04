package com.gongzone.employee.mapper;

import org.mapstruct.Mapper;

import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.entity.Employee;
import com.gongzone.mapper.GenericMapper;

/**
 * Employee List Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface EmployeeListMapper extends GenericMapper<EmployeeListDto, Employee> { }
