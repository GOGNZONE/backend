package com.gongzone.bom.mapper;

import org.mapstruct.Mapper;

import com.gongzone.bom.dto.BOMUpdateDTO;
import com.gongzone.bom.entity.BOM;
import com.gongzone.mapper.GenericMapper;

/**
 * BomUpdateMapper 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface BomUpdateMapper extends GenericMapper<BOMUpdateDTO, BOM> {

}
