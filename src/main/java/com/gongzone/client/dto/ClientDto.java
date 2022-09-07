package com.gongzone.client.dto;

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
public class ClientDto {
	
	private Long clientId;
	private String clientName;
	private String clientManager;
	private String clientTel;
	private String clientAddress;
	private String clientFile;
	private Employee employee;
}
