package com.gongzone.employee.dto;

import com.gongzone.entity.employee.Employee;
import com.gongzone.entity.employee.EmployeeRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponseDto {

	private Long employeeId;
	private String employeeName;
	private String employeeAddress;
	private String employeeEmail;
	private String employeePhone;
	private String employeeHiredate;
	private String employeeImage;
	private EmployeeRole employeeRole;
	
	public static EmployeeResponseDto of(Employee employee) {
		return EmployeeResponseDto.builder()
				.employeeId(employee.getEmployeeId())
				.employeeName(employee.getEmployeeName())
				.employeeAddress(employee.getEmployeeAddress())
				.employeeEmail(employee.getEmployeeEmail())
				.employeePhone(employee.getEmployeePhone())
				.employeeHiredate(employee.getEmployeeHiredate())
				.employeeImage(employee.getEmployeeImage())
				.employeeRole(employee.getEmployeeRole())
				.build();
	}
}
