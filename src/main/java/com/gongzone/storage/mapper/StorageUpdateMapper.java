package com.gongzone.storage.mapper;

import org.mapstruct.Mapper;

import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.storage.dto.StorageUpdateDTO;
import com.gongzone.storage.entity.Storage;

/**
 * 창고수정DTO 매핑 인터페이스
 * @author kangdonghyeon
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface StorageUpdateMapper extends GenericMapper<StorageUpdateDTO, Storage>{

}
