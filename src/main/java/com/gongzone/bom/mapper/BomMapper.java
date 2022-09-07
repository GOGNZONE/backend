package com.gongzone.bom.mapper;

import org.mapstruct.Mapper;

import com.gongzone.bom.dto.BOMDTO;
import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.bom.BOM;

/**
 * BomMapper 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface BomMapper extends GenericMapper<BOMDTO, BOM> {

}
