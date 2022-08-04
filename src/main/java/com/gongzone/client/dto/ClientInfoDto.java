package com.gongzone.client.dto;

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
	private String accountAccountBank;
	private String accountNumber;
	private String accountDepositor;
	private String employeeName;
}
