package com.gongzone.client.dto;

import com.gongzone.client.entity.ClientAccount;

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
}
