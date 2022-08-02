package com.gongzone.release.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gongzone.delivery.entity.Delivery;
import com.gongzone.vehicle.entity.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 출고 엔티티
 * @author Hanju Park
 * @version 1.0
 * */
@Entity
@Table(name = "`release`")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Release {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "release_id")
	private Long releaseId;
	
	@Column(name = "release_date")
	@NotNull(message = "release date cannot be null")
	private String releaseDate;
	
	@Column(name = "release_description", columnDefinition = "TEXT")
	private String releaseDescription;
	
	@Column(name = "release_quantity")
	@NotNull(message = "release quantity cannot be null")
	@ColumnDefault("0")
	private int releaseQuantity;
	
	@Column(name = "release_total_price")
	@NotNull(message = "release total price cannot be null")
	@ColumnDefault("0")
	private Long releaseTotalPrice;
	
	@Column(name = "release_type", columnDefinition = "ENUM('DELIVERY', 'VEHICLE')")
	@Enumerated(value = EnumType.STRING)
	@NotNull(message = "release type cannot be null")
	private ReleaseType releaseType;
	
	@ManyToOne
	@JoinColumn(name = "deliveryId", nullable = true)
	@JsonIgnore
	private Delivery delivery;
	
	@ManyToOne
	@JoinColumn(name = "vehicleId", nullable = true)
	@JsonIgnore
	private Vehicle vehicle;
	
}