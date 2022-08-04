package com.gongzone.employee.entity;
<<<<<<<< HEAD:src/main/java/com/gongzone/employee/entity/Employee.java

========
>>>>>>>> 0b38bee5e7b7986e09a35c478d47688d37672def:src/main/java/com/gongzone/employee/entity/RetiredEmployee.java

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

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
<<<<<<<< HEAD:src/main/java/com/gongzone/employee/entity/Employee.java
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
========
@EntityListeners(AuditingEntityListener.class)
public class RetiredEmployee {
	
	@Id

>>>>>>>> 0b38bee5e7b7986e09a35c478d47688d37672def:src/main/java/com/gongzone/employee/entity/RetiredEmployee.java
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "employee_name", length = 20)
	@NotNull(message = "name must not be null")
	private String employeeName;
	
<<<<<<<< HEAD:src/main/java/com/gongzone/employee/entity/Employee.java
	@Column(name = "employee_password", length = 100)
	@NotNull(message = "password must not be null")
	private String employeePassword;
	
========

>>>>>>>> 0b38bee5e7b7986e09a35c478d47688d37672def:src/main/java/com/gongzone/employee/entity/RetiredEmployee.java
	@Column(name = "employee_address", length = 80)
	@ColumnDefault("NULL")
	private String employeeAddress;

	@Column(name = "employee_email", length = 30, unique = true)
	private String employeeEmail;
	
	@Column(name = "employee_phone", length = 18 ,unique = true)
	private String employeePhone;
	
<<<<<<<< HEAD:src/main/java/com/gongzone/employee/entity/Employee.java
	@Column(name = "employee_hiredate")
	@NotNull(message = "hiredate must not be null")
	private String employeeHiredate;
========

	@Column(name = "employee_hiredate")
	@NotNull(message = "hiredate must not be null")
	private String employeeHiredate;
	
	@CreatedDate
	@Column(name = "employee_retired_date")
	@NotNull(message = "retired_date must not be null")
	private String employeeRetiredDate;

>>>>>>>> 0b38bee5e7b7986e09a35c478d47688d37672def:src/main/java/com/gongzone/employee/entity/RetiredEmployee.java
	
	@Column(name = "employee_role")
	@Enumerated(value = EnumType.STRING)
	@NotNull(message = "employee role must not be null")
	@ColumnDefault("'STAFF'")
	private EmployeeRole employeeRole;
	
	@Column(name = "employee_image", columnDefinition = "TEXT")
	@ColumnDefault("NULL")
	private String employeeImage;
	
	/**
	 * 사원 수정
	 * @param {UpdateEmployeeDto}
	 * @return void
	 */
	public void updateEmployeeInfo(Employee employee) {
		this.employeeName = employee.getEmployeeName();
		this.employeePhone = employee.getEmployeePhone();
		this.employeeAddress = employee.getEmployeeAddress();
		this.employeeEmail = employee.getEmployeeEmail();
	}
	
	/**
	 * 패스워드 재설정
	 * @param {employeePassword}
	 * @return void
	 */
	public void updateEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	
}