package com.gongzone.employee.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gongzone.client.entity.Client;

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
	
	@Column(name = "employee_password", length = 20)
	@NotNull(message = "password must not be null")
	private String employeePassword;
	
	@Column(name = "employee_address", length = 80)
	@ColumnDefault("NULL")
	private String employeeAddress;

	@Column(name = "employee_email", length = 30, unique = true)
	private String employeeEmail;
	
	@Column(name = "employee_phone", length = 18 ,unique = true)
	private String employeePhone;
	
	@CreatedDate
	@Column(name = "employee_hiredate")
	@NotNull(message = "hiredate must not be null")
	private LocalDate employeeHiredate;
	
	@Column(name = "employee_role")
	@Enumerated(value = EnumType.STRING)
	@NotNull(message = "employee role must not be null")
//	@ColumnDefault("'STAFF'")
	private EmployeeRole employeeRole;
	
	@Column(name = "employee_image", columnDefinition = "TEXT")
	@ColumnDefault("NULL")
	private String employeeImage;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonIgnore
	private List<Client> clients;
	
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