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
public class UpdateClientDto {

	private String clientName;
	private String clientTel;
	private String clientAddress;
	private String clientFile;
	private String clientManager;
	
	public Client toEntity() {
		Client client = Client.builder()
				.clientName(clientName)
				.clientTel(clientTel)
				.clientAddress(clientAddress)
				.clientFile(clientFile)
				.clientManager(clientManager)
				.build();
		return client;
	}
}
