package com.gongzone.dto.client;

import com.gongzone.entity.client.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 거래처 리스트에 관한 DTO
 * @author kimmingyu
 * @version 1.0
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientListDto {

	private Long clientId;
	private String clientName;
	private String clientAddress;
	private String clientManager;
	private String clientTel;
	private String clientRegisteredDate;
	
	/* Entity -> DTO */
	public ClientListDto(Client client) {
		this.clientId = client.getClientId();
		this.clientName = client.getClientName();
		this.clientAddress = client.getClientAddress();
		this.clientManager = client.getClientManager();
		this.clientTel = client.getClientTel();
		this.clientRegisteredDate = client.getClientRegisteredDate();
	}
}
