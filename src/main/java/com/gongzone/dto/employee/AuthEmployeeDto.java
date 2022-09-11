package com.gongzone.dto.employee;

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
public class AuthEmployeeDto {
	private Long employeeId;
	private String employeeName;
	private String employeePassword;
	private String employeeAddress;
	private String employeeEmail;
	private String employeePhone;
	private String employeeHiredate;
	private String employeeImage;
	private EmployeeRole employeeRole;
	
	@Getter
	public static class AuthEmployeeRequest {
		private Long employeeId;
		private String employeeName;
		private String employeePassword;
		private String employeeAddress;
		private String employeeEmail;
		private String employeePhone;
		private String employeeHiredate;
		private String employeeImage;
		private EmployeeRole employeeRole;
		
		/* DTO -> Entity */
		public Employee toEntity(PasswordEncoder passwordEncoder) {
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
	
	@Getter
	@Builder
	public static class AuthEmployeeResponse {
		private Long employeeId;
		private String employeeName;
		private String employeePassword;
		private String employeeAddress;
		private String employeeEmail;
		private String employeePhone;
		private String employeeHiredate;
		private String employeeImage;
		private EmployeeRole employeeRole;
		
		/* Entity -> Dto */
		public static AuthEmployeeResponse of(Employee employee) {
			return AuthEmployeeResponse.builder()
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
	
	

	
}
