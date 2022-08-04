package com.gongzone.bom.mapper;

import org.mapstruct.Mapper;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.mapper.GenericMapper;

@Mapper(componentModel = "spring")
public interface BomMapper extends GenericMapper<BOMDTO, BOM> {

}
