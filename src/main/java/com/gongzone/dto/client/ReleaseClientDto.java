package com.gongzone.dto.client;

import com.gongzone.entity.client.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 출고 상세 조회 거래처 정보 Dto
 * @author Hanju Park
 * @version 1.0
 * */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReleaseClientDto {
	
	private Long clientId;
	private String clientName;
	private String clientManager;
	private String clientTel;
	private String clientAddress;
	private String employeeName;
	
	/** Entity -> DTO */
	public ReleaseClientDto(Client client) {
		this.clientId = client.getClientId();
		this.clientName = client.getClientName();
		this.clientManager = client.getClientManager();
		this.clientTel = client.getClientTel();
		this.clientAddress = client.getClientAddress();
		this.employeeName = client.getEmployee().getEmployeeName();
	}
	
}
