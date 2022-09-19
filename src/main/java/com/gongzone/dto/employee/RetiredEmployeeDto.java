package com.gongzone.dto.employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;

import com.gongzone.entity.employee.EmployeeRole;
import com.gongzone.entity.employee.RetiredEmployee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 퇴사자 정보에 관한 DTO
 * @author kimmingyu
 * @version 1.0
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RetiredEmployeeDto {

	private Long employeeId;
	private String employeeName;
	private String employeeAddress;
	private String employeeEmail;
	private String employeePhone;
	private String employeeHiredate;
	private String employeeRetiredDate;
	private EmployeeRole employeeRole;
	private String employeeImage;
	
	@AllArgsConstructor
	@NoArgsConstructor
	public static class RetiredEmployeeRequest {
		private Long employeeId;
		private String employeeName;
		private String employeeAddress;
		private String employeeEmail;
		private String employeePhone;
		private String employeeHiredate;
		private EmployeeRole employeeRole;
		private String employeeImage;
		
		/* DTO -> Entity */
		public RetiredEmployee toEntity() {
			RetiredEmployee retiredEmployee = RetiredEmployee.builder()
					.employeeId(employeeId)
					.employeeName(employeeName)
					.employeeAddress(employeeAddress)
					.employeeEmail(employeeEmail)
					.employeePhone(employeePhone)
					.employeeHiredate(employeeHiredate)
					.employeeRole(employeeRole)
					.employeeImage(employeeImage)
					.build();
			return retiredEmployee;
		}

	}
	
	@Getter
	public static class RetiredEmployeeResponse {
		private Long employeeId;
		private String employeeName;
		private String employeeAddress;
		private String employeeEmail;
		private String employeePhone;
		private String employeeHiredate;
		private String employeeRetiredDate;
		private EmployeeRole employeeRole;
		private String employeeImage;
		
		/* Entity -> DTO */
		public RetiredEmployeeResponse(RetiredEmployee retiredEmployee) {
			this.employeeId = retiredEmployee.getEmployeeId();
			this.employeeName = retiredEmployee.getEmployeeName();
			this.employeeAddress = retiredEmployee.getEmployeeAddress();
			this.employeeEmail = retiredEmployee.getEmployeeEmail();
			this.employeePhone = retiredEmployee.getEmployeePhone();
			this.employeeHiredate = retiredEmployee.getEmployeeHiredate();
			this.employeeRetiredDate = retiredEmployee.getEmployeeRetiredDate();
			this.employeeRole = retiredEmployee.getEmployeeRole();
			this.employeeImage = retiredEmployee.getEmployeeImage();
		}
	}

}
