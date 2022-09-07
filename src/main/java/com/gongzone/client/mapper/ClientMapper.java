package com.gongzone.client.mapper;

import org.mapstruct.Mapper;

import com.gongzone.client.dto.ClientDto;
import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.client.Client;

/**
 * Client Account Information Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ClientMapper extends GenericMapper<ClientDto, Client> {

}
