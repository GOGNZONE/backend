package com.gongzone.dto.client;

import com.gongzone.entity.client.Client;
import com.gongzone.entity.client.ClientAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 거래처 정보에 관한 DTO
 * @author kimmingyu
 * @version 1.0
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientInfoDto {
	private Long clientId;
	private String clientName;
	private String clientManager;
	private String clientTel;
	private String clientAddress;
	private String clientRegisteredDate;
	private String clientFile;
	private ClientAccount account;
	private String employeeName;
	
	public ClientInfoDto(Client client) {
		this.clientId = client.getClientId();
		this.clientName = client.getClientName();
		this.clientManager = client.getClientManager();
		this.clientTel = client.getClientTel();
		this.clientAddress = client.getClientAddress();
		this.clientRegisteredDate = client.getClientRegisteredDate();
		this.clientFile = client.getClientFile();
		this.account = client.getClientAccount();
		this.employeeName = client.getEmployee().getEmployeeName();
	}
}
