package com.gongzone.service.implement.client;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.dto.client.AccountInfoDto.AccountInfoRequest;
import com.gongzone.dto.client.AccountInfoDto.AccountInfoResponse;
import com.gongzone.common.errors.errorcode.CommonErrorCode;
import com.gongzone.common.errors.exception.RestApiException;
import com.gongzone.dto.client.UpdateAccountDto;
import com.gongzone.entity.client.Client;
import com.gongzone.entity.client.ClientAccount;
import com.gongzone.repository.client.ClientAccountRepository;
import com.gongzone.repository.client.ClientRepository;
import com.gongzone.service.client.ClientAccountService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientAccountServiceImpl implements ClientAccountService {
	
	private final ClientAccountRepository accountRepository;
	private final ClientRepository clientRepository;
	
	/**
	 * 특정 거래처 조회
	 * 
	 * @param accountId Long
	 * @return AccountInfoDto
	 */
	@Override
	@Transactional(readOnly = true)
	public AccountInfoResponse findByAccountId(Long accountId) {
		ClientAccount account = accountRepository.findById(accountId).orElseThrow();
		return new AccountInfoResponse(account);
	}
	
	/**
	 * 특정 거래처 계좌 등록
	 * 
	 * @param clientId Long
	 * @param AccountInfoDto
	 * @return void
	 */
	@Override
	@Transactional
	public void saveAccount(Long clientId, AccountInfoRequest accountInfoDto) {
		Client client = clientRepository.findById(clientId).orElseThrow(
				() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		accountInfoDto.setClient(client);
		accountRepository.save(accountInfoDto.toEntity());
	}
	
	/**
	 * 계좌정보 수정
	 * 
	 * @param accountId Long
	 * @param AccountDto
	 * @return void
	 */
	@Override
	@Transactional
	public void updateAccount(Long accountId, UpdateAccountDto updateAccountDto) {
		ClientAccount account = accountRepository.findById(accountId).orElseThrow(
				() -> new RestApiException(CommonErrorCode.RESOURCE_NOT_FOUND));
		account.updateClientAccount(
				updateAccountDto.getAccountBank(),
				updateAccountDto.getAccountNumber(),
				updateAccountDto.getAccountDepositor());
	}
	
}
