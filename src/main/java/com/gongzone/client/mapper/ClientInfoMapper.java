package com.gongzone.client.mapper;

import org.mapstruct.Mapper;

import com.gongzone.client.dto.ClientInfoDto;
import com.gongzone.common.mapper.GenericMapper;
import com.gongzone.entity.client.Client;

/**
 * Client Information Mapping Iterface
 * @author kimmingyu
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ClientInfoMapper extends GenericMapper<ClientInfoDto, Client> {

	@Override
	default ClientInfoDto toDto(Client e) {
		
		 if ( e == null ) {
	            return null;
	        }

	        ClientInfoDto.ClientInfoDtoBuilder clientInfoDto = ClientInfoDto.builder();

	        clientInfoDto.clientId( e.getClientId() );
	        clientInfoDto.clientName( e.getClientName() );
	        clientInfoDto.clientManager( e.getClientManager() );
	        clientInfoDto.clientTel( e.getClientTel() );
	        clientInfoDto.clientAddress( e.getClientAddress() );
	        clientInfoDto.clientRegisteredDate( e.getClientRegisteredDate() );
	        clientInfoDto.clientFile( e.getClientFile() );
	        clientInfoDto.account( e.getClientAccount() );
	        clientInfoDto.employeeName( e.getEmployee().getEmployeeName() );

	        return clientInfoDto.build();
	}
}
