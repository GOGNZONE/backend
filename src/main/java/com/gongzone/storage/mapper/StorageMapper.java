package com.gongzone.storage.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.storage.Storage;
import com.gongzone.storage.dto.StorageDTO;

/**
 * 창고DTO 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface StorageMapper extends GenericMapper<StorageDTO, Storage>{

}
