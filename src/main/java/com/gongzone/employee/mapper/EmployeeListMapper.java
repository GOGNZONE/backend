package com.gongzone.employee.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.employee.dto.EmployeeListDto;
import com.gongzone.employee.entity.Employee;

/**
 * Employee List Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface EmployeeListMapper extends GenericMapper<EmployeeListDto, Employee> { }
