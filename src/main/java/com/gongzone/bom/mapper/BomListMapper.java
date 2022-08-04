package com.gongzone.bom.mapper;

import org.mapstruct.Mapper;

import com.gongzone.bom.dto.BOMListDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.mapper.GenericMapper;

@Mapper(componentModel = "spring")
public interface BomListMapper extends GenericMapper<BOMListDTO, BOM> {

}
