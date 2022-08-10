package com.gongzone.employee.dto.response;

import com.gongzone.employee.entity.Employee;

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
	private String employeeEmail;
	private String employeePassword;
	private String employeeAddress;
	private String employeePhone;
	private String employeeHiredate;
	private String employeeImage;
	
	public static EmployeeResponseDto of(Employee employee) {
		return EmployeeResponseDto.builder()
				.employeeId(employee.getEmployeeId())
				.employeeName(employee.getEmployeeName())
				.employeeEmail(employee.getEmployeeEmail())
				.employeePassword(employee.getEmployeePassword())
				.employeeAddress(employee.getEmployeeAddress())
				.employeePhone(employee.getEmployeePhone())
				.employeeHiredate(employee.getEmployeeHiredate())
				.employeeImage(employee.getEmployeeImage())
				.build();
	}
}
