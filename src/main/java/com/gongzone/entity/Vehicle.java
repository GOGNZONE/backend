package com.gongzone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 차량 엔티티
 * @author Hanju Park
 * @version 1.0
 * */ 
@Entity
@Table(name = "vehicle")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Long vehicleId;
	
	@Column(name = "vehicle_number", length = 10)
	@NotNull
	private String vehicleNumber;
	
	@Column(name = "vehicle_type", length = 10)
	private String vehicleType;
	
}