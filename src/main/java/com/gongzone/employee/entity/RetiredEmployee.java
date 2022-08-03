package com.gongzone.employee.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 퇴사자 엔티티
 * @author kimmingyu
 * @version 1.0
 */
@Entity
@Table(name = "retired_employee")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class RetiredEmployee {
	
	@Id
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "employee_name", length = 20)
	@NotNull(message = "name must not be null")
	private String employeeName;
	
	@Column(name = "employee_address", length = 80)
	@ColumnDefault("NULL")
	private String employeeAddress;

	@Column(name = "employee_email", length = 30, unique = true)
	private String employeeEmail;
	
	@Column(name = "employee_phone", length = 18 ,unique = true)
	private String employeePhone;
	
	@Column(name = "employee_hiredate")
	@NotNull(message = "hiredate must not be null")
	private String employeeHiredate;
	
	@CreatedDate
	@Column(name = "employee_retired_date")
	@NotNull(message = "retired_date must not be null")
	private String employeeRetiredDate;
	
	@Column(name = "employee_role")
	@Enumerated(value = EnumType.STRING)
	@NotNull(message = "employee role must not be null")
	@ColumnDefault("'STAFF'")
	private EmployeeRole employeeRole;
	
	@Column(name = "employee_image", columnDefinition = "TEXT")
	@ColumnDefault("NULL")
	private String employeeImage;
	
	
}
