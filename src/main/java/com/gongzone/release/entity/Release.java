package com.gongzone.release.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gongzone.client.entity.Client;
import com.gongzone.delivery.entity.Delivery;
import com.gongzone.production.entity.Production;
import com.gongzone.release.dto.ReleaseDto;
//import com.gongzone.vehicle.entity.Vehicle;

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
@IdClass(ReleaseId.class)
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
	@JoinColumn(name="fk_client_id", nullable = true)
	@JsonIgnore
	private Client client;
	
	@Id
	@ManyToOne
	@JoinColumn(name="fk_production_id")
	@JsonIgnore
	private Production production;
	
	@ManyToOne
	@JoinColumn(name = "fk_delivery_id", nullable = true)
	@JsonIgnore
	private Delivery delivery;
	
//	@ManyToOne
//	@JoinColumn(name = "fk_vehicle_id", nullable = true)
//	@JsonIgnore
//	private Vehicle vehicle;
	
	
	/**
	 * 출고 현황 수정 메서드
	 * @param { releaseDto }
	 * @return void
	 * */
	public void updateRelease(ReleaseDto releaseDto) {
		this.releaseDate = releaseDto.getReleaseDate();
		this.releaseDescription = releaseDto.getReleaseDescription();
		this.releaseQuantity = releaseDto.getReleaseQuantity();
		this.releaseTotalPrice = releaseDto.getReleaseTotalPrice();
		this.releaseType = releaseDto.getReleaseType();
	}
	
}
