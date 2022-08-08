package com.gongzone.client.mapper;

import org.mapstruct.Mapper;

import com.gongzone.client.dto.ReleaseClientDto;
import com.gongzone.client.entity.Client;
import com.gongzone.common.mapper.GenericMapper;

/**
 * ReleaseClientDto ↔ Client
 * @author Hanju Park
 * @version 1.0
 * */
@Mapper(componentModel = "spring")
public interface ReleaseClientMapper extends GenericMapper<ReleaseClientDto, Client> {

	@Override
	default ReleaseClientDto toDto(Client e) {
		
		if(e == null) {
			return null;
		}
		
		Long clientId = e.getClientId();
		String clientName = e.getClientName();
		String clientManager = e.getClientManager();
		String clientTel = e.getClientTel();
		String clientAddress = e.getClientAddress();
		String employeeName = e.getEmployee().getEmployeeName();
		
		ReleaseClientDto releaseClientDto = new ReleaseClientDto(clientId, clientName, clientManager, clientTel, clientAddress, employeeName);
		
		return releaseClientDto;
		
	}
	
}
