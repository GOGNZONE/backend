package com.gongzone.service.client;

import com.gongzone.dto.client.AccountInfoDto.AccountInfoRequest;
import com.gongzone.dto.client.AccountInfoDto.AccountInfoResponse;
import com.gongzone.dto.client.UpdateAccountDto;

/**
 * Client account Service Interface
 * @author kimmingyu
 * @version 1.0
 * */
public interface ClientAccountService {
	
	/**
	 * 특정 거래처 조회
	 * @param { accountId }
	 * @return AccountInfoDto
	 * @throws IllegalAccessException 
	 * */
	public AccountInfoResponse findByAccountId(Long accountId) throws IllegalAccessException;
	
	/**
	 * 거래처 등록
	 * @param ClientInfoDto
	 * @param clientId
	 * @return void
	 * */
	public void saveAccount(Long clientId, AccountInfoRequest requestDto);
	
	/**
	 * 거래처 수정
	 * @param { accountId, AccountDto }
	 * @return void
	 * @throws IllegalAccessException 
	 * */
	public void updateAccount(Long accountId, UpdateAccountDto requestDto) throws IllegalAccessException;

}
