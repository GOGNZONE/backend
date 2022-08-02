package com.gongzone.employee.dto.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gongzone.employee.entity.Employee;
import com.gongzone.employee.entity.EmployeeRole;

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
	private String employeeEmail;
	private String employeePassword;
	private String employeeAddress;
	private String employeePhone;
	private String employeeHiredate;
	private String employeeImage;
	
	public Employee toEmployee(PasswordEncoder passwordEncoder) {
		return Employee.builder()
				.employeeId(employeeId)
				.employeeName(employeeName)
				.employeeEmail(employeeEmail)
				.employeePassword(passwordEncoder.encode(employeePassword))
				.employeeAddress(employeeAddress)
				.employeePhone(employeePhone)
				.employeeHiredate(employeeHiredate)
				.employeeImage(employeeImage)
				.employeeRole(EmployeeRole.STAFF)
				.build();
	}
	
	public UsernamePasswordAuthenticationToken toAuthentication() {
		return new UsernamePasswordAuthenticationToken(employeeEmail, employeePassword);
	}
}
