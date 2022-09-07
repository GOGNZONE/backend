package com.gongzone.service.client;

import java.util.List;

import com.gongzone.client.dto.ClientDto;
import com.gongzone.client.dto.ClientInfoDto;
import com.gongzone.client.dto.ClientListDto;
import com.gongzone.client.dto.UpdateClientDto;

/**
 * Client Service Interface
 * @author kimmingyu
 * @version 1.0
 * */
public interface ClientService {

	/**
	 * 전체 거래처 조회
	 * @return List<ClientListDto>
	 * */
	public List<ClientListDto> findAllClient();
	
	/**
	 * 거래처 등록
	 * @param { ClientInfoDto }
	 * @return void
	 * */
	public void saveClient(ClientDto clientDto);
	
	/**
	 * 특정 거래처 조회
	 * @param { clientId }
	 * @return EmployeeInfoDto
	 * @throws IllegalAccessException 
	 * */
	public ClientInfoDto findByClientId(Long clientId) throws IllegalAccessException;
	
	/**
	 * 거래처 수정
	 * @param { clientId, UpdateClientDto }
	 * @return void
	 * @throws IllegalAccessException 
	 * */
	public void updateClient(Long clientId, UpdateClientDto updateDto) throws IllegalAccessException;
	
	/**
	 * 특정 거래처 삭제
	 * @param { clientId }
	 * @return void
	 * @throws IllegalAccessException 
	 * */
	public void deleteClient(Long clientId) throws IllegalAccessException;
}
