package com.gongzone.employee.dto;

import com.gongzone.employee.entity.EmployeeRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 사원 정보에 관한 DTO
 * @author kimmingyu
 * @version 1.0
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
	
	private Long employeeId;
	private String employeeName;
	private String employeeAddress;
	private String employeeEmail;
	private String employeePhone;
	private String employeeHiredate;
	private String employeeImage;
	private EmployeeRole employeeRole;
}
