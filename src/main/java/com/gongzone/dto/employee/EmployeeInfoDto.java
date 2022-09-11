package com.gongzone.dto.employee;

import com.gongzone.entity.employee.Employee;
import com.gongzone.entity.employee.EmployeeRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
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
public class EmployeeInfoDto {
	
	private Long employeeId;
	private String employeeName;
	private String employeeAddress;
	private String employeeEmail;
	private String employeePhone;
	private String employeeHiredate;
	private String employeeImage;
	private EmployeeRole employeeRole;
	
	public static class EmployeeInfoRequest {
		private Long employeeId;
		private String employeeName;
		private String employeeAddress;
		private String employeeEmail;
		private String employeePhone;
		private String employeeHiredate;
		private String employeeImage;
		private EmployeeRole employeeRole; 
		
		/* DTO -> Entity */
		public Employee toEntity() {
			Employee employee = Employee.builder()
					.employeeId(employeeId)
					.employeeName(employeeName)
					.employeeAddress(employeeAddress)
					.employeeEmail(employeeEmail)
					.employeePhone(employeePhone)
					.employeeHiredate(employeeHiredate)
					.employeeImage(employeeImage)
					.employeeRole(employeeRole)
					.build();
			return employee;
		}
	}
	
	@Getter
	public static class EmployeeInfoResponse {
		private Long employeeId;
		private String employeeName;
		private String employeeAddress;
		private String employeeEmail;
		private String employeePhone;
		private String employeeHiredate;
		private String employeeImage;
		private EmployeeRole employeeRole;
		
		/* Entity -> DTO */
		public EmployeeInfoResponse(Employee employee) {
			this.employeeId = employee.getEmployeeId();
			this.employeeName = employee.getEmployeeName();
			this.employeeAddress = employee.getEmployeeAddress();
			this.employeeEmail = employee.getEmployeeEmail();
			this.employeePhone = employee.getEmployeePhone();
			this.employeeHiredate = employee.getEmployeeHiredate();
			this.employeeImage = employee.getEmployeeImage();
			this.employeeRole = employee.getEmployeeRole();
		}
	}
}
