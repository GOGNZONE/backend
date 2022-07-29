package com.gongzone.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * 거래처 정보 엔티티
 * @author kimmingyu
 * @version 1.0
 */
@Entity
@Table(name = "client")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Long clientId;
	
	@Column(name = "client_name", length = 30)
	@NotNull(message = "client name must not be null")
	private String clientName;
	
	@Column(name = "client_manager", length = 20)
	@NotNull(message = "client manager must not be null")
	private String clientManager;
	
	
	@Column(name = "client_tel", length = 20)
	@NotNull(message = "client tel must not be null")
	private String clientTel;
	
	@Column(name = "client_address", length = 80)
	@NotNull(message = "client address must not be null")
	private String clientAddress;
	
	@CreatedDate
	@Column(name = "client_registered_date")
	@NotNull(message = "client registered date must not be null")
	private LocalDate clientRegisteredDate;
	
	@Column(name = "client_file", columnDefinition = "TEXT")
	private String clientFile;
	
	@ManyToOne
	@JoinColumn(name = "employeeId", nullable = true)
	@JsonIgnore
	private Employee employee;
	
}
