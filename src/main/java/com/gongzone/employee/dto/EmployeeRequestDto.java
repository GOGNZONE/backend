package com.gongzone.employee.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

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
public class EmployeeRequestDto {

	private Long employeeId;
	private String employeeName;
	private String employeePassword;
	private String employeeAddress;
	private String employeeEmail;
	private String employeePhone;
	private String employeeHiredate;
	private String employeeImage;
	private EmployeeRole employeeRole;
	
	public Employee toEmployee(PasswordEncoder passwordEncoder) {
		return Employee.builder()
				.employeeId(employeeId)
				.employeeName(employeeName)
				.employeePassword(passwordEncoder.encode(employeePassword))
				.employeeAddress(employeeAddress)
				.employeeEmail(employeeEmail)
				.employeePhone(employeePhone)
				.employeeHiredate(employeeHiredate)
				.employeeImage(employeeImage)
				.employeeRole(employeeRole)
				.build();
	}
	
	public UsernamePasswordAuthenticationToken toAuthentication() {
		return new UsernamePasswordAuthenticationToken(employeeEmail, employeePassword);
	}
}
