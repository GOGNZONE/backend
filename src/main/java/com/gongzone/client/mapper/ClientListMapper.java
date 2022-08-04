package com.gongzone.client.mapper;

import org.mapstruct.Mapper;

import com.gongzone.client.dto.ClientListDto;
import com.gongzone.client.entity.Client;
import com.gongzone.mapper.GenericMapper;

/**
 * Client List Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ClientListMapper extends GenericMapper<ClientListDto, Client> {

}
