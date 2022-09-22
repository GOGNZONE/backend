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
public class ChangePasswordDto {
	private String newPassword;
	private String confirmPassword;
	
	/* DTO -> Entity */
	public Employee toEntity() {
		return Employee.builder()
				.employeePassword(newPassword)
				.build();
	}
}
