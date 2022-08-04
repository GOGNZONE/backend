package com.gongzone.client.dto;

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
}
