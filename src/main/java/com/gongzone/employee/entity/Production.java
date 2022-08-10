package com.gongzone.employee.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 생산 엔티티
 * @author Hanju Park
 * @version 1.0
 * */
@Entity
@Table(name = "production")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Production {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "production_id")
	private Long productionId;
	
	@Column(name = "production_name", length = 30)
	@NotNull(message = "production name cannot be null")
	private String productionName;
	
	@Column(name = "production_brand_name", length = 30)
	private String productionBrandName;
	
	@Column(name = "production_price")
	@NotNull(message = "production price cannot be null")
	@ColumnDefault("0")
	private Long productionPrice;
	
	@Column(name = "production_quantity")
	@NotNull(message = "production quantity cannot be null")
	@ColumnDefault("0")
	private int productionQuantity;
	
	@Column(name = "production_file", length = 80)
	private String productionFile;
	
	@Column(name = "production_standard", length = 10)
	private String productionStandard;
	
	@Column(name = "production_unit", length = 10)
	private String productionUnit;
	
	@Column(name = "production_description", columnDefinition = "TEXT")
	private String productionDescription;
	
	@Column(name = "production_released_date")
	@NotNull(message = "production released date cannot be null")
	private LocalDate productionReleasedDate;
	
	@Column(name = "production_date")
	@NotNull(message = "production date cannot be null")
	private LocalDate productionDate;
	
	@ManyToOne
	@JoinColumn(name = "clientId", nullable = true)
	@JsonIgnore
	private Client client;
	
}