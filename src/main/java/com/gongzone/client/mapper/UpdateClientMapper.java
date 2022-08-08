package com.gongzone.client.mapper;

import org.mapstruct.Mapper;

import com.gongzone.client.dto.UpdateClientDto;
import com.gongzone.client.entity.Client;
import com.gongzone.mapper.GenericMapper;

/**
 * Update Client Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface UpdateClientMapper extends GenericMapper<UpdateClientDto, Client> {

}
