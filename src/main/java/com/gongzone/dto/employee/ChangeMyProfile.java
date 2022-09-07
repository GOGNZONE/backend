package com.gongzone.dto.employee;

import com.gongzone.entity.employee.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeMyProfile {
	private String employeeEmail;
	private String newPassword;
	private String employeeName;
	private String employeePhone;
	private String employeeAddress;
	private String employeeImage;
	
	public Employee toEntity() {
		return Employee.builder()
				.employeeEmail(employeeEmail)
				.employeeName(employeeName)
				.employeePhone(employeePhone)
				.employeeAddress(employeeAddress)
				.employeeImage(employeeImage)
				.build();
	}
}
