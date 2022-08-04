package com.gongzone.employee.dto;

import com.gongzone.employee.entity.EmployeeRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
}
