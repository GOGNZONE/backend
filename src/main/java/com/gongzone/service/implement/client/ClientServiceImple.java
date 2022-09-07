package com.gongzone.service.implement.client;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongzone.dto.client.ClientInfoDto;
import com.gongzone.dto.client.ClientListDto;
import com.gongzone.dto.client.RegisterClientDto;
import com.gongzone.dto.client.UpdateClientDto;
import com.gongzone.entity.client.Client;
import com.gongzone.entity.employee.Employee;
import com.gongzone.repository.client.ClientRepository;
import com.gongzone.repository.employee.EmployeeRepository;
import com.gongzone.service.client.ClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImple implements ClientService {

	private final ClientRepository clientRepository;
	private final EmployeeRepository employeeRepository;

	/**
	 * 전체 거래처 조회
	 * 
	 * @return List<ClientListDto>
	 */
	@Override
	@Transactional(readOnly = true)
	public List<ClientListDto> findAllClient() {
		List<ClientListDto> clients = clientRepository.findAll()
				.stream()
				.map(ClientListDto::new)
				.collect(Collectors.toList());
				return clients;
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
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new IllegalArgumentException("해당하는 거래처가 존재하지 않습니다."));
		return new ClientInfoDto(client);
	}


	/**
	 * 거래처 등록
	 * 
	 * @param ClientDto
	 * @return RegisterClientDto
	 */
	@Override
	@Transactional
	public void saveClient(RegisterClientDto clientDto) {
		Employee employee = employeeRepository.findById(clientDto.getEmployee().getEmployeeId())
				.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사원입니다."));
		clientDto.setEmployee(employee);
		
		clientRepository.save(clientDto.toEntity());
	}

	/**
	 * 거래처 수정
	 * 
	 * @throws IllegalAccessException
	 * @param clientId        Long
	 * @param UpdateClientDto
	 * @return void
	 */
	@Override
	@Transactional
	public void updateClient(Long clientId, UpdateClientDto updateDto) throws IllegalAccessException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new IllegalArgumentException("해당하는 거래처가 존재하지 않습니다."));

		client.updateClient(updateDto.toEntity());
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
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new IllegalArgumentException("해당하는 거래처가 존재하지 않습니다."));

		clientRepository.delete(client);
	}

}
