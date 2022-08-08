package com.gongzone.bom.mapper;

import org.mapstruct.Mapper;

import com.gongzone.bom.dto.BOMListDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.mapper.GenericMapper;


/**
 * BomListMapper 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface BomListMapper extends GenericMapper<BOMListDTO, BOM> {

}
