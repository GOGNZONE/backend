package com.gongzone.client.service;

import java.util.List;

import com.gongzone.client.dto.AccountDto;
import com.gongzone.client.dto.AccountInfoDto;

/**
 * Client account Service Interface
 * @author kimmingyu
 * @version 1.0
 * */
public interface ClientAccountService {

	/**
	 * 전체 거래처 조회
	 * @return List<AccountDto>
	 * */
	public List<AccountDto> findAllClientAccount();
	
	/**
	 * 특정 거래처 조회
	 * @param { accountId }
	 * @return AccountInfoDto
	 * @throws IllegalAccessException 
	 * */
	public AccountInfoDto findByAccountId(Long accountId) throws IllegalAccessException;
	
	/**
	 * 거래처 등록
	 * @param ClientInfoDto
	 * @param clientId
	 * @return void
	 * */
	public void saveAccount(Long clientId, AccountInfoDto accountInfoDto);
	
	/**
	 * 거래처 수정
	 * @param { accountId, AccountDto }
	 * @return void
	 * @throws IllegalAccessException 
	 * */
	public void updateAccount(Long accountId, AccountDto accountDto) throws IllegalAccessException;

	/**
	 * 특정 거래처 삭제
	 * @param { accountId }
	 * @return void
	 * @throws IllegalAccessException 
	 * */
	public void deleteAccount(Long accountId) throws IllegalAccessException;
}
