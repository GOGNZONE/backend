package com.gongzone.client.mapper;

import org.mapstruct.Mapper;

import com.gongzone.client.dto.ReleaseClientDto;
import com.gongzone.client.entity.Client;
import com.gongzone.mapper.GenericMapper;

/**
 * ReleaseClientDto ↔ Client
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ReleaseClientMapper extends GenericMapper<ReleaseClientDto, Client> {

}
