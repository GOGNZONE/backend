package com.gongzone.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사원 엔티티
 * @author kimmingyu
 * @version 1.0
 */
@Entity
@Table(name = "employee")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "employee_name", length = 20)
	@NotNull(message = "name must not be null")
	private String employeeName;
	
	@Column(name = "employee_password", length = 20, nullable = false)
	private String employeePassword;
	
	@Column(name = "employee_address", length = 80)
	private String employeeAddress;

	@Column(name = "employee_email", length = 30, unique = true)
	private String employeeEmail;
	
	@Column(name = "employee_phone", length = 18 ,unique = true)
	private String employeePhone;
	
	@CreatedDate
	@Column(name = "employee_hiredate", nullable = false)
	private LocalDate employeeHiredate;
	
	@Column(name = "employee_role", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private EmployeeRole employeeRole;
	
	@Column(name = "employee_image", columnDefinition = "TEXT")
	private String employeeImage;
	
	/**
	 * 유저 수정
	 * 
	 * 
	 * @param {employeeName, employeePhone, employeeAddress, emmployeeEmail}
	 * @return void
	 */
	public void updateEmployeeInfo(
			String employeeName,
			String employeePhone,
			String employeeAddress,
			String employeeEmail) {
		this.employeeName = employeeName;
		this.employeePhone = employeePhone;
		this.employeeAddress = employeeAddress;
		this.employeeEmail = employeeEmail;
	}
	
	/**
	 * 패스워드 재설정
	 * @throws AuthorizationException  authKey가 employeeId와 일치 하지 않습니다.
	 * 
	 * @param {employeePassword}
	 * @return void
	 */
	public void updateEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	
}
