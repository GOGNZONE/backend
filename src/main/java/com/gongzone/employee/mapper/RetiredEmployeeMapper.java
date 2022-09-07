package com.gongzone.employee.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.employee.dto.RetiredEmployeeDto;
import com.gongzone.entity.employee.RetiredEmployee;

/**
 * Retired Employee List Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface RetiredEmployeeMapper extends GenericMapper<RetiredEmployeeDto, RetiredEmployee> { }