package com.gongzone.client.dto;

import com.gongzone.entity.client.Client;
import com.gongzone.entity.client.ClientAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 거래처 계좌 정보에 관한 DTO
 * @author kimmingyu
 * @version 1.0
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfoDto {
	
	private Long accountId;
	private String accountBank;
	private String accountNumber;
	private String accountDepositor;
	private Client client;
	
	public ClientAccount toEntity() {
		ClientAccount account = ClientAccount.builder()
				.accountId(accountId)
				.accountBank(accountBank)
				.accountDepositor(accountDepositor)
				.accountNumber(accountNumber)
				.client(client)
				.build();
		
		return account;
	}
}
