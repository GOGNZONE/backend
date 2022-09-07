package com.gongzone.dto.client;

import com.gongzone.entity.client.Client;
import com.gongzone.entity.client.ClientAccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
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
	
	@Data
	public static class AccountInfoRequest {
		private Long accountId;
		private String accountBank;
		private String accountNumber;
		private String accountDepositor;
		private Client client;
		
		/* DTO -> Entity */
		public ClientAccount toEntity() {
			ClientAccount clientAccount = ClientAccount.builder()
					.accountId(accountId)
					.accountBank(accountBank)
					.accountNumber(accountNumber)
					.accountDepositor(accountDepositor)
					.client(client)
					.build();
			return clientAccount;
		}
	}
	
	@Getter
	public static class AccountInfoResponse {
		private Long accountId;
		private String accountBank;
		private String accountNumber;
		private String accountDepositor;
		private Client client;
		
		/* Entity -> DTO */
		public AccountInfoResponse(ClientAccount clientAccount) {
			this.accountId = clientAccount.getAccountId();
			this.accountBank = clientAccount.getAccountBank();
			this.accountNumber = clientAccount.getAccountNumber();
			this.accountDepositor = clientAccount.getAccountDepositor();
			this.client = clientAccount.getClient();
					
		}
	}
	
}
