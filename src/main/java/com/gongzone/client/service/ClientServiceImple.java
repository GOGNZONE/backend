package com.gongzone.client.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.client.dto.ClientDto;
import com.gongzone.client.dto.ClientInfoDto;
import com.gongzone.client.dto.ClientListDto;
import com.gongzone.client.dto.UpdateClientDto;
import com.gongzone.client.entity.Client;
import com.gongzone.client.mapper.ClientInfoMapper;
import com.gongzone.client.mapper.ClientListMapper;
import com.gongzone.client.mapper.ClientMapper;
import com.gongzone.client.mapper.UpdateClientMapper;
import com.gongzone.client.repository.ClientRepository;
import com.gongzone.employee.entity.Employee;
import com.gongzone.employee.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImple implements ClientService {
	
	private final ClientRepository clientRepository;
	private final EmployeeRepository employeeRepository;
	private final ClientInfoMapper clientInfoMapper = Mappers.getMapper(ClientInfoMapper.class);
	private final ClientListMapper clientListMapper = Mappers.getMapper(ClientListMapper.class);
	private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
	private final UpdateClientMapper updateClientMapper = Mappers.getMapper(UpdateClientMapper.class);
	
	/**
	 * 전체 거래처 조회
	 * 
	 * @return List<ClientListDto>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ClientListDto> findAllClient() {
		List<Client> clients = clientRepository.findAll();
		return clientListMapper.toDtoList(clients);
	}
	
	/**
	 * 특정 거래처 조회
	 * 
	 * @param clientId Long
	 * @return ClientInfoDto
	 */
	@Override
	@Transactional(readOnly = true)
	public ClientInfoDto findByClientId(Long clientId) throws IllegalAccessException {
		Client client = clientRepository.findById(clientId).orElseThrow(
				() -> new IllegalArgumentException("해당하는 거래처가 존재하지 않습니다."));
		return clientInfoMapper.toDto(client);
	}
	
	/**
	 * 거래처 등록
	 * 
	 * @param ClientDto
	 * @return ClientInfoDto
	 */
	@Override
	@Transactional
	public void saveClient(ClientDto clientDto) {
		Employee employee = employeeRepository.findById(clientDto.getEmployee().getEmployeeId()).orElseThrow(
				() -> new IllegalArgumentException("존재하지 않는 사원입니다."));
		clientDto.setEmployee(employee);
		clientRepository.save(clientMapper.toEntity(clientDto));
	}

	/**
	 * 거래처 수정
	 * 
	 * @throws IllegalAccessException
	 * @param clientId Long
	 * @param UpdateClientDto
	 * @return void
	 */
	@Override
	@Transactional
	public void updateClient(Long clientId, UpdateClientDto updateDto) throws IllegalAccessException {
		Client client = clientRepository.findById(clientId).orElseThrow(
				() -> new IllegalArgumentException("해당하는 거래처가 존재하지 않습니다."));
		
		client.updateClient(updateClientMapper.toEntity(updateDto));
	}
	
	/**
	 * 거래처 삭제
	 * 
	 * @throws IllegalAccessException
	 * @param clientId Long
	 * @return void
	 */
	@Override
	@Transactional
	public void deleteClient(Long clientId) throws IllegalAccessException {
		Client client = clientRepository.findById(clientId).orElseThrow(
				() -> new IllegalArgumentException("해당하는 거래처가 존재하지 않습니다."));
		
		clientRepository.delete(client);
	}

	
}
