package com.gongzone.client.mapper;

import org.mapstruct.Mapper;

import com.gongzone.client.dto.AccountInfoDto;
import com.gongzone.client.entity.ClientAccount;
import com.gongzone.mapper.GenericMapper;

/**
 * Client Account Information Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface AccountInfoMapper extends GenericMapper<AccountInfoDto, ClientAccount> {

}