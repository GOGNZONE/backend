package com.gongzone.release.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "t_delivery")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "택배")
public class Delivery {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id")
	@Schema(description = "택배 ID")
	private Long deliveryId;
	
	@Column(name = "delivery_company_name", length = 30)
	@NotNull(message = "delivery company name cannot be null")
	@Schema(description = "택배사 이름", nullable = false)
	private String deliveryCompanyName;
	
	@Column(name = "delivery_tracking_number", length = 30)
	@NotNull(message = "delivery tracking number cannot be null")
	@Schema(description = "송장번호", nullable = false)
	private String deliveryTrackingNumber;
	
}