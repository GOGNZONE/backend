package com.gongzone.employee.mapper;

import org.mapstruct.Mapper;

import com.gongzone.employee.dto.RetiredEmployeeDto;
import com.gongzone.employee.entity.RetiredEmployee;
import com.gongzone.mapper.GenericMapper;

/**
 * Retired Employee List Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface RetiredEmployeeMapper extends GenericMapper<RetiredEmployeeDto, RetiredEmployee> { }