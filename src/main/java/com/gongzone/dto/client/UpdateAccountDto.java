package com.gongzone.dto.client;

import com.gongzone.entity.client.ClientAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 거래처 정보 저장에 관한 DTO
 * @author kimmingyu
 * @version 1.0
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAccountDto {

	private Long accountId;
	private String accountBank;
	private String accountNumber;
	private String accountDepositor;
	
	public static class UpdateAccountRequest {
		private Long accountId;
		private String accountBank;
		private String accountNumber;
		private String accountDepositor;
		
		/* DTO -> Entity*/
		public ClientAccount toEntity() {
			ClientAccount clientAccount = ClientAccount.builder()
					.accountId(accountId)
					.accountBank(accountBank)
					.accountNumber(accountNumber)
					.accountDepositor(accountDepositor)
					.build();
			return clientAccount;
		}
	}
}
