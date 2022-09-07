package com.gongzone.service.implement.client;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.client.dto.AccountDto;
import com.gongzone.client.dto.AccountInfoDto;
import com.gongzone.client.mapper.AccountInfoMapper;
import com.gongzone.client.mapper.AccountMapper;
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
	private final AccountInfoMapper accountInfoMapper = Mappers.getMapper(AccountInfoMapper.class);
	private final AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);
	
	/**
	 * 전체 거래처 조회
	 * 
	 * @return List<AccountDto>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<AccountDto> findAllClientAccount() {
		List<ClientAccount> accounts = accountRepository.findAll();
		return accountMapper.toDtoList(accounts);
	}
	
	/**
	 * 특정 거래처 조회
	 * 
	 * @param accountId Long
	 * @return AccountInfoDto
	 */
	@Override
	@Transactional(readOnly = true)
	public AccountInfoDto findByAccountId(Long accountId) throws IllegalAccessException {
		ClientAccount account = accountRepository.findById(accountId).orElseThrow();
		return accountInfoMapper.toDto(account);
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
	public void saveAccount(Long clientId, AccountInfoDto accountInfoDto) {
		Client client = clientRepository.findById(clientId).orElseThrow(
				() -> new IllegalArgumentException("해당하는 거래처가 존재하지 않습니다."));
		
		accountInfoDto.setClient(client);
		ClientAccount account =  accountInfoDto.toEntity();
		accountRepository.save(account);
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
	public void updateAccount(Long accountId, AccountDto accountDto) throws IllegalAccessException {
		ClientAccount account = accountRepository.findById(accountId).orElseThrow(
				() -> new IllegalArgumentException("해당하는 계좌정보가 존재하지 않습니다."));
		
		account.updateClientAccount(
				accountDto.getAccountBank(),
				accountDto.getAccountNumber(),
				accountDto.getAccountDepositor());
	}
	
	/**
	 * 거래처 삭제
	 * 
	 * @throws IllegalAccessException
	 * @param accountId Long
	 * @return void
	 */
	@Override
	@Transactional
	public void deleteAccount(Long accountId) throws IllegalAccessException {
		ClientAccount account = accountRepository.findById(accountId).orElseThrow(
				() -> new IllegalArgumentException("해당하는 계좌정보가 존재하지 않습니다."));
		
		accountRepository.delete(account);
	}


}
