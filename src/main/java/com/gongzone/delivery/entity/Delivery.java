package com.gongzone.delivery.entity;

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
 * 택배 엔티티
 * @author Hanju Park
 * @version 1.0
 * */
@Entity
@Table(name = "delivery")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Delivery {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id")
	private Long deliveryId;
	
	@Column(name = "delivery_company_name", length = 30)
	@NotNull(message = "delivery company name cannot be null")
	private String deliveryCompanyName;
	
	@Column(name = "delivery_tracking_number", length = 30)
	@NotNull(message = "delivery tracking number cannot be null")
	private String deliveryTrackingNumber;
	
}