package com.gongzone.client.dto;

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
public class AccountDto {

	private String accountBank;
	private String accountNumber;
	private String accountDepositor;
}
