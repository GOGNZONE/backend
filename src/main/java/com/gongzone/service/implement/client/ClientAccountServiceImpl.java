package com.gongzone.service.implement.client;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.dto.client.AccountInfoDto.AccountInfoRequest;
import com.gongzone.dto.client.AccountInfoDto.AccountInfoResponse;
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
	public AccountInfoResponse findByAccountId(Long accountId) throws IllegalAccessException {
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
				() -> new IllegalArgumentException("해당하는 거래처가 존재하지 않습니다."));
		
		accountInfoDto.setClient(client);
		accountRepository.save(accountInfoDto.toEntity());
	}
	
	/**
	 * 계좌정보 수정
	 * 
	 * @throws IllegalAccessException
	 * @param accountId Long
	 * @param AccountDto
	 * @return void
	 */
	@Override
	@Transactional
	public void updateAccount(Long accountId, UpdateAccountDto updateAccountDto) throws IllegalAccessException {
		ClientAccount account = accountRepository.findById(accountId).orElseThrow(
				() -> new IllegalArgumentException("해당하는 계좌정보가 존재하지 않습니다."));
		
		account.updateClientAccount(
				updateAccountDto.getAccountBank(),
				updateAccountDto.getAccountNumber(),
				updateAccountDto.getAccountDepositor());
	}
	
}
