package com.gongzone.dto.client;

import com.gongzone.entity.client.Client;
import com.gongzone.entity.employee.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 거래처 정보 엔티티
 * @author kimmingyu
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterClientDto {
	
	private Long clientId;
	private String clientName;
	private String clientManager;
	private String clientTel;
	private String clientAddress;
	private String clientFile;
	private Employee employee;
		
		/* DTO -> Entity */
		public Client toEntity() {
			Client client = Client.builder()
					.clientId(clientId)
					.clientName(clientName)
					.clientManager(clientManager)
					.clientTel(clientTel)
					.clientAddress(clientAddress)
					.clientFile(clientFile)
					.employee(employee)
					.build();
			return client;
		}
}
