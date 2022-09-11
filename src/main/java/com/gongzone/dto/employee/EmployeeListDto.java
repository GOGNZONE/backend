package com.gongzone.dto.employee;

import com.gongzone.entity.employee.Employee;
import com.gongzone.entity.employee.EmployeeRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사원 목록 DTO
 * @author kimmingyu
 * @version 1.0
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeListDto {
	
	private Long employeeId;
	private String employeeName;
	private String employeeAddress;
	private String employeeEmail;
	private String employeePhone;
	private String employeeHiredate;
	private EmployeeRole employeeRole;
	
	@Getter
	public static class EmployeeListResponse{
		private Long employeeId;
		private String employeeName;
		private String employeeAddress;
		private String employeeEmail;
		private String employeePhone;
		private String employeeHiredate;
		private EmployeeRole employeeRole;
		
		/* Entity -> DTO */
		public EmployeeListResponse(Employee employee) {
			this.employeeId = employee.getEmployeeId();
			this.employeeName = employee.getEmployeeName();
			this.employeeAddress = employee.getEmployeeAddress();
			this.employeeEmail = employee.getEmployeeEmail();
			this.employeePhone = employee.getEmployeePhone();
			this.employeeHiredate = employee.getEmployeeHiredate();
			this.employeeRole = employee.getEmployeeRole();
		}
	}
}
